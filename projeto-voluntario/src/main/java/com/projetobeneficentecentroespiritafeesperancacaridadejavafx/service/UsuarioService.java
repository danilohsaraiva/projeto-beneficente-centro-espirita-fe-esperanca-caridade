package com.projetobeneficentecentroespiritafeesperancacaridadejavafx.service;

import com.projetobeneficentecentroespiritafeesperancacaridadejavafx.dao.UsuarioDao;
import com.projetobeneficentecentroespiritafeesperancacaridadejavafx.enuns.TipoAcesso;
import com.projetobeneficentecentroespiritafeesperancacaridadejavafx.erro.UsuarioInvalidoException;
import com.projetobeneficentecentroespiritafeesperancacaridadejavafx.model.Usuario;
import com.projetobeneficentecentroespiritafeesperancacaridadejavafx.model.dtos.UsuarioDto;

public class UsuarioService {
    public static Usuario validaUsuario(UsuarioDto usuarioDto) {
        Usuario usuario;

        try {
            usuario = UsuarioDao.buscaUsuarioPorDto(usuarioDto);
            return usuario;

        } catch (UsuarioInvalidoException e) {
            usuario = null;
            e.printStackTrace();
        }

        return usuario;
    }

    public static boolean deletaUsuario(Long id) {
        return UsuarioDao.deletaPorId(id);
    }

    //Implementar com DTO adequado após desenvolver tela
    public static boolean criaUsuario(String login, String senha, TipoAcesso tipoAcesso) {
        boolean ehCriado = false;

        Usuario usuario = new Usuario();
        usuario.setLogin(login);
        usuario.setSenha(senha);

        switch (tipoAcesso) {
            //MED, PSI, ADM, SEC;
            case MED:
                usuario.setTipoAcesso("MED");
                break;
            case PSI:
                usuario.setTipoAcesso("PSI");
                break;
            case ADM:
                usuario.setTipoAcesso("ADM");
                break;
            case SEC:
                usuario.setTipoAcesso("SEC");
                break;
        }
        ehCriado = UsuarioDao.criaUsuario(usuario);

        return ehCriado;
    }

    public static boolean atualizaUsuario(Long id) {
        boolean ehAtualizado = false;
        Usuario usuario = UsuarioDao.buscaUsuarioPorId(id);

        return ehAtualizado = UsuarioDao.atualizaUsuario(usuario);
    }
}
