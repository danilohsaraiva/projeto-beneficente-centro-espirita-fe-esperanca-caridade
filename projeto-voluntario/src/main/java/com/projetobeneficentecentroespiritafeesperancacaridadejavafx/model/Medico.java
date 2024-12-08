package com.projetobeneficentecentroespiritafeesperancacaridadejavafx.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Medico {
    private Long idMedico;
    private String nomeMedico;
    private String cpfMedico;
    private LocalDate dataNascimentoMedico;
    private String sexo;
    private Long fkEndereco;
    private String telefoneMedico;
    private String emailMedico;
    private String crm;
    private String ufRegistroCrm;
    private String especilidadeMedico;
    private Long fkUsuario;
    private String rgMedico;
    private String ufRgMedico;
}
