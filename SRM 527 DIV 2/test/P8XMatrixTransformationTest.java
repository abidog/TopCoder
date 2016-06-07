import org.junit.Test;
import static org.junit.Assert.*;

public class P8XMatrixTransformationTest {
	
	@Test(timeout=2000)
	public void test0() {
		String[] original = new String[] {"01"
,"11"};
		String[] target = new String[] {"11"
,"10"};
		assertEquals("YES", new P8XMatrixTransformation().solve(original, target));
	}
	
	@Test(timeout=2000)
	public void test1() {
		String[] original = new String[] {"0111"
,"0011"};
		String[] target = new String[] {"1011"
,"1100"};
		assertEquals("YES", new P8XMatrixTransformation().solve(original, target));
	}
	
	@Test(timeout=2000)
	public void test2() {
		String[] original = new String[] {"0"};
		String[] target = new String[] {"1"};
		assertEquals("NO", new P8XMatrixTransformation().solve(original, target));
	}
	
	@Test(timeout=2000)
	public void test3() {
		String[] original = new String[] {"1111"
,"1111"
,"0000"
,"0000"};
		String[] target = new String[] {"1111"
,"1111"
,"0000"
,"0000"};
		assertEquals("YES", new P8XMatrixTransformation().solve(original, target));
	}
	
	@Test(timeout=2000)
	public void test4() {
		String[] original = new String[] {"0110"
,"1001"
,"0110"};
		String[] target = new String[] {"1111"
,"0110"
,"0000"};
		assertEquals("YES", new P8XMatrixTransformation().solve(original, target));
	}
	
	@Test(timeout=2000)
	public void test5() {
		String[] original = new String[] {"0000"
,"1111"
,"0000"};
		String[] target = new String[] {"1111"
,"0000"
,"1111"};
		assertEquals("NO", new P8XMatrixTransformation().solve(original, target));
	}
}
