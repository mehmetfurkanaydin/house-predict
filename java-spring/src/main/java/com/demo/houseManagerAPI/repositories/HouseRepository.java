package com.demo.houseManagerAPI.repositories;

import com.demo.houseManagerAPI.domain.House;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface HouseRepository  extends MongoRepository<House, String> {

}
