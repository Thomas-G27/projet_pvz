package com.epf.dao;

import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import com.epf.model.Plante;

@Repository
public class PlanteDAOImpl implements PlanteDAO {

    private final JdbcTemplate jdbcTemplate;

    public PlanteDAOImpl(JdbcTemplate jdbcTemplate) {
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
            rs.getString("effet"),  // Si `Effet` est un ENUM ou String
            rs.getString("chemin_image")
        );

    @Override
    public int ajouterPlante(Plante plante) {
        String sql = "INSERT INTO plantes (nom, point_de_vie, attaque_par_seconde, degat_attaque, cout, soleil_par_seconde, effet, chemin_image) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        return jdbcTemplate.update(sql, 
            plante.getNom(),
            plante.getPointDeVie(),
            plante.getAttaqueParSeconde(),
            plante.getDegatAttaque(),
            plante.getCout(),
            plante.getSoleilParSeconde(),
            plante.getEffet().toString(), // Conversion de l'effet si nécessaire
            plante.getCheminImage()
        );
    }

    @Override
    public Plante getPlanteById(int id) {
        String sql = "SELECT * FROM plantes WHERE id_plante = ?";
        return jdbcTemplate.queryForObject(sql, planteRowMapper, id);
    }

    @Override
    public List<Plante> getAllPlantes() {
        String sql = "SELECT * FROM plantes";
        return jdbcTemplate.query(sql, planteRowMapper);
    }

    @Override
    public int updatePlante(Plante plante) {
        String sql = "UPDATE plantes SET nom = ?, point_de_vie = ?, attaque_par_seconde = ?, degat_attaque = ?, cout = ?, soleil_par_seconde = ?, effet = ?, chemin_image = ? WHERE id_plante = ?";
        return jdbcTemplate.update(sql, 
            plante.getNom(),
            plante.getPointDeVie(),
            plante.getAttaqueParSeconde(),
            plante.getDegatAttaque(),
            plante.getCout(),
            plante.getSoleilParSeconde(),
            plante.getEffet().toString(),
            plante.getCheminImage(),
            plante.getIdPlante()
        );
    }

    @Override
    public int dele
