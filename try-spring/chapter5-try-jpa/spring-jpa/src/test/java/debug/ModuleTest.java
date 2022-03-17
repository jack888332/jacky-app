package debug;

import demo.MySpringConfig;
import demo.domain.Customer;
import demo.repository.CustomerDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = MySpringConfig.class)
public class ModuleTest {
    @Autowired
    private CustomerDao customerDao;

    /**
     * 尝试插入数据
     */
    @Test
    public void test1() {
        Customer customer = new Customer();
        customer.setName("Jacky");
        customer.setLevel("高级");
        customer.setAddress("天堂");

        customerDao.save(customer);
    }
}
