import domain.Account;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import part2.some_beans_with_annotation.service.UserService;
import part3.all_beans_with_annotation.MySpringConfig;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = MySpringConfig.class)
public class SpringTest_3 {
    @Autowired
    UserService us;

    @Test
    public void test1() {
        List<Account> list = us.findAll();
        for (Account account : list) {
            System.out.println(account);
        }
    }
}
