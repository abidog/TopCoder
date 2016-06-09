import org.junit.Test;
import static org.junit.Assert.*;

public class YetAnotherTwoTeamsProblemTest {
	
	@Test(timeout=2000)
	public void test0() {
		int[] skill = new int[] {5, 4, 7, 6};
		assertEquals(2L, new YetAnotherTwoTeamsProblem().count(skill));
	}
	
	@Test(timeout=2000)
	public void test1() {
		int[] skill = new int[] {1, 1, 1, 1, 1};
		assertEquals(10L, new YetAnotherTwoTeamsProblem().count(skill));
	}
	
	@Test(timeout=2000)
	public void test2() {
		int[] skill = new int[] {1, 2, 3, 5, 10};
		assertEquals(5L, new YetAnotherTwoTeamsProblem().count(skill));
	}
	
	@Test(timeout=2000)
	public void test3() {
		int[] skill = new int[] {1, 2, 3, 4, 10};
		assertEquals(0L, new YetAnotherTwoTeamsProblem().count(skill));
	}
	
	@Test(timeout=2000)
	public void test4() {
		int[] skill = new int[] {999, 999, 999, 1000, 1000, 1001, 999, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000,
 1000, 1000, 1000, 999, 1000, 512, 511, 1001, 1001, 1001, 1001, 1001, 1000};
		assertEquals(17672631900L, new YetAnotherTwoTeamsProblem().count(skill));
	}
}
