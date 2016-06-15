import org.junit.Test;
import static org.junit.Assert.*;

public class MinimalTriangleTest {
	
	@Test(timeout=2000)
	public void test0() {
		int length = 5;
		assertEquals(10.825317547305485, new MinimalTriangle().maximalArea(length), 1e-9);
	}
	
	@Test(timeout=2000)
	public void test1() {
		int length = 10;
		assertEquals(43.30127018922194, new MinimalTriangle().maximalArea(length), 1e-9);
	}
	
	@Test(timeout=2000)
	public void test2() {
		int length = 100000;
		assertEquals(4.330127018922194E9, new MinimalTriangle().maximalArea(length), 1e-9);
	}
}
