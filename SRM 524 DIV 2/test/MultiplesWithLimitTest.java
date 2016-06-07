import org.junit.Test;
import static org.junit.Assert.*;

public class MultiplesWithLimitTest {
	
	@Test(timeout=2000)
	public void test0() {
		int N = 8;
		int[] forbiddenDigits = new int[] {2,3,4,5,6,7,8,9};
		assertEquals("1000", new MultiplesWithLimit().minMultiples(N, forbiddenDigits));
	}
	
	@Test(timeout=2000)
	public void test1() {
		int N = 9;
		int[] forbiddenDigits = new int[] {1,3,4,5,6,7,8,9};
		assertEquals("222...222(9 digits)", new MultiplesWithLimit().minMultiples(N, forbiddenDigits));
	}
	
	@Test(timeout=2000)
	public void test2() {
		int N = 524;
		int[] forbiddenDigits = new int[] {5,2,4};
		assertEquals("3668", new MultiplesWithLimit().minMultiples(N, forbiddenDigits));
	}
	
	@Test(timeout=2000)
	public void test3() {
		int N = 10000;
		int[] forbiddenDigits = new int[] {0};
		assertEquals("IMPOSSIBLE", new MultiplesWithLimit().minMultiples(N, forbiddenDigits));
	}
	
	@Test(timeout=2000)
	public void test4() {
		int N = 1;
		int[] forbiddenDigits = new int[] {0,1,2,3,4,5,6,7,8,9};
		assertEquals("IMPOSSIBLE", new MultiplesWithLimit().minMultiples(N, forbiddenDigits));
	}
}
