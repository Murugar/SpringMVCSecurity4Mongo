package integration.user;

import javax.annotation.Resource;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.iqmsoft.spring.security.mongo.domain.User;
import com.iqmsoft.spring.security.mongo.repositories.UserRepositoryDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "mongo-config-test.xml" })
public class UserIntegrationTest {

	@Resource
	private UserRepositoryDao userRespositoryDao;

	@Resource
	private MongoTemplate mongoTemplate;


	@Before
	public void before(){
		mongoTemplate.dropCollection(User.class);
	}


	@Test
	public void yourTest(){

	}

	@After
	public void after(){
		mongoTemplate.dropCollection(User.class);
	}
}
