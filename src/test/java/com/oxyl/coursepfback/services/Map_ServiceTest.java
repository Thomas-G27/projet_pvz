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

import com.oxyl.coursepfback.dao.interfaces.Map_DAO_interface;
import com.oxyl.coursepfback.dto.Map_DTO;
import com.oxyl.coursepfback.dto.mapper.Map_Mapper;
import com.oxyl.coursepfback.model.Map;
import com.oxyl.coursepfback.dao.interfaces.Zombie_DAO_interface;

@ExtendWith(MockitoExtension.class)
public class Map_ServiceTest {
    @Mock
    private Map_DAO_interface mapDAO; // Mock de l'interface Map_Service

    @Mock
    private Zombie_DAO_interface zombieDAO; // Mock de l'interface Zombie_DAO_interface

    @InjectMocks
    private Map_Service mapService; // Service à tester

    private Map map; // Objet Map à utiliser dans les tests

    @BeforeEach
    void setUp() {
        // Initialisation de l'objet Map avec des valeurs par défaut
        map = new Map(1, 5, 9, "img/map_test.png");
    }

    // test de la méthode listerMaps
    @Test
    void ListerMapsTest() {
        // Remplace l'appel à la méthode getAllMaps() par une liste contenant une map
        when(mapDAO.getAllMaps()).thenReturn(Arrays.asList(map));

        List<Map_DTO> maps = mapService.listerMaps();

        assertNotNull(maps);
        assertEquals(1, maps.size());
        assertEquals(5, maps.get(0).getLigne());

        verify(mapDAO, times(1)).getAllMaps();
    }

    // test de la methode trouverMapParId
    @Test
    void TrouverMapParIdTest() {
        // Remplace l'appel à la méthode getMapById() par une map
        when(mapDAO.getMapById(1)).thenReturn(map);

        Map_DTO map_dto = mapService.trouverMapParId(1);

        assertNotNull(map_dto);
        assertEquals(1, map_dto.getId_map());

        verify(mapDAO, times(1)).getMapById(1);
    }

    // test de la méthode ajouterMap
    @Test
    void ajouterMapTest() {
        Map_DTO map_dto = Map_Mapper.toDTO(map); // Utilisation du mapper pour convertir l'objet Map en Map_DTO

        // Remplace l'appel à la méthode ajouterMap() par une map
        when(mapDAO.ajouterMap(any(Map.class))).thenReturn(1);

        Map_DTO result = mapService.ajouterMap(map_dto);

        assertNotNull(result);
        assertEquals(1, result.getId_map());
        assertEquals(5, result.getLigne());

        ArgumentCaptor<Map> mapCaptor = ArgumentCaptor.forClass(Map.class);
        verify(mapDAO, times(1)).ajouterMap(mapCaptor.capture());

        Map capturedMap = mapCaptor.getValue();
        assertNotNull(capturedMap);
        assertEquals(5, capturedMap.getLigne());
    }

    // test de la méthode modifierMap
    @Test
    void modifierMapTest() {
        Map_DTO map_dto = Map_Mapper.toDTO(map); // Utilisation du mapper pour convertir l'objet Map en Map_DTO
        int id = 1; // ID de la map à modifier
        // Remplace l'appel à la méthode modifierMap() par une map
        when(mapDAO.modifierMap(any(Integer.class), any(Map.class))).thenReturn(1);

        Map_DTO result = mapService.modifierMap(id, map_dto);

        assertNotNull(result);
        assertEquals(1, result.getId_map());

        ArgumentCaptor<Map> mapCaptor = ArgumentCaptor.forClass(Map.class);
        verify(mapDAO, times(1)).modifierMap(any(Integer.class), mapCaptor.capture());

        Map capturedMap = mapCaptor.getValue();
        assertNotNull(capturedMap);
        assertEquals(5, capturedMap.getLigne());
        assertEquals(1, capturedMap.getId_map());
    }

    // test de la méthode supprimerMap
    @Test
    void supprimerMapTest() {
        int id = 1; // ID de la map à supprimer

        // Remplace l'appel à la méthode supprimerMap() par une valeur de retour 1 (le nombre de lignes affectées)
        when(mapDAO.supprimerMap(id)).thenReturn(1);
        when(zombieDAO.supprimerZombieParIdMap(id)).thenReturn(1); // Suppression des zombies associés à la map
        mapService.supprimerMap(id);

        verify(mapDAO, times(1)).supprimerMap(id);
    }
}
