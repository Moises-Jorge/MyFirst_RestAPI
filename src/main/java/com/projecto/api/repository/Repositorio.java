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
}
