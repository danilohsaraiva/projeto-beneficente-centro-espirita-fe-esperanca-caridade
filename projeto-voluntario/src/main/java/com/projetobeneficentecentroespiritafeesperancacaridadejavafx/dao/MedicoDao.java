package com.projetobeneficentecentroespiritafeesperancacaridadejavafx.dao;

import com.projetobeneficentecentroespiritafeesperancacaridadejavafx.conexao.ConexaoJPA;
import com.projetobeneficentecentroespiritafeesperancacaridadejavafx.model.Endereco;
import com.projetobeneficentecentroespiritafeesperancacaridadejavafx.model.Medico;
import com.projetobeneficentecentroespiritafeesperancacaridadejavafx.model.dtos.MedicoDto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.util.ArrayList;
import java.util.List;

public class MedicoDao {
    public  List<Medico> buscaTodos() {
        List<Medico> medicos = new ArrayList<>();

        EntityManager manager = ConexaoJPA.getEntitityManager();

        try {
            Query query = manager.createQuery("SELECT m FROM Medico m", Medico.class);
            medicos = query.getResultList();

        } catch (Exception e) {
            System.out.println("Erro ao buscar Medicos");
            e.printStackTrace();
        } finally {
            if(manager != null) {
                manager.close();
            }
        }
        return medicos;
    }

    public boolean adicionarMedicoComEndereco(Medico medico, Endereco endereco) {
        boolean ehAdicionado = false;
        EntityManager manager = ConexaoJPA.getEntitityManager();
        try {
            manager.getTransaction().begin();
            manager.persist(endereco);

            manager.flush();

            medico.setEndereco(endereco);
            manager.persist(medico);
            manager.getTransaction().commit();
            ehAdicionado = true;


        } catch (Exception e) {
            System.out.println("Erro ao adicionar Médico");
            if(manager.getTransaction().isActive()) {
                manager.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            if(manager != null) {
                manager.close();
            }
        }
        return ehAdicionado;
    }
}
