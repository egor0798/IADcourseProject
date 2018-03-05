package civ5.civa.repo;

import civ5.civa.model.Player;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PlayersRepository extends CrudRepository<Player, Long> {
    List<Player> findByLastName(String lastName);
    List<Player> findByFirstName(String firstName);
    List<Player> findByRank(int rank);
    Player findByNickname(String nickname);
    Player findById(int id);
}