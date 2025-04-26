package com.coursEpfBack.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
public class Plante_ServiceTest {
    
    @Mock
    private Plante_Service Plante_Service_interface; // Mock de l'interface

    @BeforeEach
    void Setup() {
        MockitoAnnotations.openMocks(this); // Initialisation des mocks
    }

    @Test
    void testAjouterPlante () {
        
    }
}
