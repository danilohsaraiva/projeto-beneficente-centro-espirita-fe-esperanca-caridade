package com.projetobeneficentecentroespiritafeesperancacaridadejavafx.Conexao;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.sql.Connection;

public class ConexaoJPA {
    private static final String PERSISTENCE_UNIT = "Centro-Espirita-Fe-Esperanca-Caridade";
    private static EntityManagerFactory factory;
    private static EntityManager manager;

    public static EntityManager getEntitityManager() {
        if (factory == null || !factory.isOpen()) {
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
        }

        if (manager == null || !manager.isOpen()) {
            manager = factory.createEntityManager();
        }
        return manager;
    }

    public static void closeEntityManager() {
        if (manager.isOpen() && manager != null) {
            manager.close();
            factory.close();
        }

    }
}
