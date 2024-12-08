package com.projetobeneficentecentroespiritafeesperancacaridadejavafx.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TelefoneContatoEmergencia {
    private Long idTelefoneContatoEmergencia;
    private String nomeCompletoEmergencia;
    private String telefoneContatoEmergencia;
}
