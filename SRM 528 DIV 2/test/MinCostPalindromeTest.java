import org.junit.Test;
import static org.junit.Assert.*;

public class MinCostPalindromeTest {
	
	@Test(timeout=2000)
	public void test0() {
		String s = "oxo?xox?";
		int oCost = 3;
		int xCost = 5;
		assertEquals(8, new MinCostPalindrome().getMinimum(s, oCost, xCost));
	}
	
	@Test(timeout=2000)
	public void test1() {
		String s = "x??x";
		int oCost = 9;
		int xCost = 4;
		assertEquals(8, new MinCostPalindrome().getMinimum(s, oCost, xCost));
	}
	
	@Test(timeout=2000)
	public void test2() {
		String s = "ooooxxxx";
		int oCost = 12;
		int xCost = 34;
		assertEquals(-1, new MinCostPalindrome().getMinimum(s, oCost, xCost));
	}
	
	@Test(timeout=2000)
	public void test3() {
		String s = "oxoxooxxxxooxoxo";
		int oCost = 7;
		int xCost = 4;
		assertEquals(0, new MinCostPalindrome().getMinimum(s, oCost, xCost));
	}
	
	@Test(timeout=2000)
	public void test4() {
		String s = "?o";
		int oCost = 6;
		int xCost = 2;
		assertEquals(6, new MinCostPalindrome().getMinimum(s, oCost, xCost));
	}
	
	@Test(timeout=2000)
	public void test5() {
		String s = "????????????????????";
		int oCost = 50;
		int xCost = 49;
		assertEquals(980, new MinCostPalindrome().getMinimum(s, oCost, xCost));
	}
	
	@Test(timeout=2000)
	public void test6() {
		String s = "o??oxxo?xoox?ox??x??" ;
		int oCost = 3;
		int xCost = 10;
		assertEquals(38, new MinCostPalindrome().getMinimum(s, oCost, xCost));
	}
}
