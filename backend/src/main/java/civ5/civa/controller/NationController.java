package civ5.civa.controller;

import civ5.civa.model.Nation;
import civ5.civa.repo.NationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/nation")
@RestController
public class NationController {
    @Autowired
    NationRepository nationRepository;

    @GetMapping("/{name}")
    public Nation getByName(@PathVariable String name){
        return nationRepository.getByState(name);
    }

}
