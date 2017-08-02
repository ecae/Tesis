package clasem.Repositories;

import clasem.entities.user.User;
import clasem.repositories.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UserRepositoryIT {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testCreate() {
        assertTrue(userRepository.count() == 3);
    }

    @Test
    public void testUserSizeRole() {

        User user = userRepository.findByUsername("admin");
        assertTrue(user.getAuthorities().size() == 2);
    }

}
