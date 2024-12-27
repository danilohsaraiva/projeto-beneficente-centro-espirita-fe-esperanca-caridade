package com.projetobeneficentecentroespiritafeesperancacaridadejavafx.model.dtos;

import com.projetobeneficentecentroespiritafeesperancacaridadejavafx.model.Limitacao;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LimitacaoDto {
    private boolean ehCognitiva;
    private boolean ehLocomocao;
    private boolean ehVisao;
    private boolean ehAudicao;
    private String outroDescricao;

    public Limitacao toModel() {
        Limitacao limitacao = new Limitacao();

        limitacao.setEhCognitiva(ehCognitiva);
        limitacao.setEhVisao(ehVisao);
        limitacao.setOutroDescricao(outroDescricao);
        limitacao.setEhLocomocao(ehLocomocao);
        limitacao.setEhAudicao(ehAudicao);

        return limitacao;
    }
}
