package civ5.civa.repo;

import civ5.civa.model.Players;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PlayersRepository extends CrudRepository<Players, Long> {
    List<Players> findByLastName(String lastName);
    List<Players> findByFirstName(String firstName);
    List<Players> findByRank(int rank);
    Players findByNickname(String nickname);
    Players findById(int id);
}