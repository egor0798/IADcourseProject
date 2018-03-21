package civ5.civa.repo;

import civ5.civa.model.Unit;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UnitRepository extends CrudRepository<Unit, Long> {
//    Unit findByName();
    List<Unit> findAll();
}
