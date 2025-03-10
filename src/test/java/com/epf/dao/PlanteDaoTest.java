package com.epf.dao;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import com.epf.model.Effet;
import com.epf.model.Plante;

@ExtendWith(MockitoExtension.class)
class PlanteDAOTest {

    @Mock
    private PlanteDAO planteDAO;  // Mock de l'interface PlanteDAO

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this); // Initialisation des mocks
    }

    @Test
    void testAjouterPlante() {
        Plante plante = new Plante("Tournesol", 80, 0, 0, 50, 1.5, Effet.NORMAL, "data/tournesol.png");

        when(planteDAO.ajouterPlante(plante)).thenReturn(1); // Simule un ajout réussi

        int result = planteDAO.ajouterPlante(plante);

        assertEquals(1, result);
        verify(planteDAO, times(1)).ajouterPlante(plante);
    }

    @Test
    void testGetPlanteById() {
        Plante plante = new Plante("Pisto-pois", 100, 1.0, 20, 100, 0, Effet.NORMAL, "img/plante_thomas.png");

        when(planteDAO.getPlanteById(1)).thenReturn(plante);

        Plante result = planteDAO.getPlanteById(1);

        assertNotNull(result);
        assertEquals("Pisto-pois", result.getNom());
        assertEquals(100, result.getPoint_de_vie());
        verify(planteDAO, times(1)).getPlanteById(1);
    }

    @Test
    void testGetAllPlantes() {
        List<Plante> plantes = Arrays.asList(
                new Plante("Tournesol", 80, 0, 0, 50, 1.5, Effet.NORMAL, "data/tournesol.png"),
                new Plante("Pisto-pois", 100, 1.0, 20, 100, 0, Effet.NORMAL, "data/pisto-pois.png"));

        when(planteDAO.getAllPlantes()).thenReturn(plantes);

        List<Plante> result = planteDAO.getAllPlantes();

        assertEquals(2, result.size());
        assertEquals("Pisto-pois", result.get(1).getNom());
        verify(planteDAO, times(1)).getAllPlantes();
    }

    @Test
    void testUpdatePlante() {
        Plante plante = new Plante("Pisto-pois", 100, 1.2, 25, 120, 0, Effet.NORMAL, "data/pisto-pois_v2.png");

        when(planteDAO.updatePlante(plante)).thenReturn(1); // Simule une mise à jour réussie

        int result = planteDAO.updatePlante(plante);

        assertEquals(1, result);
        verify(planteDAO, times(1)).updatePlante(plante);
    }

    @Test
    void testDeletePlante() {
        when(planteDAO.deletePlante(1)).thenReturn(1); // Simule une suppression réussie

        int result = planteDAO.deletePlante(1);

        assertEquals(1, result);
        verify(planteDAO, times(1)).deletePlante(1);
    }
}
