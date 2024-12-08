package com.projetobeneficentecentroespiritafeesperancacaridadejavafx.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Atendimento {
    private Long idAtendimento;
    private Long fkProntuario;
    private Boolean tipoAtendimento;
    /*private Enum<Prioridade> prioridade;
    private Enum<StatusAtendimento> statusAtendimento;*/
    private String tratamento;
    private String diagnostico;
    private String observacao;
}
