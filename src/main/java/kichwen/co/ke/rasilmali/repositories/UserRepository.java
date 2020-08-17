package kichwen.co.ke.rasilmali.repositories;

import kichwen.co.ke.rasilmali.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository("userRepository")
public interface UserRepository extends JpaRepository<User,Long>{

    User findByEmail(String email);
    List<User> findAll();

}
