package com.projetobeneficentecentroespiritafeesperancacaridadejavafx.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Limitacao {
    private Long idLimitacacao;
    private boolean ehCognitiva;
    private boolean ehLocomocao;
    private boolean ehVisao;
    private boolean ehAudicao;
    private String outroDescricao;
}
