import org.junit.Test;
import static org.junit.Assert.*;

public class MagicCandyTest {
	
	@Test(timeout=2000)
	public void test0() {
		int n = 5;
		assertEquals(5, new MagicCandy().whichOne(n));
	}
	
	@Test(timeout=2000)
	public void test1() {
		int n = 9;
		assertEquals(7, new MagicCandy().whichOne(n));
	}
	
	@Test(timeout=2000)
	public void test2() {
		int n = 20;
		assertEquals(17, new MagicCandy().whichOne(n));
	}
	
	@Test(timeout=2000)
	public void test3() {
		int n = 5265;
		assertEquals(5257, new MagicCandy().whichOne(n));
	}
	
	@Test(timeout=2000)
	public void test4() {
		int n = 20111223;
		assertEquals(20110741, new MagicCandy().whichOne(n));
	}
	
	@Test(timeout=2000)
	public void test5() {
		int n = 1;
		assertEquals(1, new MagicCandy().whichOne(n));
	}
}
