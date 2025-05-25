package com.projetobeneficentecentroespiritafeesperancacaridadejavafx.model.dtos;

import com.projetobeneficentecentroespiritafeesperancacaridadejavafx.model.ConsultaPsicologica;

import java.time.LocalDate;

public class ConsultaPsicologicaDto {
    private String tipoAtendimento;
    private LocalDate dataConsulta;
    private Long fkPsicologoPlantonista;
    private String status;
    private Long fkProntuario;

    public ConsultaPsicologica toModel() {
        ConsultaPsicologica consulta = new ConsultaPsicologica();
        consulta.setTipoAtendimento(this.tipoAtendimento);
        consulta.setDataConsulta(this.dataConsulta);
        consulta.setFkPsicologoPlantonista(this.fkPsicologoPlantonista);
        consulta.setStatus(this.status);
        consulta.setFkProntuario(this.fkProntuario);
        return consulta;
    }
}
