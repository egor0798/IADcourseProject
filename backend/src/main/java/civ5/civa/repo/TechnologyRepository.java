package civ5.civa.repo;

import civ5.civa.model.Building;
import civ5.civa.model.Technology;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TechnologyRepository extends CrudRepository<Technology, Long> {
    Technology findByName(String name);
//    Technology findByUn
}
