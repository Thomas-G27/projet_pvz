package com.oxyl.coursepfback.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import java.sql.PreparedStatement;
import java.sql.Statement;

import com.oxyl.coursepfback.dao.interfaces.Map_DAO_interface;
import com.oxyl.coursepfback.model.Map;

@Repository
public class Map_DAO implements Map_DAO_interface {

    private final JdbcTemplate jdbcTemplate;

    public Map_DAO(JdbcTemplate jdbcTemplate) {   
        this.jdbcTemplate = jdbcTemplate;
    }

    private final RowMapper<Map> mapRowMapper = (rs, rowNum) ->
        new Map(
            rs.getInt("ligne"),
            rs.getInt("colonne"),
            rs.getString("chemin_image")
        );


    @Override
    public List<Map> getAllMaps() {
        String sql = "SELECT * FROM map";
        return jdbcTemplate.query(sql, mapRowMapper);
    }

    @Override
    public int ajouterMap(Map map) {
        String sql = "INSERT INTO map (ligne, colonne, chemin_image) VALUES (?, ?, ?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, map.getLigne());
            ps.setInt(2, map.getColonne());
            ps.setString(3, map.getChemin_image());
            return ps;
        }, keyHolder);
        return keyHolder.getKey().intValue();   // Retourne l'ID généré
    }

    @Override
    public int modifierMap(int id, Map map) {
        String sql = "UPDATE map SET ligne = ?, colonne = ?, chemin_image = ? WHERE id_map = ?";
        return jdbcTemplate.update(sql, 
            map.getLigne(),
            map.getColonne(),
            map.getChemin_image(),
            id
        );
    }


    @Override
    public Map getMapById(int id) {
        String sql = "SELECT * FROM map WHERE id_map = ?";
        return jdbcTemplate.queryForObject(sql, mapRowMapper, id);
    }


    @Override
    public int deleteMap(int id) {
        String sql = "DELETE FROM map WHERE id_map = ?";
        return jdbcTemplate.update(sql, id);
    }
    
}
