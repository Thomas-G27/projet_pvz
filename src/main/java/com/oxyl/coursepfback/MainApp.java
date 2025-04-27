package com.oxyl.coursepfback;


public class MainApp {
    public static void main(String[] args) {
    }


    // public static void main(String[] args) {
    //     try {
    //         DatabaseConfig dbConfig = new DatabaseConfig();
    //         DataSource  dataSource = dbConfig.dataSource();
    //         // Test de la connexion à la base de données
    //         if (dataSource.getConnection() != null) {
    //             System.out.println("✅ Connexion à la base de données réussie !");
    //             JdbcTemplate jdbcTemplate = new JdbcTemplate();
    //             jdbcTemplate.setDataSource(dataSource);
    //             Zombie_DAO Zombie_DAO = new Zombie_DAO(jdbcTemplate);
    //             Zombie_Service Zombie_Service = new Zombie_Service(Zombie_DAO);
    //             List<Zombie_DTO> zombies = Zombie_Service.listerZombies();
    //             for (Zombie_DTO zombie : zombies) {
    //                 System.out.println("Zombie : " + zombie.getNom());
    //             }
                
    //             Connection connection = dataSource.getConnection();
    //             Statement statement = connection.createStatement();
    //             ResultSet resultSet = statement.executeQuery("SELECT * FROM Plante");
    //             while (resultSet.next()) {
    //                 System.out.println("Plante trouvée : " + resultSet.getString("nom"));
    //             }
    //         } else {
    //             System.out.println("❌ Échec de la connexion à la base de données.");
    //         }
    //     } catch (Exception e) {
    //         System.err.println("❌ Erreur de connexion : " + e.getMessage());
    //     }
    // }
}
