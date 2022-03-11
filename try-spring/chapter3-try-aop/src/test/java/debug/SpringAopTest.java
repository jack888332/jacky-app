package debug;

import demo.MySpringConfig;
import demo.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = MySpringConfig.class)
public class SpringAopTest {
    @Autowired
    AccountService accountService;

    @Test
    public void test1() {
        accountService.transfer("mike", "jack", 5000f);
    }
}
