import org.junit.Test;
import static org.junit.Assert.*;

public class DengklekTryingToSleepTest {
	
	@Test(timeout=2000)
	public void test0() {
		int[] ducks = new int[] {5, 3, 2};
		assertEquals(1, new DengklekTryingToSleep().minDucks(ducks));
	}
	
	@Test(timeout=2000)
	public void test1() {
		int[] ducks = new int[] {58};
		assertEquals(0, new DengklekTryingToSleep().minDucks(ducks));
	}
	
	@Test(timeout=2000)
	public void test2() {
		int[] ducks = new int[] {9, 3, 6, 4};
		assertEquals(3, new DengklekTryingToSleep().minDucks(ducks));
	}
	
	@Test(timeout=2000)
	public void test3() {
		int[] ducks = new int[] {7, 4, 77, 47, 74, 44};
		assertEquals(68, new DengklekTryingToSleep().minDucks(ducks));
	}
	
	@Test(timeout=2000)
	public void test4() {
		int[] ducks = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		assertEquals(0, new DengklekTryingToSleep().minDucks(ducks));
	}
}
