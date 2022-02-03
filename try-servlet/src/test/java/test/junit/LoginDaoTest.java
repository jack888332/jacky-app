package test.junit;

import demo.part5.mixcode.login1.LoginDao;
import domain.User;
import org.junit.Test;

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
