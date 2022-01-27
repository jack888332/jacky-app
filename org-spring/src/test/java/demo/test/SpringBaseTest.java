package demo.test;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringBaseTest {
    private static ApplicationContext ac;

    static {
       ac = new ClassPathXmlApplicationContext();
    }

    @Before
    public void doBeforeEachTest() {
        System.out.println("begin test");
    }

    @After
    public void doAfterEachTest() {
        System.out.println("end test");
    }

    @Test
    public void test1() {
        ac.getBean("");
    }

}
