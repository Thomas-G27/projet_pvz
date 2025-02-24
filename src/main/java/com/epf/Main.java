package com.epf;

import org.springframework.jdbc.core.JdbcTemplate;

import com.epf.dao.PlanteDAOImpl;
import com.epf.model.Effet;
import com.epf.model.Plante;
import com.mysql.cj.jdbc.MysqlDataSource;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        Effet eff = Effet.NORMAL;
        Plante p = new Plante("plante_de_thomas", 400, 1.00, 15, 150, 1.00, eff, "img/plante_thomas.png");

        MysqlDataSource dataS = new MysqlDataSource();
        dataS.setUrl("jdbc:mysql://localhost:3306/pvz");
        dataS.setUser("epf");
        dataS.setPassword("mot_de_passe");

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataS);

        PlanteDAOImpl pDAO = new PlanteDAOImpl(jdbcTemplate);

        pDAO.ajouterPlante(p);

    }
}
