package com.projetobeneficentecentroespiritafeesperancacaridadejavafx.dao;

import com.projetobeneficentecentroespiritafeesperancacaridadejavafx.conexao.ConexaoJPA;
import com.projetobeneficentecentroespiritafeesperancacaridadejavafx.model.Endereco;
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

    public static void adicionaPacienteComEndereco(Paciente paciente, Endereco endereco) {
        EntityManager manager = ConexaoJPA.getEntitityManager();

        try {
            manager.getTransaction().begin();
            manager.persist(endereco);

            manager.flush();
            paciente.setEndereco(endereco);

            manager.persist(paciente);
            manager.getTransaction().commit();
        } catch (Exception e) {
            manager.getTransaction().rollback();

        } finally {
          manager.close();
        }
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

    public static boolean adicionaTelefoneContatoEmergencia(Long idPaciente, TelefoneContatoEmergencia telefoneContatoEmergencia) {
        boolean ehAdicionado = false;

        EntityManager manager = ConexaoJPA.getEntitityManager();

        try {
            manager.getTransaction().begin();

            Paciente paciente = manager.find(Paciente.class, idPaciente);

            if (paciente != null) {
                telefoneContatoEmergencia.setPaciente(paciente);
                manager.persist(telefoneContatoEmergencia);
                manager.getTransaction().commit();
                ehAdicionado = true;
            } else {
                System.out.println("Paciente com ID " + idPaciente + " não encontrado.");
                manager.getTransaction().rollback();
            }
        } catch (Exception e) {
            e.printStackTrace();
            if (manager.getTransaction().isActive()) {
                manager.getTransaction().rollback();
            }
        } finally {
            manager.close();
        }

        return ehAdicionado;
    }

    public static boolean removeTelefoneContatoEmergencia(Long idPaciente, Long idTelefoneContatoEmergencia) {
        boolean ehRemovido = false;

        EntityManager manager = ConexaoJPA.getEntitityManager();

        try {
            manager.getTransaction().begin();

            Paciente paciente = manager.find(Paciente.class, idPaciente);

            if (paciente != null) {
                TelefoneContatoEmergencia telefoneContatoEmergencia = manager.find(TelefoneContatoEmergencia.class, idTelefoneContatoEmergencia);

                if (telefoneContatoEmergencia != null && telefoneContatoEmergencia.getPaciente().getIdPaciente().equals(paciente.getIdPaciente())) {
                    manager.getTransaction().begin();
                    manager.remove(telefoneContatoEmergencia);
                    manager.getTransaction().commit();
                    ehRemovido = true;
                }
            } else {
                System.out.println("Paciente com ID " + idPaciente + " não encontrado.");
                manager.getTransaction().rollback();
            }
        } catch (Exception e) {
            e.printStackTrace();
            if (manager.getTransaction().isActive()) {
                manager.getTransaction().rollback();
            }
        } finally {
            manager.close();
        }

        return ehRemovido;
    }

    private static boolean adicionaEndereco(Long idPaciente, Endereco endereco) {
        boolean ehAdicionado = false;
            EntityManager manager = ConexaoJPA.getEntitityManager();

        try {
            Paciente paciente = manager.find(Paciente.class, idPaciente);

            if(paciente != null) {
                endereco.setPaciente(paciente);
                manager.getTransaction().begin();
                manager.persist(endereco);
                manager.getTransaction().commit();
                ehAdicionado = true;
            }

        } catch (Exception e) {
            if(manager.getTransaction().isActive()) {
                manager.getTransaction().rollback();
            }
            e.printStackTrace();
        }

        return ehAdicionado;
    }
}
