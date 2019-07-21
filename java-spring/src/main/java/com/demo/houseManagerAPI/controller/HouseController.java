package com.demo.houseManagerAPI.controller;

import com.demo.houseManagerAPI.domain.House;
import com.demo.houseManagerAPI.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/house")
public class HouseController {

    @Autowired
    HouseService houseService;

    @GetMapping
    public ResponseEntity<?> getAll() {
        List<House> result = houseService.findAll();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<?> addorUpdateHouse(@RequestBody House house) {
        houseService.saveOrUpdateHouse(house);
        return new ResponseEntity("Expense added succcessfully", HttpStatus.OK);
    }

    @DeleteMapping
    public void deleteHouse(@RequestParam("id") String id) {
        houseService.deleteHouse(id);
    }
}
