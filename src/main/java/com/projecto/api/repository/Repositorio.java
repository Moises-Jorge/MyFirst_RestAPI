package com.projecto.api.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.projecto.api.model.Pessoa;

@Repository
public interface Repositorio extends CrudRepository<Pessoa, Integer> {
    
    List<Pessoa> findAll();

    /**
     * Subscrição do método "findBy()" para retornar os dados de uma pessoa através do atributo "codigo"
     * @param codigo
     * @return
     */
    Pessoa findByCodigo(int codigo);

    /**
     * Assinatura do método (subscrição) para ordenar a tabela "pessoas" através do nome
     * @return
     */
    List<Pessoa> findByOrderByNome();

    /**
     * Pesquisa pelo nome e ordena-os atraves da idade
     * @param nome
     * @return
     */
    List<Pessoa> findByNomeOrderByIdadeDesc(String nome);

    /**
     * Verifica se num determinado nome contem o termo/caracter especificado
     * @param termo
     * @return
     */
    List<Pessoa> findByNomeContaining(String termo);
}
