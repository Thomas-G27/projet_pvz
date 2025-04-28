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
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.ArgumentCaptor;

import com.oxyl.coursepfback.dao.interfaces.Plante_DAO_interface;
import com.oxyl.coursepfback.dto.Plante_DTO;
import com.oxyl.coursepfback.dto.mapper.Plante_Mapper;
import com.oxyl.coursepfback.model.Plante;

@ExtendWith(MockitoExtension.class)
class Plante_ServiceTest {

    @Mock
    private Plante_DAO_interface planteDAO;

    @InjectMocks
    private Plante_Service planteService;

    private Plante plante;

    @BeforeEach
    void setUp() {
        plante = new Plante(1, "Tournesol", 100, 0.0, 0, 50, 2.5, "GENERATEUR_SOLEIL", "/images/plantes/tournesol.png");
    }

    // Test de la méthode listerPlantes
    @Test
    void ListerPlantesTest() {
        // Remplace l'appel à la méthode listerPlantes() par une liste contenant une plante
        when(planteDAO.getAllPlantes()).thenReturn(Arrays.asList(plante));

        List<Plante_DTO> plantes = planteService.listerPlantes();

        assertNotNull(plantes);
        assertEquals(1, plantes.size());
        assertEquals("Tournesol", plantes.get(0).getNom());

        verify(planteDAO, times(1)).getAllPlantes();
    }

    // Test de la méthode trouverPlanteParId
    @Test
    void TrouverPlanteParIdTest() {
        int planteId = 1;
        when(planteDAO.getPlanteById(planteId)).thenReturn(plante);

        Plante_DTO result = planteService.trouverPlanteParId(planteId);

        assertNotNull(result);
        assertEquals("Tournesol", result.getNom());

        verify(planteDAO, times(1)).getPlanteById(planteId);
    }

    @Test
    void AjouterPlanteTest() {
        Plante_DTO planteDTO = Plante_Mapper.toDTO(plante);

        // Remplace l'appel à la méthode ajouterPlante() par un ID de plante
        when(planteDAO.ajouterPlante(any(Plante.class))).thenReturn(1);
        
        Plante_DTO result = planteService.ajouterPlante(planteDTO);

        assertNotNull(result);
        assertEquals("Tournesol", result.getNom());

        ArgumentCaptor<Plante> planteCaptor = ArgumentCaptor.forClass(Plante.class);
        verify(planteDAO, times(1)).ajouterPlante(planteCaptor.capture());

        Plante capturedPlante = planteCaptor.getValue();
        assertNotNull(capturedPlante);
        assertEquals("Tournesol", capturedPlante.getNom());
    }

    // Test de la méthode ModifierPlante
    @Test
    void ModifierPlanteTest() {
        Plante_DTO planteDTO = Plante_Mapper.toDTO(plante);

        // Remplace l'appel à la méthode modifierPlante() par une valeur de retour 1 (indiquant que la plante a été modifiée)
        when(planteDAO.modifierPlante(any(Integer.class), any(Plante.class))).thenReturn(1);

        Plante_DTO result = planteService.modifierPlante(1, planteDTO);

        assertNotNull(result);
        assertEquals("Tournesol", result.getNom());

        verify(planteDAO, times(1)).modifierPlante(any(Integer.class), any(Plante.class));
    }

    // Test de la méthode supprimerPlante
    @Test
    void SupprimerPlanteTest() {
        int planteId = 1;

        planteService.supprimerPlante(planteId);

        verify(planteDAO, times(1)).supprimerPlante(planteId);
    }
}
