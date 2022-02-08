import domain.Account;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import part3.apply_to_transaction.service.AccountService;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = part3.apply_to_transaction.MySpringConfig.class)
public class SpringTest {
    @Autowired
    AccountService as;


    @Test
    public void test1() {
        as.transfer("jack", "mike", 5000f);
    }
}
