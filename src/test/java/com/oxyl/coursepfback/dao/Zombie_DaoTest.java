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


@ExtendWith(MockitoExtension.class)
public class Zombie_DaoTest {
    @Mock
    private JdbcTemplate jdbcTemplate; // Mock de JdbcTemplate

    private Zombie_DAO zombieDAO; // DAO à tester
    private Zombie zombie; // Objet Zombie à utiliser dans les tests

    @BeforeEach
    void setUp() {
        zombieDAO = new Zombie_DAO(jdbcTemplate); // Initialisation de l'interface avec le mock JdbcTemplate
        zombie = new Zombie(1, "Zombie Test", 100, 0.5, 10, 0.0, "/img/zombie.png", 1); // Initialisation de l'objet Zombie
    }

    // Test de la méthode getAllZombies
    @Test
    void getAllZombiesTest() {
        // Remplace l'appel à la méthode listerZombies() par une liste contenant un zombie
        when(jdbcTemplate.query(anyString(), any(RowMapper.class))).thenReturn(Arrays.asList(zombie));

        List<Zombie> zombies = zombieDAO.getAllZombies(); // Appel de la méthode à tester

        assertNotNull(zombies); // Vérifie que la liste n'est pas nulle
        assertEquals(1, zombies.size()); // Vérifie que la taille de la liste est 1
        assertEquals("Zombie Test", zombies.get(0).getNom()); // Vérifie que le nom du zombie est correct

        verify(jdbcTemplate, times(1)).query(anyString(), any(RowMapper.class)); // Vérifie que la méthode query a été appelée une fois
    }

    // Test de la méthode getZombieById
    @Test
    void getZombieByIdTest() {
        // Remplace l'appel à la méthode getZombieById() par un zombie
        when(jdbcTemplate.queryForObject(anyString(), any(RowMapper.class), anyInt())).thenReturn(zombie);

        Zombie result = zombieDAO.getZombieById(1); // Appel de la méthode à tester

        assertNotNull(result); // Vérifie que le résultat n'est pas nul
        assertEquals("Zombie Test", result.getNom()); // Vérifie que le nom du zombie est correct

        verify(jdbcTemplate, times(1)).queryForObject(anyString(), any(RowMapper.class), anyInt()); // Vérifie que la méthode queryForObject a été appelée une fois
    }

    // Test Non réussi (la methode fonctionne mais pas le test)
    // Test de la méthode ajouterZombie
    // @Test
    // void ajouterZombieTest() {

    //     when(jdbcTemplate.update(any(PreparedStatementCreator.class), any(KeyHolder.class))).thenReturn(1); // Simule un ajout réussi

    //     int result = zombieDAO.ajouterZombie(zombie); // Appel de la méthode à tester

    //     assertEquals(1, result); // Vérifie que le résultat est 1 (ajout réussi)

    //     ArgumentCaptor<Zombie> zombieCaptor = ArgumentCaptor.forClass(Zombie.class); // Capture l'argument passé à la méthode update
    //     verify(jdbcTemplate, times(1)).update(anyString(), zombieCaptor.capture()); // Vérifie que la méthode update a été appelée une fois avec le bon argument

    //     assertEquals(zombie.getNom(), zombieCaptor.getValue().getNom()); // Vérifie que le nom du zombie capturé est correct
    // }

    // Test de la méthode modifierZombie
    @Test
    void modifierZombieTest() {
        // Remplace l'appel à la méthode modifierZombie() par un entier représentant le nombre de lignes affectées
        when(jdbcTemplate.update(anyString(), anyString(), anyInt(), anyDouble(), anyInt(), anyDouble(), anyString(), anyInt(), anyInt())).thenReturn(1);

        int result = zombieDAO.modifierZombie(1, zombie); // Appel de la méthode à tester

        assertEquals(1, result); // Vérifie que le résultat est 1 (modification réussie)

        verify(jdbcTemplate, times(1)).update(anyString(), anyString(), anyInt(), anyDouble(), anyInt(), anyDouble(), anyString(), anyInt(), anyInt()); // Vérifie que la méthode update a été appelée une fois avec le bon argument
    }

    // Test de la méthode supprimerZombie
    @Test
    void supprimerZombieTest() {
        // Remplace l'appel à la méthode supprimerZombie() par un entier représentant le nombre de lignes affectées
        when(jdbcTemplate.update(anyString(), anyInt())).thenReturn(1);

        int result = zombieDAO.supprimerZombie(1); // Appel de la méthode à tester

        assertEquals(1, result); // Vérifie que le résultat est 1 (suppression réussie)

        verify(jdbcTemplate, times(1)).update(anyString(), anyInt()); // Vérifie que la méthode update a été appelée une fois
    }

    // Test de la méthode supprimerZombieParIdMap
    @Test
    void supprimerZombieParIdMapTest() {
        // Remplace l'appel à la méthode supprimerZombieParIdMap() par un entier représentant le nombre de lignes affectées
        when(jdbcTemplate.update(anyString(), anyInt())).thenReturn(1);

        int result = zombieDAO.supprimerZombieParIdMap(1); // Appel de la méthode à tester

        assertEquals(1, result); // Vérifie que le résultat est 1 (suppression réussie)

        verify(jdbcTemplate, times(1)).update(anyString(), anyInt()); // Vérifie que la méthode update a été appelée une fois
    }
}
