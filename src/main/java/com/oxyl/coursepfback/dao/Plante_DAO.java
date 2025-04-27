package com.oxyl.coursepfback.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import java.sql.PreparedStatement;
import java.sql.Statement;

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

    @Override
    public int ajouterPlante(Plante plante) {
        String sql = "INSERT INTO plante (nom, point_de_vie, attaque_par_seconde, degat_attaque, cout, soleil_par_seconde, effet, chemin_image) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, plante.getNom());
            ps.setInt(2, plante.getPoint_de_vie());
            ps.setDouble(3, plante.getAttaque_par_seconde());
            ps.setInt(4, plante.getDegat_attaque());
            ps.setInt(5, plante.getCout());
            ps.setDouble(6, plante.getSoleil_par_seconde());
            ps.setString(7, plante.getEffet());
            ps.setString(8, plante.getChemin_image());
            return ps;
        }, keyHolder);
        return keyHolder.getKey().intValue();   // Retourne l'ID généré
    }

    @Override
    public int modifierPlante(int id, Plante plante) {
        String sql = "UPDATE plante SET nom = ?, point_de_vie = ?, attaque_par_seconde = ?, degat_attaque = ?, cout = ?, soleil_par_seconde = ?, effet = ?, chemin_image = ? WHERE id_plante = ?";
        return jdbcTemplate.update(sql, 
            plante.getNom(), 
            plante.getPoint_de_vie(), 
            plante.getAttaque_par_seconde(), 
            plante.getDegat_attaque(), 
            plante.getCout(), 
            plante.getSoleil_par_seconde(), 
            plante.getEffet(), 
            plante.getChemin_image(), 
            id
        );
    }

    @Override
    public int supprimerPlante(int id) {
        String sql = "DELETE FROM plante WHERE id_plante = ?";
        return jdbcTemplate.update(sql, id);
    }
}
