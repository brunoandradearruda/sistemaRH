package com.seplagpb.recursoshumanos.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Servidor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String sexo;
    private String CPF;
    private String identidade;
    private String orgaoExpeditor;
    private String dataNascimento;
    private String PisPasep;
    private String endereco;
    private String bairro;
    private String CEP;
    private String cidade;
    private String estado;
    private String email;
    private String celular;
    private String matricula;
    private String dataAdmissão;
    private String cargo;
    private String simbolo;
    private String funcao;
    private String setor;


    }




