package ir.suchme.core.domain.repository;

import ir.suchme.core.domain.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;


public interface UserRepository extends CrudRepository<User,UUID> {
    User findByUserNameAndDeletedIsFalse(String userName);
//    List<User> findAll();
}
