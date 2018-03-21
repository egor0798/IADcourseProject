package civ5.civa.controller;

import civ5.civa.model.Unit;
import civ5.civa.repo.UnitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


public class UnitController {

    @Autowired
    UnitRepository unitRepository;

    @GetMapping("/unit/getAll")
    public List<Unit> getAll(){
        return unitRepository.findAll();
    }

}
