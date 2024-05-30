package com.projecto.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.projecto.api.model.Pessoa;
import com.projecto.api.repository.Repositorio;

@RestController
public class Controle {

    @Autowired
    private Repositorio acao;

    /**
     * Método Responsável por cadastrar um utilizador no banco de dados
     * @param objPessoa
     * @return
     */
    @PostMapping("/api") //O nome dessa rota poderia ser "/cadastrar" ja que se refere ao cadastro de utilizadores
    public Pessoa cadastrar(@RequestBody Pessoa objPessoa) {
        return acao.save(objPessoa);
    }

    /**
     * Método/Rota responsável por listar todos os dados da tabela Pessoas
     * @return
     */
    @GetMapping("/api")
    public List<Pessoa> selecionarPessoas() {
        return acao.findAll();
    }

    /**
     * Método/Rota responsável por retornar um utilizador através do código que é passado na URL
     * @param codigo
     * @return
     */
    @GetMapping("/api/{codigo}")
    public Pessoa selecionarPeloCodigo(@PathVariable int codigo) {
        return acao.findByCodigo(codigo);
    }
    
    // First Route: Route "/"
    @GetMapping("")
    public String mensagem() {
        return "Hello World";
    }

    // Second Route: Route "boasVindas"
    @GetMapping("/boasVindas/{nome}")
    public String boasVindas(@PathVariable String nome) {
        return "Seja bem vindo(a)" + nome;
    }

    // Third Route: Route Pessoa
    @PostMapping("/pessoa")
    public Pessoa pessoa(@RequestBody Pessoa pessoaP) {
        return pessoaP;
    }
}
