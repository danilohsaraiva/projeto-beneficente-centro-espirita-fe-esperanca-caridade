package com.projetobeneficentecentroespiritafeesperancacaridadejavafx.model.dtos;

import com.projetobeneficentecentroespiritafeesperancacaridadejavafx.model.AnamneseAtendimendoClinico;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnamneseAtendimentoClinicoDto {
    private String sintomasAssociados;
    private String motivoConsultaDescricao;
    private String comorbidade;
    private LocalDate dataInicio;
    private String tratamentosAnteriores;
    private String usoMedicamento;
    private String alergias;
    private String pressaoArterial;
    private String glicemia;
    private String observacao;

    public AnamneseAtendimendoClinico toModel() {
        AnamneseAtendimendoClinico anamnese = new AnamneseAtendimendoClinico();
        anamnese.setSintomasAssociados(this.sintomasAssociados);
        anamnese.setMotivoConsultaDescricao(this.motivoConsultaDescricao);
        anamnese.setComorbidade(this.comorbidade);
        anamnese.setDataInicio(this.dataInicio);
        anamnese.setTratamentosAnteriores(this.tratamentosAnteriores);
        anamnese.setUsoMedicamento(this.usoMedicamento);
        anamnese.setAlergias(this.alergias);
        anamnese.setPressaoArterial(this.pressaoArterial);
        anamnese.setGlicemia(this.glicemia);
        anamnese.setObservacao(this.observacao);
        return anamnese;
    }
}
