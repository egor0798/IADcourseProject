package civ5.civa.repo;

import civ5.civa.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {
        User findByFacebook(String id);
        List<User> findAll();
}
