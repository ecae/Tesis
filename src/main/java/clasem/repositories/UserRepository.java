package clasem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import clasem.entities.User;


public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
    User findById(Long id);
}
