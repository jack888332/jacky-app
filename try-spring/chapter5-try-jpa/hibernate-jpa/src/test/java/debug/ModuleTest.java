package debug;

import demo.MySpringConfig;
import demo.domain.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.persistence.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = MySpringConfig.class)
public class ModuleTest {
    @Test
    public void test1() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpa1");
        //创建实体管理类
        EntityManager manager = factory.createEntityManager();
        manager.setFlushMode(FlushModeType.AUTO);
        //获取事务对象
        EntityTransaction transaction = manager.getTransaction();

        Customer customer = new Customer();
        customer.setName("Admin");
        customer.setPhone("18824191630");

        transaction.begin();
        manager.persist(customer);
        transaction.commit();

        manager.close();
        factory.close();
    }
}
