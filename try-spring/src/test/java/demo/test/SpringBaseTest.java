package demo.test;

import demo.domain.Account;
import demo.springbase.config_by_xml.service.AccountService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class SpringBaseTest {
    private static ApplicationContext ac1, ac2;

    static {
        //ac1 = new ClassPathXmlApplicationContext("springbase.cfg1.xml");
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
        AccountService as = ac2.getBean("accountServiceImpl", AccountService.class);
        List<Account> list = as.findAll();
        for (Account account : list) {
            System.out.println(account);
        }
    }
}
