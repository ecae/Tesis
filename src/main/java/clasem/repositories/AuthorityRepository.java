package clasem.repositories;

import clasem.entities.user.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityRepository extends JpaRepository<Authority, Integer> {

    Authority findById(int id);
    Authority findByName(String name);
}
