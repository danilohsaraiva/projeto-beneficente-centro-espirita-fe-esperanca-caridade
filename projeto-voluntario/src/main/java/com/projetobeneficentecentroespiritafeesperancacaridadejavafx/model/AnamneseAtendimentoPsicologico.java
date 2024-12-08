package com.projetobeneficentecentroespiritafeesperancacaridadejavafx.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AnamneseAtendimentoPsicologico {
    private Long idAnamnesePsicologico;
    private String motivoConsultaDescricao;
    private String dataInicio;
    private String tempoSintomas;           //alterar tipo e nome
    private String fatoresAgravantes;
    private String medicamentosUso;
}
