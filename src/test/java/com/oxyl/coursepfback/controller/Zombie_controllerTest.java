package com.oxyl.coursepfback.controller;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;

import com.oxyl.coursepfback.dto.Zombie_DTO;
import com.oxyl.coursepfback.services.Zombie_Service;

@ExtendWith(MockitoExtension.class)
class Zombie_controllerTest {

    @Mock
    private Zombie_Service zombieService;

    @InjectMocks
    private Zombie_controller zombieController;

    private Zombie_DTO zombie;

    @BeforeEach
    void setUp() {
        zombie = new Zombie_DTO(1, "Zombie Test", 100, 1.0, 10, 2.0, "img/zombie_test.png", 1);
    }

    @Test
    void validateZombiesFormat_shouldReturnOk_whenAllZombiesValid() {
        // Prépare une liste valide de zombies
        when(zombieService.listerZombies()).thenReturn(Arrays.asList(zombie));

        var response = zombieController.validateZombiesFormat();

        assertTrue(response.getStatusCode().is2xxSuccessful());
        assertNotNull(response.getBody());
        assertEquals(1, response.getBody().size());
    }

    @Test
    void getAllZombiesTest() {
        when(zombieService.listerZombies()).thenReturn(Arrays.asList(zombie));

        List<Zombie_DTO> result = zombieController.getAllZombies();

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("Zombie Test", result.get(0).getNom());
    }

    @Test
    void getZombieByIdTest() {
        when(zombieService.trouverZombieParId(1)).thenReturn(zombie);

        var response = zombieController.getZombieById(1);

        assertTrue(response.getStatusCode().is2xxSuccessful());
        assertEquals(zombie.getNom(), response.getBody().getNom());
    }

    @Test
    void ajouterZombieTest() {
        when(zombieService.ajouterZombie(any())).thenReturn(zombie);

        var response = zombieController.ajouterZombie(zombie);

        assertTrue(response.getStatusCode().is2xxSuccessful());
        assertEquals(zombie.getNom(), response.getBody().getNom());
    }

    @Test
    void modifierZombieTest() {
        when(zombieService.modifierZombie(eq(1), any())).thenReturn(zombie);

        var response = zombieController.modifierZombie(1, zombie);

        assertTrue(response.getStatusCode().is2xxSuccessful());
        assertEquals(zombie.getNom(), response.getBody().getNom());
    }

    @Test
    void supprimerZombieTest() {
        doNothing().when(zombieService).supprimerZombie(1);

        var response = zombieController.supprimerZombie(1);

        assertEquals(204, response.getStatusCode().value());
    }
}
