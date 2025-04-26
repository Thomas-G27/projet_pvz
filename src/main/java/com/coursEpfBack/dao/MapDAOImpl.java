package com.coursEpfBack.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.coursEpfBack.model.Map;


@Repository
public class MapDAOImpl implements MapDAO {
    // potentiellement equivalent a MapDTO

    private final JdbcTemplate jdbcTemplate;

    public MapDAOImpl(JdbcTemplate jdbcTemplate) {   
        this.jdbcTemplate = jdbcTemplate;
    }

    private final RowMapper<Map> mapRowMapper = (rs, rowNum) ->
        new Map(
            rs.getInt("ligne"),
            rs.getInt("colonne"),
            rs.getString("chemin_image")
        );
    
    @Override
    public int ajouterMap(Map map) {
        String sql = "INSERT INTO map (ligne, colonne, chemin_image) VALUES (?, ?, ?)";
        return jdbcTemplate.update(sql, 
            map.getLigne(),
            map.getColonne(),
            map.getChemin_image()
        );
    }

    @Override
    public Map getMapById(int id) {
        String sql = "SELECT * FROM map WHERE id_map = ?";
        return jdbcTemplate.queryForObject(sql, mapRowMapper, id);
    }

    @Override
    public List<Map> getAllMaps() {
        String sql = "SELECT * FROM map";
        return jdbcTemplate.query(sql, mapRowMapper);
    }

    @Override
    public int updateMap(Map map) {
        String sql = "UPDATE map SET ligne = ?, colonne = ?, chemin_image = ? WHERE id_map = ?";
        return jdbcTemplate.update(sql, 
            map.getLigne(),
            map.getColonne(),
            map.getChemin_image(),
            map.getId_map()
        );
    }

    @Override
    public int deleteMap(int id) {
        String sql = "DELETE FROM map WHERE id_map = ?";
        return jdbcTemplate.update(sql, id);
    }
    
}
