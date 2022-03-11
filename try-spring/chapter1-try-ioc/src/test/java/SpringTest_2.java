import domain.Account;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import part1.all_beans_in_xml.service.AccountService;
import part2.not_all_beans_in_xml.service.UserService;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:springbase.cfg1.xml", "classpath:springbase.cfg2.xml"})
public class SpringTest_2 {
    @Autowired
    AccountService as;
    @Autowired
    UserService us;

    @Test
    public void test1() {
        List<Account> list = as.findAll();
        for (Account account : list) {
            System.out.println(account);
        }
    }

    @Test
    public void test2() {
        List<Account> list = us.findAll();
        for (Account account : list) {
            System.out.println(account);
        }
    }
}
