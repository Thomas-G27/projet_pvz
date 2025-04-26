package com.coursEpfBack.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.coursEpfBack.dao.interfaces.Zombie_DAO_interface;
import com.coursEpfBack.model.Effet;
import com.coursEpfBack.model.Zombie;

@Repository
public class Zombie_DAO implements Zombie_DAO_interface {

    private final JdbcTemplate jdbcTemplate;

    public Zombie_DAO(JdbcTemplate jdbcTemplate) {   
        this.jdbcTemplate = jdbcTemplate;
    }

    private final RowMapper<Zombie> zombieRowMapper = (rs, rowNum) -> 
        new Zombie(
            rs.getString("nom"),
            rs.getInt("point_de_vie"),
            rs.getDouble("attaque_par_seconde"),
            rs.getInt("degat_attaque"),
            rs.getDouble("vitesse_de_deplacement"),
            Effet.valueOf(rs.getString("effet")), 
            rs.getString("chemin_image")
        );

    @Override
    public int ajouterZombie(Zombie zombie) {
        String sql = "INSERT INTO zombie (nom, point_de_vie, attaque_par_seconde, degat_attaque, vitesse_de_deplacement, effet, chemin_image) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        return jdbcTemplate.update(sql, 
            zombie.getNom(),
            zombie.getPoint_de_vie(),
            zombie.getAttaque_par_seconde(),
            zombie.getDegat_attaque(),
            zombie.getVitesse_de_deplacement(),
            zombie.getEffet().toString(), 
            zombie.getChemin_image()
        );
    }

    @Override
    public Zombie getZombieById(int id) {
        String sql = "SELECT * FROM zombie WHERE id_zombie = ?";
        return jdbcTemplate.queryForObject(sql, zombieRowMapper, id);
    }

    @Override
    public List<Zombie> getAllZombies() {
        String sql = "SELECT * FROM zombie";
        return jdbcTemplate.query(sql, zombieRowMapper);
    }
    
    @Override
    public int updateZombie(Zombie zombie) {
        String sql = "UPDATE zombie SET nom = ?, point_de_vie = ?, attaque_par_seconde = ?, degat_attaque = ?, vitesse_de_deplacement = ?, effet = ?, chemin_image = ? WHERE id_zombie = ?";
        return jdbcTemplate.update(sql, 
            zombie.getNom(),
            zombie.getPoint_de_vie(),
            zombie.getAttaque_par_seconde(),
            zombie.getDegat_attaque(),
            zombie.getVitesse_de_deplacement(),
            zombie.getEffet().toString(), 
            zombie.getChemin_image(),
            zombie.getId_zombie()
        );
    }

    @Override
    public int deleteZombie(int id) {
        String sql = "DELETE FROM zombie WHERE id_zombie = ?";
        return jdbcTemplate.update(sql, id);
    }
}
