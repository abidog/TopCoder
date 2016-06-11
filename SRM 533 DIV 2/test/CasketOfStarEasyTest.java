import org.junit.Test;
import static org.junit.Assert.*;

public class CasketOfStarEasyTest {
	
	@Test(timeout=2000)
	public void test0() {
		int[] weight = new int[] {1,2,3,4};
		assertEquals(12, new CasketOfStarEasy().maxEnergy(weight));
	}
	
	@Test(timeout=2000)
	public void test1() {
		int[] weight = new int[] {100,2,1,3,100};
		assertEquals(10400, new CasketOfStarEasy().maxEnergy(weight));
	}
	
	@Test(timeout=2000)
	public void test2() {
		int[] weight = new int[] {2,2,7,6,90,5,9};
		assertEquals(1818, new CasketOfStarEasy().maxEnergy(weight));
	}
	
	@Test(timeout=2000)
	public void test3() {
		int[] weight = new int[] {477,744,474,777,447,747,777,474};
		assertEquals(2937051, new CasketOfStarEasy().maxEnergy(weight));
	}
	
	@Test(timeout=2000)
	public void test4() {
		int[] weight = new int[] {1,1,1,1,1,1,1,1,1,1};
		assertEquals(8, new CasketOfStarEasy().maxEnergy(weight));
	}
}
