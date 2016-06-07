import org.junit.Test;
import static org.junit.Assert.*;

public class P8XGraphBuilderTest {
	
	@Test(timeout=2000)
	public void test0() {
		int[] scores = new int[] {1, 3, 0};
		assertEquals(8, new P8XGraphBuilder().solve(scores));
	}
	
	@Test(timeout=2000)
	public void test1() {
		int[] scores = new int[] {0, 0, 0, 10};
		assertEquals(10, new P8XGraphBuilder().solve(scores));
	}
	
	@Test(timeout=2000)
	public void test2() {
		int[] scores = new int[] {1, 2, 3, 4, 5, 6};
		assertEquals(12, new P8XGraphBuilder().solve(scores));
	}
	
	@Test(timeout=2000)
	public void test3() {
		int[] scores = new int[] {5, 0, 0};
		assertEquals(15, new P8XGraphBuilder().solve(scores));
	}
	
	@Test(timeout=2000)
	public void test4() {
		int[] scores = new int[] {1, 3, 2, 5, 3, 7, 5};
		assertEquals(20, new P8XGraphBuilder().solve(scores));
	}
}
