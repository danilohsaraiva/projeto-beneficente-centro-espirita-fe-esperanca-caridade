package com.projetobeneficentecentroespiritafeesperancacaridadejavafx.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AnamneseAtendimendoClinico {
    private Long idAnamneseClinico;
    private String motivoConsultaDescricao;
    private LocalDate dataInicio;
    private String sintomasAssociados;
    private String tratamentosAnteriores;
    private String usoMedicamento;
}
