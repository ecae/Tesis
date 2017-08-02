package clasem.repositories;

import clasem.entities.user.Log;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public interface LogRepository extends JpaRepository<Log,Serializable> {
}