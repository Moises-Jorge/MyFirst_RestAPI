package com.projecto.api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "pessoas")
public class Pessoa {
    
    //START: Atiributts
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int codigo;
        private String nome;
        private int idade;
    //END: Atiributts

    //Start: Getter e Setter for 'codigo'
        public int getCodigo() {
            return codigo;
        }
        public void setCodigo(int codigo) {
            this.codigo = codigo;
        }
    //END: Getter e Setter for 'codigo'

    //Start: Getter e Setter for 'nome'
        public String getNome() { return nome; }
        public void setNome(String nome) { this.nome = nome; }
    //END: Getter e Setter for 'nome'

    //Start: Getter e Setter for 'idade'
        public int getIdade() { return idade; }
        public void setIdade(int idade) { this.idade = idade; }
    //END: Getter e Setter for 'idade'

}
