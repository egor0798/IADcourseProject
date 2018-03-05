package civ5.civa.repo;

import civ5.civa.model.ImprovementBuildings;
import org.springframework.data.repository.CrudRepository;

public interface ImprBuildRepository extends CrudRepository<ImprovementBuildings, Long> {
}
