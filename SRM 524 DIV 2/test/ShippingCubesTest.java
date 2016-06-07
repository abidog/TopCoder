import org.junit.Test;
import static org.junit.Assert.*;

public class ShippingCubesTest {
	
	@Test(timeout=2000)
	public void test0() {
		int N = 1;
		assertEquals(3, new ShippingCubes().minimalCost(N));
	}
	
	@Test(timeout=2000)
	public void test1() {
		int N = 6;
		assertEquals(6, new ShippingCubes().minimalCost(N));
	}
	
	@Test(timeout=2000)
	public void test2() {
		int N = 7;
		assertEquals(9, new ShippingCubes().minimalCost(N));
	}
	
	@Test(timeout=2000)
	public void test3() {
		int N = 200;
		assertEquals(18, new ShippingCubes().minimalCost(N));
	}
}
