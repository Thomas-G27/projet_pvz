package com.coursEpfBack;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.coursEpfBack.config.DatabaseConfig;
import com.coursEpfBack.dao.Plante_DAO;
import com.coursEpfBack.dto.Plante_DTO;
import com.coursEpfBack.services.Plante_Service;

public class MainApp {
    public static void main(String[] args) {
        try {
            DatabaseConfig dbConfig = new DatabaseConfig();
            DataSource  dataSource = dbConfig.dataSource();
            // Test de la connexion à la base de données
            if (dataSource.getConnection() != null) {
                System.out.println("✅ Connexion à la base de données réussie !");
                JdbcTemplate jdbcTemplate = new JdbcTemplate();
                jdbcTemplate.setDataSource(dataSource);
                Plante_DAO planteDAO = new Plante_DAO(jdbcTemplate);
                Plante_Service planteService = new Plante_Service(planteDAO);
                List<Plante_DTO> plantes = planteService.listerPlantes();
                for (Plante_DTO plante : plantes) {
                    System.out.println("Plante : " + plante.getNom() + ", Coût : " + plante.getCout());
                }
                
                Connection connection = dataSource.getConnection();
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM Plante");
                while (resultSet.next()) {
                    System.out.println("Plante trouvée : " + resultSet.getString("nom"));
                }
            } else {
                System.out.println("❌ Échec de la connexion à la base de données.");
            }
        } catch (Exception e) {
            System.err.println("❌ Erreur de connexion : " + e.getMessage());
        }
    }
}
