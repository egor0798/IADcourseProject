package civ5.civa.repo;

import civ5.civa.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
        public User findByFacebook(String id);
}
