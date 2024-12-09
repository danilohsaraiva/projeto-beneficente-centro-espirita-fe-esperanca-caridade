package com.projetobeneficentecentroespiritafeesperancacaridadejavafx.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Limitacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_limitacao")
    private Long idLimitacacao;
    @Column(name = "eh_cognitiva")
    private boolean ehCognitiva;
    @Column(name = "eh_locomocao")
    private boolean ehLocomocao;
    @Column(name = "eh_visao")
    private boolean ehVisao;
    @Column(name = "eh_audicao")
    private boolean ehAudicao;
    @Column(name = "outro_descricao")
    private String outroDescricao;
}
