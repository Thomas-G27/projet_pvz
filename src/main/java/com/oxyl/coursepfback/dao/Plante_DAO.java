package com.oxyl.coursepfback.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.oxyl.coursepfback.dao.interfaces.Plante_DAO_interface;
import com.oxyl.coursepfback.model.Plante;

@Repository
public class Plante_DAO implements Plante_DAO_interface { 

    private final JdbcTemplate jdbcTemplate;

    public Plante_DAO(JdbcTemplate jdbcTemplate) {   
        this.jdbcTemplate = jdbcTemplate;
    }

    private final RowMapper<Plante> planteRowMapper = (rs, rowNum) -> 
        new Plante(
            rs.getInt("id_plante"),
            rs.getString("nom"),
            rs.getInt("point_de_vie"),
            rs.getDouble("attaque_par_seconde"),
            rs.getInt("degat_attaque"),
            rs.getInt("cout"),
            rs.getDouble("soleil_par_seconde"),
            rs.getString("effet"), 
            rs.getString("chemin_image")
        );

    @Override
    public List<Plante> getAllPlantes() {
        String sql = "SELECT * FROM plante";
        return jdbcTemplate.query(sql, planteRowMapper);
    }

}
