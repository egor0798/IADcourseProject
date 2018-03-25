package civ5.civa.repo;


import civ5.civa.model.Building;
import civ5.civa.model.Technology;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface BuildingRepository extends CrudRepository<Building, Long> {
    List<Building> findAllByTechnologies(Technology t);
}