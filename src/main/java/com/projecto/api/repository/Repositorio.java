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
     * Assinatura do método (subscrição) para ORDENAR a tabela "pessoas" através do nome
     * @return
     */
    List<Pessoa> findByOrderByNome();

    /**
     * Pesquisa pelo NOME e ORDENA-os atraves da IDADE
     * @param nome
     * @return
     */
    List<Pessoa> findByNomeOrderByIdadeDesc(String nome);

    /**
     * Verifica se num determinado nome CONTEM o termo/caracter especificado
     * @param termo
     * @return
     */
    List<Pessoa> findByNomeContaining(String termo);

    /**
     * Filtra nomes que COMECAM com o termo especificado
     * @param termo
     * @return
     */
    List<Pessoa> findByNomeStartsWith(String termo);
    
    /**
     * Filtra nomes que TERMINAM com o termo especificado
     * @param termo
     * @return
     */
    List<Pessoa> findByNomeEndsWith(String termo);
}
