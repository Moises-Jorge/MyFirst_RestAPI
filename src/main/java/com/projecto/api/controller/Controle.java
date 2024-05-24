package com.projecto.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controle {
    
    // First Route
    @GetMapping("")
    public String mensagem() {
        return "Hello World";
    }

    // Second Route
    @GetMapping("/boasVindas/{nome}")
    public String boasVindas(@PathVariable String nome) {
        return "Seja bem vindo(a)" + nome;
    }
}
