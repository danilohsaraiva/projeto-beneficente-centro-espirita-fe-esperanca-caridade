package com.projetobeneficentecentroespiritafeesperancacaridadejavafx.model.dtos;

import com.projetobeneficentecentroespiritafeesperancacaridadejavafx.model.ConsultaMedica;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConsultaMedicaDto {
    private LocalDate dataConsulta;
    private String status;
    private Long fkMedicoPlantao;
    private Long fkProntuarioPaciente;

    public ConsultaMedica toModel() {
        ConsultaMedica consulta = new ConsultaMedica();
        consulta.setDataConsulta(this.dataConsulta);
        consulta.setStatus(this.status);
        consulta.setFkMedicoPlantao(this.fkMedicoPlantao);
        consulta.setFkProntuarioPaciente(this.fkProntuarioPaciente);
        return consulta;
    }
}
