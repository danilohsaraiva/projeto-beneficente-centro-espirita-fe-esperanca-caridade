package com.projetobeneficentecentroespiritafeesperancacaridadejavafx.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ConsultaMedica {
    private Long idConsultaMedica;
    private LocalDate dataConsulta;
    private Long fkMedicoPlantao;
}
