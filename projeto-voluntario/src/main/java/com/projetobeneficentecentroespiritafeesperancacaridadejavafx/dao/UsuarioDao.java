package com.projetobeneficentecentroespiritafeesperancacaridadejavafx.dao;

import com.projetobeneficentecentroespiritafeesperancacaridadejavafx.conexao.ConexaoJPA;
import com.projetobeneficentecentroespiritafeesperancacaridadejavafx.model.Usuario;
import com.projetobeneficentecentroespiritafeesperancacaridadejavafx.model.dtos.UsuarioDto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import lombok.Data;

@Data
public class UsuarioDao {
    public static Usuario buscaUsuarioPorDto(UsuarioDto usuarioDto) {

        Usuario usuario = null;

        EntityManager manager = ConexaoJPA.getEntitityManager();

        Query query = manager.createQuery("SELECT u FROM Usuario u WHERE u.login = :loginUsuario AND u.senha = :senhaUsuario");
        query.setParameter("loginUsuario", usuarioDto.getUsuario());
        query.setParameter("senhaUsuario", usuarioDto.getSenha());

        usuario = (Usuario) query.getSingleResult();
        System.out.println("Passei aqui");

        manager.close();

        return usuario;
    }

    public static Usuario buscaUsuarioPorId(Long id) {
        Usuario usuario = new Usuario();
        EntityManager manager = ConexaoJPA.getEntitityManager();

        try {
            usuario = manager.find(Usuario.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            manager.close();
        }

        return usuario;
    }

    //Não funcionando 100% pela CONSTRAINT na tabela Medico
    public static boolean deletaPorId(Long id) {
        boolean ehDeletado = false;

        EntityManager manager = ConexaoJPA.getEntitityManager();

        try {

            manager.getTransaction().begin();

            Usuario usuario = manager.find(Usuario.class, id);

            if (usuario != null) {
                manager.remove(usuario);
                ehDeletado = true;

            } else {
                System.out.println("Usuario não encontrado");
            }

            manager.getTransaction().commit();
        } catch (Exception e) {
            manager.getTransaction().rollback();
            throw e;
        } finally {
            manager.close();
        }

        return ehDeletado;
    }

    public static boolean criaUsuario(Usuario usuario) {
        boolean ehCriado = false;


        EntityManager manager = ConexaoJPA.getEntitityManager();

        try {
            manager.getTransaction().begin();
            manager.persist(usuario);
            manager.getTransaction().commit();
            ehCriado = true;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            manager.close();
        }

        return ehCriado;
    }

    public static boolean atualizaUsuario(Usuario usuario) {
        boolean ehAtualizado = false;

        EntityManager manager = ConexaoJPA.getEntitityManager();

        try {
            manager.getTransaction().begin();
            manager.merge(usuario);
            manager.getTransaction().commit();
            ehAtualizado = true;
            System.out.println(ehAtualizado);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return ehAtualizado;
    }
}
