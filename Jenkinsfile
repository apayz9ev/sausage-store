pipeline {
    agent any
    triggers {
        pollSCM('H/5 * * * *')  // Каждые ~5 минут проверять GitHub
    }
    tools {
        maven 'Maven-3'  // замени на точное имя из Manage Jenkins → Tools
        jdk 'jdk-17'      // замени на точное имя из Manage Jenkins → Tools
    }
    stages {
        stage('Build & Test backend') {
            steps {
                dir("backend") {  // замени, если папка называется иначе
                    sh 'mvn clean package'
                }
            }
            post {
                success {
                    junit 'backend/target/surefire-reports/**/*.xml'
                }
            }
        }
        stage('Build frontend') {
            steps {
                dir("frontend") {  // замени, если папка называется иначе
                    sh 'npm install'
                    sh 'npm run build'  // проверь, что script "build" есть в package.json
                }
            }
        }
        stage('Save artifacts') {
            steps {
                archiveArtifacts(artifacts: 'backend/target/*.jar')
            }
            post {
                success {
                    sh '''
                        curl -X POST -H 'Content-type: application/json' \
                          --data '{"chat_id": "ТВОЙ_CHAT_ID", "text": "Сборка прошла успешно ✅"}' \
                          https://api.telegram.org/botТВОЙ_BOT_TOKEN/sendMessage
                    '''
                }
            }
        }
    }
}
