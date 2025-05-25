package com.projetobeneficentecentroespiritafeesperancacaridadejavafx.model;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AnamneseAtendimendoClinico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_anamnese_clinico")
    private Long idAnamneseClinico;
    @Column(name="fk_consulta_medica")
    private Long fkConsultaMedica;
    @Column(name="sintomas_associados")
    private String sintomasAssociados;
    @Column(name="motivo_consulta_descricao")
    private String motivoConsultaDescricao;
    private String comorbidade;
    @Column(name="data_inicio_sintomas")
    private LocalDate dataInicio;
    @Column(name="tratamentos_anteriores")
    private String tratamentosAnteriores;
    @Column(name="uso_medicamento")
    private String usoMedicamento;
    private String alergias;
    @Column(name="pressao_arterial")
    private String pressaoArterial;
    private String glicemia;
    private String observacao;
}
