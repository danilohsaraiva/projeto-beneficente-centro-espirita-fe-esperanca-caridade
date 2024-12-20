package com.projetobeneficentecentroespiritafeesperancacaridadejavafx.model.dtos;

import com.projetobeneficentecentroespiritafeesperancacaridadejavafx.model.TelefoneContatoEmergencia;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class TelefoneContatoEmergenciaDto {

    private String nomeContatoEmergencia;
    private String telefoneContatoEmergencia;

    public TelefoneContatoEmergencia toModel() {
        TelefoneContatoEmergencia telefoneContatoEmergencia = new TelefoneContatoEmergencia();
        telefoneContatoEmergencia.setTelefoneContatoEmergencia(this.telefoneContatoEmergencia);
        telefoneContatoEmergencia.setNomeContatoEmergencia(this.nomeContatoEmergencia);
        return telefoneContatoEmergencia;
    }
}
