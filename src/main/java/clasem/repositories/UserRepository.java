package clasem.repositories;

import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

import clasem.entities.user.User;


public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
    User findByDni(String dni);
    User findByCellphone(String cellphone);
    User findById(Long id);
    User findByEmail(String email);

}
