package com.projetobeneficentecentroespiritafeesperancacaridadejavafx.dao;

import com.projetobeneficentecentroespiritafeesperancacaridadejavafx.conexao.ConexaoJPA;
import com.projetobeneficentecentroespiritafeesperancacaridadejavafx.model.Prontuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;

import java.time.LocalDate;

public class ProntuarioDao {
    public static Prontuario buscaProntuario(Long idPaciente) {
        Prontuario prontuario = null;

        EntityManager manager = ConexaoJPA.getEntitityManager();
        Query query = manager.createQuery("SELECT p FROM Prontuario WHERE p.idProntuario = :idPaciente");
        query.setParameter("idProntuario", idPaciente);

        try {
        prontuario = (Prontuario) query.getSingleResult();

        } catch (NoResultException e) {
            e.printStackTrace();
        } finally {
            manager.close();
        }
        return prontuario;
    }
}
