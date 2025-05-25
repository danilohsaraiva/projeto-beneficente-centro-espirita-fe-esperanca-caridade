package com.projetobeneficentecentroespiritafeesperancacaridadejavafx.dao;

import com.projetobeneficentecentroespiritafeesperancacaridadejavafx.conexao.ConexaoJPA;
import com.projetobeneficentecentroespiritafeesperancacaridadejavafx.model.Endereco;
import com.projetobeneficentecentroespiritafeesperancacaridadejavafx.model.Psicologo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

import java.util.ArrayList;
import java.util.List;

public class PsicologoDao {

    public List<Psicologo> buscaTodos() {
        EntityManager manager = ConexaoJPA.getEntitityManager();
        List<Psicologo> psicologos = null;

        try {
            Query query = manager.createQuery("SELECT p FROM Psicologo p", Psicologo.class);
            psicologos = query.getResultList();
        } catch (Exception e) {
            System.out.println("Erro ao buscar Psicólogos.");
            e.printStackTrace();
        } finally {
            if (manager.isOpen()) {
                manager.close();
            }
        }
        return psicologos;
    }
    public boolean adicionaPsicologo(Psicologo psicologo, Endereco endereco) {
        boolean ehAdicionado = false;

        EntityManager manager = ConexaoJPA.getEntitityManager();
        try {
            manager.getTransaction().begin();
            manager.persist(endereco);
            manager.flush();

            psicologo.setEndereco(endereco);
            manager.persist(psicologo);
            manager.getTransaction().commit();
            ehAdicionado = true;
        } catch (Exception e) {
            System.out.println("Erro ao adicionar Psicologo");
            if(manager.getTransaction().isActive()) {
                manager.getTransaction().rollback();
            }
            e.printStackTrace();
        }
        finally {
            manager.close();
        }
        return ehAdicionado;
    }

}
