package civ5.civa.repo;

import civ5.civa.model.Technology;
import org.springframework.data.repository.CrudRepository;

public interface TechnologyRepository extends CrudRepository<Technology, Long> {
    Technology findByName(String name);
}
