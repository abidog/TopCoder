import org.junit.Test;
import static org.junit.Assert.*;

public class BinaryPolynomialDivTwoTest {
	
	@Test(timeout=2000)
	public void test0() {
		int[] a = new int[] {1, 0, 1};
		assertEquals(1, new BinaryPolynomialDivTwo().countRoots(a));
	}
	
	@Test(timeout=2000)
	public void test1() {
		int[] a = new int[] {0, 1, 0, 1};
		assertEquals(2, new BinaryPolynomialDivTwo().countRoots(a));
	}
	
	@Test(timeout=2000)
	public void test2() {
		int[] a = new int[] {1};
		assertEquals(0, new BinaryPolynomialDivTwo().countRoots(a));
	}
	
	@Test(timeout=2000)
	public void test3() {
		int[] a = new int[] {1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 1, 1};
		assertEquals(0, new BinaryPolynomialDivTwo().countRoots(a));
	}
	
	@Test(timeout=2000)
	public void test4() {
		int[] a = new int[] {1, 0, 1, 1, 1, 1, 0, 0, 1, 1, 0, 1, 0, 1, 1, 0, 0, 0, 0, 0, 1, 0, 1, 1, 0,
 0, 0, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 0, 1, 0, 1, 1, 1, 1, 0, 1, 0, 0, 1, 1};
		assertEquals(1, new BinaryPolynomialDivTwo().countRoots(a));
	}
}
