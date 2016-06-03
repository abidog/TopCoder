import org.junit.Test;
import static org.junit.Assert.*;

public class NumberLabyrinthDiv2Test {
	
	@Test(timeout=2000)
	public void test0() {
		String[] board = new String[] {"...2",
 "....",
 "3..."};
		int r1 = 0;
		int c1 = 0;
		int r2 = 2;
		int c2 = 3;
		int K = 0;
		assertEquals(-1, new NumberLabyrinthDiv2().getMinimumNumberOfMoves(board, r1, c1, r2, c2, K));
	}
	
	@Test(timeout=2000)
	public void test1() {
		String[] board = new String[] {"...2",
                                       "....",
                                       "3..."};
		int r1 = 0;
		int c1 = 0;
		int r2 = 2;
		int c2 = 3;
		int K = 1;
		assertEquals(2, new NumberLabyrinthDiv2().getMinimumNumberOfMoves(board, r1, c1, r2, c2, K));
	}
	
	@Test(timeout=2000)
	public void test2() {
		String[] board = new String[] {"...3",
 "....",
 "2..."};
		int r1 = 0;
		int c1 = 0;
		int r2 = 2;
		int c2 = 3;
		int K = 3;
		assertEquals(3, new NumberLabyrinthDiv2().getMinimumNumberOfMoves(board, r1, c1, r2, c2, K));
	}
	
	@Test(timeout=2000)
	public void test3() {
		String[] board = new String[] {"55255",
 ".0.0.",
 "..9..",
 "..3..",
 "3.9.3",
 "44.44"};
		int r1 = 3;
		int c1 = 2;
		int r2 = 4;
		int c2 = 2;
		int K = 10;
		assertEquals(6, new NumberLabyrinthDiv2().getMinimumNumberOfMoves(board, r1, c1, r2, c2, K));
	}
	
	@Test(timeout=2000)
	public void test4() {
		String[] board = new String[] {"920909949",
 "900020000",
 "009019039",
 "190299149",
 "999990319",
 "940229120",
 "000409399",
 "999119320",
 "009939999"};
		int r1 = 7;
		int c1 = 3;
		int r2 = 1;
		int c2 = 1;
		int K = 50;
		assertEquals(10, new NumberLabyrinthDiv2().getMinimumNumberOfMoves(board, r1, c1, r2, c2, K));
	}
}
