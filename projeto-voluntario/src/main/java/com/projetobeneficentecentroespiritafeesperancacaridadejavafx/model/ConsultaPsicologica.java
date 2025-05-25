package com.projetobeneficentecentroespiritafeesperancacaridadejavafx.model;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ConsultaPsicologica {
    @Column(name="id_atendimento")
    private  Long idAtendimento;
    @Column(name="tipo_atendimento")
    private String tipoAtendimento;
    @Column(name="data_consulta")
    private Date dataConsulta;
    @Column(name="fk_psicologo_plantonista")
    private Long fkPsicologoPlantonista;
    private String status;
    @Column(name="fk_prontuario")
    private Long fkProntuario;
}
