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
import org.springframework.http.ResponseEntity;

import com.oxyl.coursepfback.dto.Map_DTO;
import com.oxyl.coursepfback.services.Map_Service;

@ExtendWith(MockitoExtension.class)
class Map_controllerTest {

    @Mock
    private Map_Service mapService;

    @InjectMocks
    private Map_controller mapController;

    private Map_DTO mapDto;

    @BeforeEach
    void setUp() {
        mapDto = new Map_DTO(1, 5, 9, "/images/maps/map1.png");
    }

    @Test
    void validateMapsFormat_shouldReturnOk_whenAllMapsValid() {
        when(mapService.listerMaps()).thenReturn(Arrays.asList(mapDto));

        ResponseEntity<List<Map_DTO>> response = mapController.validateMapsFormat();

        assertTrue(response.getStatusCode().is2xxSuccessful());
        assertNotNull(response.getBody());
        assertEquals(1, response.getBody().size());
    }

    @Test
    void getallMapTest() {
        when(mapService.listerMaps()).thenReturn(Arrays.asList(mapDto));

        List<Map_DTO> maps = mapController.getallMap();

        assertNotNull(maps);
        assertEquals(1, maps.size());
    }

    @Test
    void getMapByIdTest() {
        when(mapService.trouverMapParId(1)).thenReturn(mapDto);

        ResponseEntity<Map_DTO> response = mapController.getMapById(1);

        assertTrue(response.getStatusCode().is2xxSuccessful());
        assertEquals(mapDto.getChemin_image(), response.getBody().getChemin_image());
    }

    @Test
    void ajouterMapTest() {
        when(mapService.ajouterMap(any(Map_DTO.class))).thenReturn(mapDto);

        ResponseEntity<Map_DTO> response = mapController.ajouterMap(mapDto);

        assertTrue(response.getStatusCode().is2xxSuccessful());
        assertEquals(mapDto.getChemin_image(), response.getBody().getChemin_image());
    }

    @Test
    void modifierMapTest() {
        when(mapService.modifierMap(eq(1), any(Map_DTO.class))).thenReturn(mapDto);

        ResponseEntity<Map_DTO> response = mapController.modifierMap(1, mapDto);

        assertTrue(response.getStatusCode().is2xxSuccessful());
        assertEquals(mapDto.getChemin_image(), response.getBody().getChemin_image());
    }

    @Test
    void supprimerMapTest() {
        doNothing().when(mapService).supprimerMap(1);

        ResponseEntity<Void> response = mapController.supprimerMap(1);

        assertEquals(204, response.getStatusCodeValue());
    }
}
