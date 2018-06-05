import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class KhanTest {

	CalcPro obj;
	int num1,num2,age;
	@Before
	public void setUp() throws Exception {
		obj=new CalcPro();
		num1=10;num2=12;age=59;
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		assertEquals("Success",22,obj.add(num1,num2));
	}
	@Test
	public void test1() {
		assertEquals("Success",obj.age(age));
	}

}
