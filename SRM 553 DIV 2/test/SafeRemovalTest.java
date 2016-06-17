import org.junit.Test;
import static org.junit.Assert.*;

public class SafeRemovalTest {
	
	@Test(timeout=2000)
	public void test0() {
		int[] seq = new int[] {3, 8, 4};
		int k = 1;
		assertEquals(11, new SafeRemoval().removeThem(seq, k));
	}
	
	@Test(timeout=2000)
	public void test1() {
		int[] seq = new int[] {1,1,1,1,1,1};
		int k = 3;
		assertEquals(-1, new SafeRemoval().removeThem(seq, k));
	}
	
	@Test(timeout=2000)
	public void test2() {
		int[] seq = new int[] {1,6,1,10,1,2,7,11};
		int k = 6;
		assertEquals(21, new SafeRemoval().removeThem(seq, k));
	}
	
	@Test(timeout=2000)
	public void test3() {
		int[] seq = new int[] {1,1,1,1,1,1,1,1,7};
		int k = 3;
		assertEquals(6, new SafeRemoval().removeThem(seq, k));
	}
}
