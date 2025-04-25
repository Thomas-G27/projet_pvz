package com.epf.dao;

import java.util.List;

import com.epf.model.Map;

public interface MapDAO {
    int ajouterMap(Map map);
    Map getMapById(int id);
    List<Map> getAllMaps();
    int updateMap(Map map);
    int deleteMap(int id);

}
