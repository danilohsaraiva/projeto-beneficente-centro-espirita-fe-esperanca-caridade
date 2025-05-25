package com.projetobeneficentecentroespiritafeesperancacaridadejavafx.model.dtos;

import com.projetobeneficentecentroespiritafeesperancacaridadejavafx.model.AnamneseAtendimentoPsicologico;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AnamneseAtendimentoPsicologicoDto {
    private String motivoConsultaDescricao;
    private String comorbidades;
    private String sintomas;
    private LocalDate tempoSintomas;  // Corrigido o tipo
    private String tratamentosAnteriores;
    private String medicamentosUso;
    private String alergias;
    private String observacao;

    public AnamneseAtendimentoPsicologico toModel() {
        AnamneseAtendimentoPsicologico anamnese = new AnamneseAtendimentoPsicologico();
        anamnese.setMotivoConsultaDescricao(this.motivoConsultaDescricao);
        anamnese.setComorbidades(this.comorbidades);
        anamnese.setSintomas(this.sintomas);
        anamnese.setTempoSintomas(this.tempoSintomas); // Corrigido aqui também
        anamnese.setTratamentosAnteriores(this.tratamentosAnteriores);
        anamnese.setMedicamentosUso(this.medicamentosUso);
        anamnese.setAlergias(this.alergias);
        anamnese.setObservacao(this.observacao);
        return anamnese;
    }
}
