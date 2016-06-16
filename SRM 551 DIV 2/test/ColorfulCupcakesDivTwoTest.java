import org.junit.Test;
import static org.junit.Assert.*;

public class ColorfulCupcakesDivTwoTest {
	
	@Test(timeout=2000)
	public void test0() {
		String cupcakes = "ABAB";
		assertEquals(2, new ColorfulCupcakesDivTwo().countArrangements(cupcakes));
	}
	
	@Test(timeout=2000)
	public void test1() {
		String cupcakes = "ABABA";
		assertEquals(0, new ColorfulCupcakesDivTwo().countArrangements(cupcakes));
	}
	
	@Test(timeout=2000)
	public void test2() {
		String cupcakes = "ABC";
		assertEquals(6, new ColorfulCupcakesDivTwo().countArrangements(cupcakes));
	}
	
	@Test(timeout=2000)
	public void test3() {
		String cupcakes = "ABABABABABABABABABABABABABABABABABABABABABABABABAB";
		assertEquals(2, new ColorfulCupcakesDivTwo().countArrangements(cupcakes));
	}
	
	@Test(timeout=2000)
	public void test4() {
		String cupcakes = "BCBABBACBABABCCCCCAABBAACBBBBCBCAAA";
		assertEquals(741380640, new ColorfulCupcakesDivTwo().countArrangements(cupcakes));
	}
}
