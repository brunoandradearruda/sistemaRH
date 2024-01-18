package com.seplagpb.recursoshumanos.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Servidor {

    private LocalDate dataProximasFerias;
    private LocalDate dataAdmissao;

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
//    private LocalDate dataAdmissao; // Mantenha apenas este campo
    private String cargo;
    private String simbolo;
    private String funcao;
    private String setor;





    public LocalDate calcularProximasFerias() {
        LocalDate dataAtual = LocalDate.now();
        long mesesTrabalhados = ChronoUnit.MONTHS.between(this.dataAdmissao, dataAtual);

        if (mesesTrabalhados < 12) {
            return null; // Ainda não tem direito a férias
        } else if (mesesTrabalhados == 12) {
            return this.dataAdmissao.plusYears(1); // Primeiras férias após 1 ano
        } else {
            long periodosDeOnzeMeses = (mesesTrabalhados - 12) / 11;
            return this.dataAdmissao.plusYears(1).plusMonths(11 * periodosDeOnzeMeses);
        }
    }

    public LocalDate getDataProximasFerias() {
        return dataProximasFerias;
    }

    public void setDataProximasFerias(LocalDate dataProximasFerias) {
        this.dataProximasFerias = dataProximasFerias;
    }
}