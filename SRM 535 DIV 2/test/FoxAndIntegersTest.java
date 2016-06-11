import org.junit.Test;
import static org.junit.Assert.*;

public class FoxAndIntegersTest {
	
	@Test(timeout=2000)
	public void test0() {
		int AminusB = 1;
		int BminusC = -2;
		int AplusB = 3;
		int BplusC = 4;
		assertArrayEquals(new int[] {2, 1, 3 }, new FoxAndIntegers().get(AminusB, BminusC, AplusB, BplusC));
	}
	
	@Test(timeout=2000)
	public void test1() {
		int AminusB = 0;
		int BminusC = 0;
		int AplusB = 5;
		int BplusC = 5;
		assertArrayEquals(new int[] { }, new FoxAndIntegers().get(AminusB, BminusC, AplusB, BplusC));
	}
	
	@Test(timeout=2000)
	public void test2() {
		int AminusB = 10;
		int BminusC = -23;
		int AplusB = -10;
		int BplusC = 3;
		assertArrayEquals(new int[] {0, -10, 13 }, new FoxAndIntegers().get(AminusB, BminusC, AplusB, BplusC));
	}
	
	@Test(timeout=2000)
	public void test3() {
		int AminusB = -27;
		int BminusC = 14;
		int AplusB = 13;
		int BplusC = 22;
		assertArrayEquals(new int[] { }, new FoxAndIntegers().get(AminusB, BminusC, AplusB, BplusC));
	}
	
	@Test(timeout=2000)
	public void test4() {
		int AminusB = 30;
		int BminusC = 30;
		int AplusB = 30;
		int BplusC = -30;
		assertArrayEquals(new int[] {30, 0, -30 }, new FoxAndIntegers().get(AminusB, BminusC, AplusB, BplusC));
	}
}
