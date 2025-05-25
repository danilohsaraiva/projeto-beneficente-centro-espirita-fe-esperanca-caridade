package com.projetobeneficentecentroespiritafeesperancacaridadejavafx.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ConsultaMedica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_consulta_medica")
    private Long idConsultaMedica;
    @Column(name="data_consulta")
    private LocalDate dataConsulta;
    private String status;
    @Column(name="fk_medico_plantao")
    private Long fkMedicoPlantao;
    @Column(name="fk_prontuario_paciente")
    private Long fkProntuarioPaciente;
}
