package com.oxyl.coursepfback.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.Mock;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;

import com.oxyl.coursepfback.dao.interfaces.Zombie_DAO_interface;
import com.oxyl.coursepfback.dto.Zombie_DTO;
import com.oxyl.coursepfback.dto.mapper.Zombie_Mapper;
import com.oxyl.coursepfback.model.Zombie;

@ExtendWith(MockitoExtension.class)
public class Zombie_ServiceTest {
    @Mock
    private Zombie_DAO_interface zombieDAO; // Mock de l'interface Zomie_Service

    @InjectMocks
    private Zombie_Service zombieService; // Service à tester

    private Zombie zombie; // Objet Zombie à utiliser dans les tests

    @BeforeEach
    void setUp() {
        // Initialisation de l'objet Zombie avec des valeurs par défaut
        zombie = new Zombie(1, "Zombie Test", 100, 1.0, 10, 2.0, "img/zombie_test.png", 1);
    }

    // test de la méthode listerZombies
    @Test
    void ListerZombiesTest() {
        // Remplace l'appel à la méthode getAllZombies() par une liste contenant un zombie
        when(zombieDAO.getAllZombies()).thenReturn(Arrays.asList(zombie));

        List<Zombie_DTO> zombies = zombieService.listerZombies();

        assertNotNull(zombies);
        assertEquals(1, zombies.size());
        assertEquals("Zombie Test", zombies.get(0).getNom());

        verify(zombieDAO, times(1)).getAllZombies();
    }

    // test de la méthode ajouterZombie
    @Test
    void ajouterZombieTest() {
        Zombie_DTO zombieDTO = Zombie_Mapper.toDTO(zombie);

        // Remplace l'appel à la méthode ajouterZombie() par une valeur de retour 1 (l'ID du zombie ajouté)
        when(zombieDAO.ajouterZombie(any(Zombie.class))).thenReturn(1);

        Zombie_DTO result = zombieService.ajouterZombie(zombieDTO);

        assertNotNull(result);
        assertEquals(zombie.getNom(), result.getNom());

        // Capture l'objet passé au DAO pour le verifier
        ArgumentCaptor<Zombie> zombieCaptor = ArgumentCaptor.forClass(Zombie.class);
        verify(zombieDAO, times(1)).ajouterZombie(zombieCaptor.capture());

        // Vérifie ce qui a été capturé est cohérent avec l'objet envoyé
        Zombie capturedZombie = zombieCaptor.getValue();
        assertNotNull(capturedZombie);
        assertEquals(zombie.getNom(), capturedZombie.getNom());
    }

    // test de la méthode modifierZombie
    @Test
    void modifierZombieTest() {
        Zombie_DTO zombieDTO = Zombie_Mapper.toDTO(zombie);

        // Remplace l'appel à la méthode modifierZombie() par une valeur de retour 1 (l'ID du zombie modifié)
        when(zombieDAO.modifierZombie(any(Integer.class), any(Zombie.class))).thenReturn(1);

        Zombie_DTO result = zombieService.modifierZombie(zombie.getId_zombie(), zombieDTO);

        assertNotNull(result);
        assertEquals(zombie.getNom(), result.getNom());

        // Capture l'objet passé au DAO pour le verifier
        ArgumentCaptor<Zombie> zombieCaptor = ArgumentCaptor.forClass(Zombie.class);
        verify(zombieDAO, times(1)).modifierZombie(any(Integer.class), zombieCaptor.capture());

        // Vérifie ce qui a été capturé est cohérent avec l'objet envoyé
        Zombie capturedZombie = zombieCaptor.getValue();
        assertNotNull(capturedZombie);
        assertEquals(zombie.getNom(), capturedZombie.getNom());
    }

    // test de la méthode supprimerZombie
    @Test
    void supprimerZombieTest() {
        int id = zombie.getId_zombie(); // ID du zombie à supprimer

        // Remplace l'appel à la méthode supprimerZombie() par une valeur de retour 1 (le nombre de lignes affectées)
        when(zombieDAO.supprimerZombie(id)).thenReturn(1);
        
        zombieService.supprimerZombie(id);

        // Vérifie que la méthode a été appelée une fois avec l'ID du zombie
        verify(zombieDAO, times(1)).supprimerZombie(zombie.getId_zombie());
    }

    // test de la méthode trouverZombieParId
    @Test
    void trouverZombieParIdTest() {
        int id = zombie.getId_zombie(); // ID du zombie à trouver

        // Remplace l'appel à la méthode getZombieById() par le zombie créé
        when(zombieDAO.getZombieById(id)).thenReturn(zombie);

        Zombie_DTO result = zombieService.trouverZombieParId(id);

        assertNotNull(result);
        assertEquals(zombie.getNom(), result.getNom());

        // Vérifie que la méthode a été appelée une fois avec l'ID du zombie
        verify(zombieDAO, times(1)).getZombieById(id);
    }

    // test de la méthode supprimerZombieParMap
    @Test
    void supprimerZombieParMapTest() {
        int id_map = 1; // ID de la map à supprimer

        // Remplace l'appel à la méthode supprimerZombieParIdMap() par une valeur de retour 1 (le nombre de lignes supposément affféctées ici)
        when(zombieDAO.supprimerZombieParIdMap(id_map)).thenReturn(1);

        zombieService.supprimerZombieParMap(id_map);

        // Vérifie que la méthode a été appelée une fois avec l'ID de la map
        verify(zombieDAO, times(1)).supprimerZombieParIdMap(id_map);
    }
}
