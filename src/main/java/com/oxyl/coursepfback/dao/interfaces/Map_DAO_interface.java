package com.oxyl.coursepfback.dao.interfaces;

import java.util.List;

import com.oxyl.coursepfback.model.Map;

public interface Map_DAO_interface {
    int ajouterMap(Map map);
    Map getMapById(int id);
    List<Map> getAllMaps();
    int updateMap(int id, Map map);
    int deleteMap(int id);

}
