package com.coursEpfBack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coursEpfBack.dto.Plante_DTO;
import com.coursEpfBack.services.Plante_Service;
import com.coursEpfBack.services.interfaces.Plante_Service_interface;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/plantes")
public class Plante_controller {

    private final Plante_Service_interface planteService;

    @Autowired
    public Plante_controller (Plante_Service planteServ){
        this.planteService = planteServ;
    }

    @GetMapping("")
    public List<Plante_DTO> getallPlante (){
        return this.planteService.listerPlantes();
    }

}
