package com.projetobeneficentecentroespiritafeesperancacaridadejavafx.model.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UsuarioDto {
    private String usuario;
    private String senha;
}