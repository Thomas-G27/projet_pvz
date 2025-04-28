package com.oxyl.coursepfback.dao;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import org.mockito.Mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.oxyl.coursepfback.model.Plante;


@ExtendWith(MockitoExtension.class)
class Plante_DaoTest {
    @Mock
    private JdbcTemplate jdbcTemplate; // Mock de JdbcTemplate

    private Plante_DAO planteDAO; // DAO à tester
    private Plante plante1; // Objet Plante à utiliser dans les tests
    private Plante plante2; // Objet Plante à utiliser dans les tests

    @BeforeEach
    void setUp() {
        planteDAO = new Plante_DAO(jdbcTemplate); // Initialisation de l'interface avec le mock JdbcTemplate
        plante1 = new Plante(1,"Tournesol", 100, 0.0, 0, 50, 2.5, "normal", "data/tournesol.png"); // Initialisation de l'objet Plante
        plante2 = new Plante(2,"Pisto-pois", 100, 1.0, 20, 100, 0, "normal", "data/pisto-pois.png"); // Initialisation de l'objet Plante
    }

    // Test de la méthode getAllPlantes
    @Test
    void GetAllPlantesTest() {
        List<Plante> plantes = Arrays.asList(plante1, plante2); // Liste de plantes à retourner

        when(jdbcTemplate.query(anyString(), any(RowMapper.class))).thenReturn(plantes); // Simule le comportement de JdbcTemplate

        List<Plante> result = planteDAO.getAllPlantes();

        assertEquals(2, result.size());
        assertEquals("Pisto-pois", result.get(1).getNom());
        verify(jdbcTemplate, times(1)).query(anyString(), any(RowMapper.class));
    }

    @Test
    void GetPlanteByIdTest() {

        when(planteDAO.getPlanteById(1)).thenReturn(plante1);

        Plante result = planteDAO.getPlanteById(1);

        assertNotNull(result);
        assertEquals("Tournesol", result.getNom());
        assertEquals(0.0, result.getAttaque_par_seconde());
        verify(jdbcTemplate, times(1)).queryForObject(anyString(), any(RowMapper.class), anyInt());
    }

    // Test non réussi
    // @Test
    // void testAjouterPlante() {
        
    //     when(planteDAO.ajouterPlante(plante1)).thenReturn(1); // Simule un ajout réussi

    //     int result = planteDAO.ajouterPlante(plante1);

    //     assertEquals(1, result);
    //     verify(planteDAO, times(1)).ajouterPlante(plante1);
    // }

    @Test
    void modifierPlanteTest() {
        when(jdbcTemplate.update(anyString(), anyString(), anyInt(), anyDouble(), anyInt(), anyInt(), anyDouble(), anyString(), anyString(), anyInt())).thenReturn(1); // Simule une mise à jour réussie

        int result = planteDAO.modifierPlante(1, plante1);

        assertEquals(1, result);
        verify(jdbcTemplate, times(1)).update(anyString(), anyString(), anyInt(), anyDouble(), anyInt(), anyInt(), anyDouble(), anyString(), anyString(), anyInt());
    }

    @Test
    void supprimerPlanteTest() {
        when(jdbcTemplate.update(anyString(), anyInt())).thenReturn(1); // Simule une suppression réussie

        int result = planteDAO.supprimerPlante(2);

        assertEquals(1, result);
        verify(jdbcTemplate, times(1)).update(anyString(), anyInt());
    }
}
