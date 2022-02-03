import domain.Account;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import part1.config_by_xml.service.AccountService;
import part2.config_by_annotation.service.UserService;

import java.util.List;

public class SpringBaseTest {
    private static ApplicationContext ac1, ac2;

    static {
        ac1 = new ClassPathXmlApplicationContext("springbase.cfg1.xml");
        ac2 = new ClassPathXmlApplicationContext("springbase.cfg2.xml");
    }

    @Before
    public void doBeforeEachTest() {
        System.out.println("test begin");
    }

    @After
    public void doAfterEachTest() {
        System.out.println("test end");
    }

    @Test
    public void test1() {
        AccountService as = ac1.getBean("accountService", AccountService.class);
        List<Account> list = as.findAll();
        for (Account account : list) {
            System.out.println(account);
        }
    }

    @Test
    public void test2() {
        UserService as = ac2.getBean("userService", UserService.class);
        List<Account> list = as.findAll();
        for (Account account : list) {
            System.out.println(account);
        }
    }
}
