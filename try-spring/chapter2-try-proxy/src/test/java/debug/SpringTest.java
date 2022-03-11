package debug;

import demo.MySpringConfig;
import demo.part3.transaction.AccountService;
import demo.part3.transaction.impl.use_proxy.MyProxyFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = MySpringConfig.class)
public class SpringTest {
    @Resource(name = "accountService1")
    AccountService accountService;
    @Autowired
    MyProxyFactory factory;

    /**
     * 测试没有使用动态代理的案例
     */
    @Test
    public void test1() {
        accountService.transfer("jack", "mike", 5000f);
    }

    /**
     * 测试使用动态代理的案例
     */
    @Test
    public void test2() {
        AccountService proxy1 = factory.getAccountService();
        proxy1.transfer("mike", "jack", 5000f);
    }
}
