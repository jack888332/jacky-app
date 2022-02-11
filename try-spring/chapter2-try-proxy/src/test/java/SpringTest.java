import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import part3.run_transaction_without_proxy.service.AccountService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = part3.run_transaction_without_proxy.MySpringConfig.class)
public class SpringTest {
    @Autowired
    AccountService as;

    @Test
    public void test1() {
        as.transfer("jack", "mike", 5000f);
    }
}
