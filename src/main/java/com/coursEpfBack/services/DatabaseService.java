package com.coursEpfBack.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class DatabaseService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public boolean testConnection() {
        try {
            // Essaye d'exécuter une requête simple pour vérifier la connexion
            jdbcTemplate.queryForObject("SELECT 1", Integer.class);
            return true;  // La connexion est réussie
        } catch (Exception e) {
            // Si une erreur se produit, cela signifie que la connexion échoue
            e.printStackTrace();
            return false;
        }
    }
}
