package clasem.Repositories;

import clasem.entities.user.Authority;
import clasem.repositories.AuthorityRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertTrue;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class AuthorityRepositoryIT {

    @Autowired
    private AuthorityRepository authorityRepository;

    @Test
    public void testCountAuthority() {
        List<Authority> authorities = authorityRepository.findAll();
        assertTrue(authorities.size() == 2);
    }
}
