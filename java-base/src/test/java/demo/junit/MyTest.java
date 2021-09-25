package demo.junit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MyTest {
	private MyCalculator mc = new MyCalculator();
	
	@Before
	public void doBeforeEachTest() {
		System.out.println("do before each test");
	}
	
	@After
	public void doAfterEachTest() {
		System.out.println("do after each test");
	}

	@Test
	public void test1() {
		Assert.assertEquals(3, mc.division(3, 1));
	}

	@Test
	public void test2() {
		Assert.assertEquals(4, mc.addition(3, 1));
	}
}
