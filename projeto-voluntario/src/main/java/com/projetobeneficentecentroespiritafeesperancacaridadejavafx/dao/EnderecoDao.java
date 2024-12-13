package com.projetobeneficentecentroespiritafeesperancacaridadejavafx.dao;

import com.projetobeneficentecentroespiritafeesperancacaridadejavafx.conexao.ConexaoJPA;
import com.projetobeneficentecentroespiritafeesperancacaridadejavafx.model.Endereco;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.util.ArrayList;
import java.util.List;

public class EnderecoDao {
    public static boolean adicionaEndereco(Endereco endereco) {
        boolean ehAdicionado = false;

        EntityManager manager = ConexaoJPA.getEntitityManager();

        try {
            manager.getTransaction().begin();
            manager.persist(endereco);
            manager.getTransaction().commit();
            ehAdicionado = true;
        } catch (Exception e) {
            manager.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            manager.close();
        }
        return ehAdicionado;
    }

    public static List<Endereco> buscaEndereco(Long idPaciente) {
        List<Endereco> enderecos;

        EntityManager manager = ConexaoJPA.getEntitityManager();

        try {
            Query query = manager.createQuery("SELECT p.enderecos FROM Paciente p WHERE p.id = :idPaciente", Endereco.class);
            query.setParameter("idPaciente", idPaciente);
            enderecos = query.getResultList();

        } catch (Exception e) {
            enderecos = new ArrayList<>();
            e.printStackTrace();
        } finally {
            manager.close();
        }

        return enderecos;
    }
}
