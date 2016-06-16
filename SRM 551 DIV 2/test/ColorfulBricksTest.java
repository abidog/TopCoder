import org.junit.Test;
import static org.junit.Assert.*;

public class ColorfulBricksTest {
	
	@Test(timeout=2000)
	public void test0() {
		String bricks = "ABAB";
		assertEquals(2, new ColorfulBricks().countLayouts(bricks));
	}
	
	@Test(timeout=2000)
	public void test1() {
		String bricks = "AAA";
		assertEquals(1, new ColorfulBricks().countLayouts(bricks));
	}
	
	@Test(timeout=2000)
	public void test2() {
		String bricks = "WXYZ";
		assertEquals(0, new ColorfulBricks().countLayouts(bricks));
	}
}
