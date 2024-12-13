package com.projetobeneficentecentroespiritafeesperancacaridadejavafx.dao;

import com.projetobeneficentecentroespiritafeesperancacaridadejavafx.conexao.ConexaoJPA;
import com.projetobeneficentecentroespiritafeesperancacaridadejavafx.model.Paciente;
import com.projetobeneficentecentroespiritafeesperancacaridadejavafx.model.TelefoneContatoEmergencia;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class PacienteDao {

    public static Paciente buscaPacientePorCPF(String cpf) {
        Paciente paciente = null;

        EntityManager manager = ConexaoJPA.getEntitityManager();

        Query query = manager.createQuery("SELECT p FROM Paciente p WHERE p.cpfPaciente = : cpf");
        query.setParameter("cpf", cpf);

        try {
            paciente = (Paciente) query.getSingleResult();
        } catch (NoResultException e) {
            e.printStackTrace();
        }

        manager.close();

        return paciente;
    }

    public static boolean adicionaPaciente(Paciente paciente) {
        boolean ehAdicionado = false;
        EntityManager manager = ConexaoJPA.getEntitityManager();
        try {

            manager.getTransaction().begin();
            manager.persist(paciente);
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

    public static List<TelefoneContatoEmergencia> buscaListaContatoEmergencia(Long idPaciente) {
        List<TelefoneContatoEmergencia> telefonesEmergencia;
        EntityManager manager = ConexaoJPA.getEntitityManager();


        try {
            Query query = manager.createQuery("SELECT * FROM p.telefonesDeEmergencia WHERE p.idPaciente = :idPaciente", TelefoneContatoEmergencia.class);
            query.setParameter("idPaciente", idPaciente);
            telefonesEmergencia = query.getResultList();
        } catch (Exception e) {
            telefonesEmergencia = new ArrayList<>();
            e.printStackTrace();
        } finally {
            manager.close();
        }
        return telefonesEmergencia;
    }
}
