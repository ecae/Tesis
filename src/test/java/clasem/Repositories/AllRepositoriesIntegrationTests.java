package clasem.Repositories;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.springframework.boot.test.context.SpringBootTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({AuthorityRepositoryIT.class, UserRepositoryIT.class})
@SpringBootTest
public class AllRepositoriesIntegrationTests {
}
