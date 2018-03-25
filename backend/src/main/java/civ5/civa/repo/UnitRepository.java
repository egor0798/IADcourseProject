package civ5.civa.repo;

import civ5.civa.model.Nation;
import civ5.civa.model.Technology;
import civ5.civa.model.Unit;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UnitRepository extends CrudRepository<Unit, Long> {
//    Unit findByName();
    List<Unit> findAll();
    List<Unit> getByType(String type);;
//    List<Unit> findByUnique_unitIs(boolean s);
    List<Unit> findByUnqUnitIsTrue();
//    Nation find
}
