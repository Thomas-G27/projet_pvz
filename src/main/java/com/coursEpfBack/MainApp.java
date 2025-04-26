package com.coursEpfBack;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class MainApp {
    public static void main(String[] args) {
        // Charger manuellement le contexte Spring avec ta config
        ApplicationContext context = new AnnotationConfigApplicationContext(ConfigBDD.class);

        // Récupérer le Bean JdbcTemplate
        JdbcTemplate jdbcTemplate = context.getBean(JdbcTemplate.class);

        // Test de connexion à la base de données
        String testQuery = "SELECT 1";
        Integer result = jdbcTemplate.queryForObject(testQuery, Integer.class);

        if (result != null && result == 1) {
            System.out.println(" Connexion réussie à la base de données !");
        } else {
            System.out.println(" Erreur de connexion !");
        }

        // Fermer le contexte Spring proprement
        ((AnnotationConfigApplicationContext) context).close();
    }
}
