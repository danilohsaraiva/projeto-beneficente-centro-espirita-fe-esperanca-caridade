package com.projetobeneficentecentroespiritafeesperancacaridadejavafx.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Paciente {

    private Long idPaciente;
    private String cpfPaciente;
    private String rgPaciente;
    private String nomePaciente;
    private LocalDate dataNascimentoPaciente;
    private String sexoBiologicoPaciente;
    private String estadoCivil;
    private String generoPaciente;
    private String emailPaciente;
    private String escolaridadePaciente;
    private String ocupacaoPaciente;
    private Long fkLimitação;
    private Long fkEndereco;
    private String naturalidade;
    private String nascionalidade;
    private String corRaca;
    private String cartaoNascionalSaude;
    private Long fkProntuario;
}
