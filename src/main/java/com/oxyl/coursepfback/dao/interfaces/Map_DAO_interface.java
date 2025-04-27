package com.oxyl.coursepfback.dao.interfaces;

import java.util.List;

import com.oxyl.coursepfback.model.Map;

public interface Map_DAO_interface {
    List<Map> getAllMaps();
    int ajouterMap(Map map);
    int modifierMap(int id, Map map);


    
    Map getMapById(int id);
    int deleteMap(int id);

}
