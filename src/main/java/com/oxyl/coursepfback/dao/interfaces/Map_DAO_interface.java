package com.oxyl.coursepfback.dao.interfaces;

import java.util.List;

import com.oxyl.coursepfback.model.Map;

public interface Map_DAO_interface {
    // CRUD operations for Map
    List<Map> getAllMaps();             //Read
    Map getMapById(int id);             //Read
    int ajouterMap(Map map);            //Create
    int modifierMap(int id, Map map);   //Update
    int supprimerMap(int id);           //Delete

}
