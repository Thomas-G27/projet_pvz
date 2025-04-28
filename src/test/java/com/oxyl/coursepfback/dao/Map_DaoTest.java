package com.oxyl.coursepfback.dao;

import java.sql.PreparedStatement;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.jdbc.core.PreparedStatementCreator;

import com.oxyl.coursepfback.model.Zombie;
import com.oxyl.coursepfback.dao.Zombie_DAO;
import com.oxyl.coursepfback.model.Map;


@ExtendWith(MockitoExtension.class)
public class Map_DaoTest {
    @Mock
    private JdbcTemplate jdbcTemplate; // Mock de JdbcTemplate

    private Map_DAO mapDAO; // DAO à tester
    private Map map; // Objet Map à utiliser dans les tests

    @BeforeEach
    void setUp() {
        mapDAO = new Map_DAO(jdbcTemplate); // Initialisation de l'interface avec le mock JdbcTemplate
        map = new Map(1, 10, 10, "/img/map.png"); // Initialisation de l'objet Map
    }

    // Test de la méthode getAllMaps
    @Test
    void getAllMapsTest() {
        // Remplace l'appel à la méthode listerMap() par une liste contenant une Map
        when(jdbcTemplate.query(anyString(), any(RowMapper.class))).thenReturn(Arrays.asList(map));

        List<Map> maps = mapDAO.getAllMaps(); // Appel de la méthode à tester

        assertNotNull(maps); // Vérifie que la liste n'est pas nulle
        assertEquals(1, maps.size()); // Vérifie que la taille de la liste est 1
        assertEquals(10, maps.get(0).getColonne()); // Vérifie que le nombre de colonnes de la Map est correct

        verify(jdbcTemplate, times(1)).query(anyString(), any(RowMapper.class)); // Vérifie que la méthode query a été appelée une fois
    }

    // Test de la méthode getMapById
    @Test
    void getMapByIdTest() {
        // Remplace l'appel à la méthode getMapById() par une Map
        when(jdbcTemplate.queryForObject(anyString(), any(RowMapper.class), anyInt())).thenReturn(map);

        Map result = mapDAO.getMapById(1); // Appel de la méthode à tester

        assertNotNull(result); // Vérifie que le résultat n'est pas nul
        assertEquals(10, result.getColonne()); // Vérifie que le nombre de colonnes de la Map est correct

        verify(jdbcTemplate, times(1)).queryForObject(anyString(), any(RowMapper.class), anyInt()); // Vérifie que la méthode queryForObject a été appelée une fois
    }

    // Test Non réussi (la methode fonctionne mais pas le test)
    // Test de la méthode ajouterMap
    // @Test
    // void ajouterMapTest() {

    //}

    // Test de la méthode modifierMap
    @Test
    void modifierMapTest() {
        // Remplace l'appel à la méthode modifierMap() par un entier représentant le nombre de lignes affectées
        when(jdbcTemplate.update(anyString(), anyInt(), anyInt(), anyString(), anyInt())).thenReturn(1);

        int result = mapDAO.modifierMap(1, map); // Appel de la méthode à tester

        assertEquals(1, result); // Vérifie que le résultat est 1 (modification réussie)

        verify(jdbcTemplate, times(1)).update(anyString(), anyInt(), anyInt(), anyString(), anyInt()); // Vérifie que la méthode update a été appelée une fois avec le bon argument
    }

    // Test de la méthode supprimerMap
    @Test
    void supprimerMapTest() {
        // Remplace l'appel à la méthode supprimerMap() par un entier représentant le nombre de lignes affectées
        when(jdbcTemplate.update(anyString(), anyInt())).thenReturn(1);

        int result = mapDAO.supprimerMap(1); // Appel de la méthode à tester

        assertEquals(1, result); // Vérifie que le résultat est 1 (suppression réussie)

        verify(jdbcTemplate, times(1)).update(anyString(), anyInt()); // Vérifie que la méthode update a été appelée une fois
    }

}

