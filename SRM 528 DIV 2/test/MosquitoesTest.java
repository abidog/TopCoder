import org.junit.Test;
import static org.junit.Assert.*;

public class MosquitoesTest {
	
	@Test(timeout=2000)
	public void test0() {
		int[] xInit = new int[] {1, -1};
		int[] v = new int[] {1, -1};
		int R = 10;
		assertEquals(2, new Mosquitoes().getMaximum(xInit, v, R));
	}
	
	@Test(timeout=2000)
	public void test1() {
		int[] xInit = new int[] {100, -100};
		int[] v = new int[] {1, -1};
		int R = 10;
		assertEquals(1, new Mosquitoes().getMaximum(xInit, v, R));
	}
	
	@Test(timeout=2000)
	public void test2() {
		int[] xInit = new int[] {0, -1, 10, -11, 99, -99};
		int[] v = new int[] {1, -1, -3, 3, 47, -47};
		int R = 3;
		assertEquals(4, new Mosquitoes().getMaximum(xInit, v, R));
	}
	
	@Test(timeout=2000)
	public void test3() {
		int[] xInit = new int[] {5};
		int[] v = new int[] {2};
		int R = 8;
		assertEquals(1, new Mosquitoes().getMaximum(xInit, v, R));
	}
	
	@Test(timeout=2000)
	public void test4() {
		int[] xInit = new int[] {12,34,56,78,90};
		int[] v = new int[] {-1,2,-3,4,-5};
		int R = 6;
		assertEquals(3, new Mosquitoes().getMaximum(xInit, v, R));
	}
}
