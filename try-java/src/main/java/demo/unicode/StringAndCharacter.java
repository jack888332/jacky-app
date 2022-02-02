package demo.unicode;

import org.junit.Before;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class StringAndCharacter {

	List<String> list = new ArrayList<>();

	@Before
	public void init() {
		IntStream.range(0, 100000).forEach((index) -> {
			list.add("str" + index);
		});
	}

	@org.junit.Test
	public void test1() {
		String ss = "";
		long startTime = System.currentTimeMillis();
		for (String s : list) {
			ss += s;
		}
		System.out.println(System.currentTimeMillis() - startTime);
	}

	@org.junit.Test
	public void test2() {
		String ss = "";
		long startTime = System.currentTimeMillis();
		for (String s : list) {
			ss = ss.concat(s);
		}
		System.out.println(System.currentTimeMillis() - startTime);
	}

	@org.junit.Test
	public void test3() {
		StringBuilder ss = new StringBuilder();
		long startTime = System.currentTimeMillis();
		for (String s : list) {
			ss.append(s);
		}
		System.out.println(System.currentTimeMillis() - startTime);
	}

//		  @org.junit.Test
//		  public void test4() {
//		    long startTime = System.currentTimeMillis();
//		    StringUtils.join(list);
//		    System.out.println(System.currentTimeMillis() - startTime);
//		  }
	@org.junit.Test
	public void test5() {
		StringBuffer ss = new StringBuffer();
		long startTime = System.currentTimeMillis();
		for (String s : list) {
			ss.append(s);
		}
		System.out.println(System.currentTimeMillis() - startTime);
	}

}
