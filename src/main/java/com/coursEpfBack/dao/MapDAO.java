package com.coursEpfBack.dao;

import java.util.List;

import com.coursEpfBack.model.Map;

public interface MapDAO {
    int ajouterMap(Map map);
    Map getMapById(int id);
    List<Map> getAllMaps();
    int updateMap(int id, Map map);
    int deleteMap(int id);

}
