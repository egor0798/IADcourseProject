package civ5.civa.controller;

import civ5.civa.model.Unit;
import civ5.civa.repo.UnitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/unit")
public class UnitController {

    @Autowired
    UnitRepository unitRepository;

    @GetMapping("/{type}")
    public List<Unit> getAll(@PathVariable String type){
        return unitRepository.getByType(type);
    }

    @GetMapping("/unique")
    public List<Unit> getAllUnique(){
//        return unitRepository.findByUnique_unitIs(true);
        return unitRepository.findByUnqUnitIsTrue();
    }

}
