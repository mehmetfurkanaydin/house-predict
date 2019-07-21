package com.demo.houseManagerAPI.service;

import com.demo.houseManagerAPI.domain.House;
import com.demo.houseManagerAPI.repositories.HouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HouseServiceImpl implements HouseService {

    @Autowired
    HouseRepository houseRepository;

    @Override
    public List<House> findAll() {
        return houseRepository.findAll();
    }

    @Override
    public void saveOrUpdateHouse(House house) {
        houseRepository.save(house);
    }

    @Override
    public void deleteHouse(String id) {
        houseRepository.deleteById(id);
    }
}
