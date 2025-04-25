package com.epf.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.epf.model.Effet;
import com.epf.model.Plante;

@Repository
public class PlanteDAOImpl implements PlanteDAO { 
    // potentiellement equivalent a PlanteDTO

    private final JdbcTemplate jdbcTemplate;

    public PlanteDAOImpl(JdbcTemplate jdbcTemplate) {   
        this.jdbcTemplate = jdbcTemplate;
    }

    private final RowMapper<Plante> planteRowMapper = (rs, rowNum) -> 
        new Plante(
            rs.getString("nom"),
            rs.getInt("point_de_vie"),
            rs.getDouble("attaque_par_seconde"),
            rs.getInt("degat_attaque"),
            rs.getInt("cout"),
            rs.getDouble("soleil_par_seconde"),
            Effet.valueOf(rs.getString("effet")), 
            rs.getString("chemin_image")
        );

    @Override
    public int ajouterPlante(Plante plante) {
        String sql = "INSERT INTO plante (nom, point_de_vie, attaque_par_seconde, degat_attaque, cout, soleil_par_seconde, effet, chemin_image) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        return jdbcTemplate.update(sql, 
            plante.getNom(),
            plante.getPoint_de_vie(),
            plante.getAttaque_par_seconde(),
            plante.getDegat_attaque(),
            plante.getCout(),
            plante.getSoleil_par_seconde(),
            plante.getEffet().toString(), 
            plante.getChemin_image()
        );
    }

    @Override
    public Plante getPlanteById(int id) {
        String sql = "SELECT * FROM plante WHERE id_plante = ?";
        return jdbcTemplate.queryForObject(sql, planteRowMapper, id);
    }

    @Override
    public List<Plante> getAllPlantes() {
        String sql = "SELECT * FROM plante";
        return jdbcTemplate.query(sql, planteRowMapper);
    }

    @Override
    public int updatePlante(Plante plante) {
        String sql = "UPDATE plante SET nom = ?, point_de_vie = ?, attaque_par_seconde = ?, degat_attaque = ?, cout = ?, soleil_par_seconde = ?, effet = ?, chemin_image = ? WHERE id_plante = ?";
        return jdbcTemplate.update(sql, 
            plante.getNom(),
            plante.getPoint_de_vie(),
            plante.getAttaque_par_seconde(),
            plante.getDegat_attaque(),
            plante.getCout(),
            plante.getSoleil_par_seconde(),
            plante.getEffet().toString(), 
            plante.getChemin_image(),
            plante.getId_plante()
        );
    }
    @Override
    public int deletePlante (int id){
        String sql = "DELETE plante WHERE id_plante = ?";
        
        return jdbcTemplate.update(sql, id);
    }
}
