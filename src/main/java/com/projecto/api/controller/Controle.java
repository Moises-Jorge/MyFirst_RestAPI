package com.projecto.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.projecto.api.model.Pessoa;
import com.projecto.api.repository.Repositorio;

@RestController
public class Controle {

    @Autowired
    private Repositorio acao;

    /**
     * Método Responsável por CADASTRAR um utilizador no banco de dados
     * @param objPessoa
     * @return
     */
    @PostMapping("/api") //O nome dessa rota poderia ser "/cadastrar" ja que se refere ao cadastro de utilizadores
    public Pessoa cadastrar(@RequestBody Pessoa objPessoa) {
        return acao.save(objPessoa);
    }

    /**
     * Método/Rota responsável por LISTAR todos os dados da tabela Pessoas
     * @return
     */
    @GetMapping("/api")
    public List<Pessoa> selecionarPessoas() {
        return acao.findAll();
    }

    /**
     * Método/Rota responsável por RETORNAR UM UTILIZADOR através do código que é passado na URL
     * @param codigo
     * @return
     */
    @GetMapping("/api/{codigo}")
    public Pessoa selecionarPeloCodigo(@PathVariable int codigo) {
        return acao.findByCodigo(codigo);
    }

    /**
     * Método/Rota respondável por ACTUALIZAR os dados de um utilizador
     * @param objPessoa
     * @return
     */
    @PutMapping("/api")
    public Pessoa editarPessoa(@RequestBody Pessoa objPessoa) {
        return acao.save(objPessoa);
    }

    /**
     * Método/Rota responsável por APAGAR um registro da tabela "pessoas"
     * @param codigo
     */
    @DeleteMapping("/api/{codigo}")
    public void removerPessoa(@PathVariable int codigo) {
        Pessoa objPessoa = selecionarPeloCodigo(codigo);

        acao.delete(objPessoa);
    }

    /**
     * Método/Rota responsável por apresentar a QUANTIDADE de registros existentes na tabela "pessoas"
     * @return
     */
    @GetMapping("/api/contador")
    public long contadorPessoas() {
        return acao.count();
    }

    /**
     * Método/Rota resposável por ORDENAR a tabela de "pessoas" pelo "nome"
     * @return
     */
    @GetMapping("/api/ordenarNomes")
    public List<Pessoa> ordenarNomes() {
        return acao.findByOrderByNome();
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
