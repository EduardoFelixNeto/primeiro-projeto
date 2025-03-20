package com.exemplo.primeiroprojeto.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/api")
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello World!";
    }

    @GetMapping("/bemvindo/{nome}")
    public String bemVindo(@PathVariable String nome) {
        return "Bem-vindo, " + nome + "!";
    }
}
