import org.junit.Test;
import static org.junit.Assert.*;

public class BallAndHatsTest {
	
	@Test(timeout=2000)
	public void test0() {
		String hats = ".o.";
		int numSwaps = 1;
		assertEquals(0, new BallAndHats().getHat(hats, numSwaps));
	}
	
	@Test(timeout=2000)
	public void test1() {
		String hats = "..o";
		int numSwaps = 0;
		assertEquals(2, new BallAndHats().getHat(hats, numSwaps));
	}
	
	@Test(timeout=2000)
	public void test2() {
		String hats = "o..";
		int numSwaps = 1;
		assertEquals(1, new BallAndHats().getHat(hats, numSwaps));
	}
	
	@Test(timeout=2000)
	public void test3() {
		String hats = "..o";
		int numSwaps = 2;
		assertEquals(0, new BallAndHats().getHat(hats, numSwaps));
	}
	
	@Test(timeout=2000)
	public void test4() {
		String hats = "o..";
		int numSwaps = 101;
		assertEquals(1, new BallAndHats().getHat(hats, numSwaps));
	}
}
