import org.junit.Test;
import static org.junit.Assert.*;

public class EasyConversionMachineTest {
	
	@Test(timeout=2000)
	public void test0() {
		String originalWord = "aababba";
		String finalWord = "bbbbbbb";
		int k = 2;
		assertEquals("IMPOSSIBLE", new EasyConversionMachine().isItPossible(originalWord, finalWord, k));
	}
	
	@Test(timeout=2000)
	public void test1() {
		String originalWord = "aabb";
		String finalWord = "aabb";
		int k = 1;
		assertEquals("IMPOSSIBLE", new EasyConversionMachine().isItPossible(originalWord, finalWord, k));
	}
	
	@Test(timeout=2000)
	public void test2() {
		String originalWord = "aaaaabaa";
		String finalWord = "bbbbbabb";
		int k = 8;
		assertEquals("POSSIBLE", new EasyConversionMachine().isItPossible(originalWord, finalWord, k));
	}
	
	@Test(timeout=2000)
	public void test3() {
		String originalWord = "aaa";
		String finalWord = "bab";
		int k = 4;
		assertEquals("POSSIBLE", new EasyConversionMachine().isItPossible(originalWord, finalWord, k));
	}
	
	@Test(timeout=2000)
	public void test4() {
		String originalWord = "aababbabaa";
		String finalWord = "abbbbaabab";
		int k = 9;
		assertEquals("IMPOSSIBLE", new EasyConversionMachine().isItPossible(originalWord, finalWord, k));
	}
}
