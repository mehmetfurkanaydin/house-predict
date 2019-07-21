package com.demo.houseManagerAPI.service;

import com.demo.houseManagerAPI.domain.House;

import java.util.List;

public interface HouseService {

    List<House> findAll();

    void saveOrUpdateHouse(House house);

    void deleteHouse(String id);

}
