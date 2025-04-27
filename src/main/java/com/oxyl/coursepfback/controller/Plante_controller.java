package com.oxyl.coursepfback.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oxyl.coursepfback.dto.Plante_DTO;
import com.oxyl.coursepfback.services.Plante_Service;
import com.oxyl.coursepfback.services.interfaces.Plante_Service_interface;

@CrossOrigin(origins = "*")
@RequestMapping("/plantes")
@RestController
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
