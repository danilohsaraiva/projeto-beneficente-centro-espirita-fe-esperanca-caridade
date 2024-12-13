package com.projetobeneficentecentroespiritafeesperancacaridadejavafx.model.dtos;

import com.projetobeneficentecentroespiritafeesperancacaridadejavafx.enuns.TipoAcesso;
import com.projetobeneficentecentroespiritafeesperancacaridadejavafx.model.Usuario;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UsuarioDto {
    private String login;
    private String senha;
    private TipoAcesso tipoAcesso;

    public Usuario toModel() {
        Usuario usuario = new Usuario();
        usuario.setLogin(this.login);
        usuario.setSenha(this.senha);
        usuario.setTipoAcesso(String.valueOf(this.tipoAcesso));
        return usuario;
    }
}