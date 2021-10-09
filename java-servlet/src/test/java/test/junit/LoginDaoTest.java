package test.junit;

import org.junit.Test;

import exercise.login1.LoginDao;
import orm.domain.User;

public class LoginDaoTest {
	LoginDao loginDao = new LoginDao();
	
	@Test
	public void test1() {
		User loginInfo = new User();
		loginInfo.setUsername("Jacky");
		loginInfo.setPassword("8768685");
		
		User user = loginDao.login(loginInfo);
		System.out.println(user);
	}
}