import org.junit.Test;
import static org.junit.Assert.*;

public class CutTest {
	
	@Test(timeout=2000)
	public void test0() {
		int[] eelLengths = new int[] {13, 20, 13};
		int maxCuts = 2;
		assertEquals(3, new Cut().getMaximum(eelLengths, maxCuts));
	}
	
	@Test(timeout=2000)
	public void test1() {
		int[] eelLengths = new int[] {5, 5, 5, 5};
		int maxCuts = 2;
		assertEquals(0, new Cut().getMaximum(eelLengths, maxCuts));
	}
	
	@Test(timeout=2000)
	public void test2() {
		int[] eelLengths = new int[] {34, 10, 48};
		int maxCuts = 4;
		assertEquals(5, new Cut().getMaximum(eelLengths, maxCuts));
	}
	
	@Test(timeout=2000)
	public void test3() {
		int[] eelLengths = new int[] {30, 50, 30, 50};
		int maxCuts = 350;
		assertEquals(16, new Cut().getMaximum(eelLengths, maxCuts));
	}
}
