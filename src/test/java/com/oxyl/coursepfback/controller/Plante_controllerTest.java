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

import com.oxyl.coursepfback.dto.Plante_DTO;
import com.oxyl.coursepfback.services.Plante_Service;

@ExtendWith(MockitoExtension.class)
class Plante_controllerTest {

    @Mock
    private Plante_Service planteService;

    @InjectMocks
    private Plante_controller planteController;

    private Plante_DTO plante;

    @BeforeEach
    void setUp() {
        plante = new Plante_DTO(1,"Tournesol",100,0.0,0,50,25.0,"normal","/images/plantes/tournesol.png");
    }

    @Test
    void getAllPlantesTest() {
        when(planteService.listerPlantes()).thenReturn(Arrays.asList(plante));

        List<Plante_DTO> plantes = planteController.getallPlante();

        assertNotNull(plantes);
        assertEquals(1, plantes.size());
    }

    @Test
    void getPlanteByIdTest() {
        when(planteService.trouverPlanteParId(1)).thenReturn(plante);

        ResponseEntity<Plante_DTO> response = planteController.getPlanteById(1);

        assertTrue(response.getStatusCode().is2xxSuccessful());
        assertNotNull(response.getBody());
        assertEquals(plante.getNom(), response.getBody().getNom());
    }

    @Test
    void ajouterPlanteTest() {
        when(planteService.ajouterPlante(any(Plante_DTO.class))).thenReturn(plante);

        ResponseEntity<Plante_DTO> response = planteController.ajouterPlante(plante);

        assertTrue(response.getStatusCode().is2xxSuccessful());
        assertNotNull(response.getBody());
    }

    @Test
    void modifierPlanteTest() {
        when(planteService.modifierPlante(eq(1), any(Plante_DTO.class))).thenReturn(plante);

        ResponseEntity<Plante_DTO> response = planteController.modifierPlante(1, plante);

        assertTrue(response.getStatusCode().is2xxSuccessful());
        assertEquals(plante.getNom(), response.getBody().getNom());
    }

    @Test
    void supprimerPlanteTest() {
        doNothing().when(planteService).supprimerPlante(1);

        ResponseEntity<Void> response = planteController.supprimerPlante(1);

        assertEquals(204, response.getStatusCodeValue());
    }
}
