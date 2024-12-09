package com.projetobeneficentecentroespiritafeesperancacaridadejavafx.dao;

import com.projetobeneficentecentroespiritafeesperancacaridadejavafx.conexao.ConexaoJPA;
import com.projetobeneficentecentroespiritafeesperancacaridadejavafx.model.Paciente;
import com.projetobeneficentecentroespiritafeesperancacaridadejavafx.model.dtos.PacienteDto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class PacienteDao {

    public static Paciente buscaPacientePorCPF(String cpf) {
        Paciente paciente = null;

        EntityManager manager = ConexaoJPA.getEntitityManager();

        Query query = manager.createQuery("SELECT p FROM Paciente p WHERE p.cpfPaciente = : cpf");
        query.setParameter("cpf", cpf);

        paciente = (Paciente) query.getSingleResult();

        manager.close();

        return paciente;
    }
    public static void adicionaPaciente(PacienteDto pacienteDto) {

    }
}
