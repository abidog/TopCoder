import org.junit.Test;
import static org.junit.Assert.*;

public class BoardSplittingTest {
	
	@Test(timeout=2000)
	public void test0() {
		int desiredLength = 5;
		int desiredCount = 4;
		int actualLength = 4;
		assertEquals(3, new BoardSplitting().minimumCuts(desiredLength, desiredCount, actualLength));
	}
	
	@Test(timeout=2000)
	public void test1() {
		int desiredLength = 6;
		int desiredCount = 100;
		int actualLength = 3;
		assertEquals(0, new BoardSplitting().minimumCuts(desiredLength, desiredCount, actualLength));
	}
	
	@Test(timeout=2000)
	public void test2() {
		int desiredLength = 500;
		int desiredCount = 5;
		int actualLength = 1000;
		assertEquals(3, new BoardSplitting().minimumCuts(desiredLength, desiredCount, actualLength));
	}
	
	@Test(timeout=2000)
	public void test3() {
		int desiredLength = 314;
		int desiredCount = 159;
		int actualLength = 26;
		assertEquals(147, new BoardSplitting().minimumCuts(desiredLength, desiredCount, actualLength));
	}
}
