package civ5.civa.controller;

import civ5.civa.model.Technology;
import civ5.civa.repo.TechnologyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tech")
public class TechController {
    @Autowired
    TechnologyRepository technologyRepository;

    @GetMapping(value = "/{techName}")
    public Technology getTechByName(@PathVariable String techName){
        return technologyRepository.findByName(techName);
    }

    //TODO how do we get future tech that current tech allows us to learn. We removed prev_tech from technology table
}
