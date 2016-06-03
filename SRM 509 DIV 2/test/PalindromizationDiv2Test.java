import org.junit.Test;
import static org.junit.Assert.*;

public class PalindromizationDiv2Test {
	
	@Test(timeout=2000)
	public void test0() {
		int X = 25;
		assertEquals(3, new PalindromizationDiv2().getMinimumCost(X));
	}
	
	@Test(timeout=2000)
	public void test1() {
		int X = 12321;
		assertEquals(0, new PalindromizationDiv2().getMinimumCost(X));
	}
	
	@Test(timeout=2000)
	public void test2() {
		int X = 40;
		assertEquals(4, new PalindromizationDiv2().getMinimumCost(X));
	}
	
	@Test(timeout=2000)
	public void test3() {
		int X = 2011;
		assertEquals(9, new PalindromizationDiv2().getMinimumCost(X));
	}
	
	@Test(timeout=2000)
	public void test4() {
		int X = 0;
		assertEquals(0, new PalindromizationDiv2().getMinimumCost(X));
	}
}
