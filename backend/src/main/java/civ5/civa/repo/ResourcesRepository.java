package civ5.civa.repo;

import civ5.civa.model.Resources;
import org.springframework.data.repository.CrudRepository;

public interface ResourcesRepository extends CrudRepository<Resources, Long> {
    }