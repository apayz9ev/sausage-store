package com.yandex.practicum.devops;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RestController
public class SausageApplication {

    public static void main(String[] args) {
        SpringApplication.run(SausageApplication.class, args);
    }

    // GET /sausages — возвращает список колбас в формате JSON
    @GetMapping("/sausages")
    public List<String> getSausages() {
        return List.of(
            "Русская",
            "Молочная",
            "Мюнхенская",
            "Нюрнбергская",
            "Особая"
        );
    }
}
