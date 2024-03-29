package com.seplagpb.recursoshumanos.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cargo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String simbolo;
    private String setor;

    public String getSimbolo() {

        return simbolo;
    }

    public void setSimbolo(String simbolo) {

        this.simbolo = simbolo;
    }

    public String getSetor() {

        return setor;
    }

    public void setSetor(String setor) {

        this.setor = setor;
    }

    public String getNome() {

        return nome;
    }

    public void setNome(String nome) {

        this.nome = nome;
    }


}
