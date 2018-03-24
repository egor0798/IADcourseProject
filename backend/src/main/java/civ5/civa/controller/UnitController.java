package civ5.civa.controller;

import civ5.civa.model.Unit;
import civ5.civa.repo.UnitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/unit")
public class UnitController {

    @Autowired
    UnitRepository unitRepository;

    @GetMapping("/getAll")
    public List<Unit> getAll(){
        //TODO fix Unit entity
        return unitRepository.findAll();
    }

}
