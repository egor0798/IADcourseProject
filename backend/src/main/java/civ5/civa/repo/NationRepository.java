package civ5.civa.repo;


import civ5.civa.model.Nation;
import org.springframework.data.repository.CrudRepository;

public interface NationRepository extends CrudRepository<Nation, Long> {
    Nation getByState(String  state);
}