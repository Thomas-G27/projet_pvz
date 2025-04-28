package com.oxyl.coursepfback.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import java.sql.PreparedStatement;
import java.sql.Statement;

import com.oxyl.coursepfback.dao.interfaces.Zombie_DAO_interface;
import com.oxyl.coursepfback.model.Zombie;

@Repository
public class Zombie_DAO implements Zombie_DAO_interface {

    private final JdbcTemplate jdbcTemplate;

    public Zombie_DAO(JdbcTemplate jdbcTemplate) {   
        this.jdbcTemplate = jdbcTemplate;
    }

    private final RowMapper<Zombie> zombieRowMapper = (rs, rowNum) -> 
        new Zombie(
            rs.getInt("id_zombie"),
            rs.getString("nom"),
            rs.getInt("point_de_vie"),
            rs.getDouble("attaque_par_seconde"),
            rs.getInt("degat_attaque"),
            rs.getDouble("vitesse_de_deplacement"),
            rs.getString("chemin_image"),
            rs.getInt("id_map")
        );

    @Override
    public List<Zombie> getAllZombies() {
        String sql = "SELECT * FROM zombie";
        return jdbcTemplate.query(sql, zombieRowMapper);
    }

    @Override
    public Zombie getZombieById(int id) {
        String sql = "SELECT * FROM zombie WHERE id_zombie = ?";
        return jdbcTemplate.queryForObject(sql, zombieRowMapper, id);
    }

    @Override
    public int ajouterZombie(Zombie zombie) {
        String sql = "INSERT INTO zombie (nom, point_de_vie, attaque_par_seconde, degat_attaque, vitesse_de_deplacement, chemin_image, id_map) VALUES (?, ?, ?, ?, ?, ?, ?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, zombie.getNom());
            ps.setInt(2, zombie.getPoint_de_vie());
            ps.setDouble(3, zombie.getAttaque_par_seconde());
            ps.setInt(4, zombie.getDegat_attaque());
            ps.setDouble(5, zombie.getVitesse_de_deplacement());
            ps.setString(6, zombie.getChemin_image());
            ps.setInt(7, zombie.getId_map());
            return ps;
        }, keyHolder);
        if (keyHolder.getKey() != null) {
            return keyHolder.getKey().intValue();   // Retourne l'ID généré
        } else {
            return 0; // En cas d'erreur, retourne 0
        }
        
    }

    @Override
    public int modifierZombie(int id, Zombie zombie) {
        String sql = "UPDATE zombie SET nom = ?, point_de_vie = ?, attaque_par_seconde = ?, degat_attaque = ?, vitesse_de_deplacement = ?, chemin_image = ?, id_map = ? WHERE id_zombie = ?";
        return jdbcTemplate.update(sql, 
            zombie.getNom(),
            zombie.getPoint_de_vie(),
            zombie.getAttaque_par_seconde(),
            zombie.getDegat_attaque(),
            zombie.getVitesse_de_deplacement(),
            zombie.getChemin_image(),
            zombie.getId_map(),
            id
        );
        // Retourne le nombre de lignes affectées, si 0, cela signifie que l'ID n'existe pas
    }

    @Override
    public int supprimerZombie(int id) {
        String sql = "DELETE FROM zombie WHERE id_zombie = ?";
        return jdbcTemplate.update(sql, id);
    }
    @Override
    public int supprimerZombieParIdMap(int id_map) {
        String sql = "DELETE FROM zombie WHERE id_map = ?";
        return jdbcTemplate.update(sql, id_map);
    }
}
