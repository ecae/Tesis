package clasem.repositories;

import clasem.entities.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
    User findByDni(String dni);
    User findByCellphone(String cellphone);
    User findById(Long id);
    User findByEmail(String email);

}
