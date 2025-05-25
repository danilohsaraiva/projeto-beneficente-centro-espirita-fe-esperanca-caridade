package com.projetobeneficentecentroespiritafeesperancacaridadejavafx.model;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AnamneseAtendimentoPsicologico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_anamnese_psicologico")
    private Long idAnamnesePsicologico;
    @Column(name="fk_atendimento_psicologico")
    private Long fkAtendimentoPsicologico;
    @Column(name="motivo_consulta-descricao")
    private String motivoConsultaDescricao;
    private String comorbidades;
    private String sintomas;
    @Column(name="tempo_sinstomas")
    private Date tempoSintomas;           //alterar tipo e nome
    @Column(name="tratamentos_anteriores")
    private String tratamentosAnteriores;
    @Column(name="medicamentos_uso")
    private String medicamentosUso;
    private String alergias;
    private String observacao;
}
