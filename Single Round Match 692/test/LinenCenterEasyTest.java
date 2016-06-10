import org.junit.Test;
import static org.junit.Assert.*;

public class LinenCenterEasyTest {
	
	@Test(timeout=2000)
	public void test0() {
		String S = "xy";
		int N = 2;
		int K = 1;
		assertEquals(2079, new LinenCenterEasy().countStrings(S, N, K));
	}
	
	@Test(timeout=2000)
	public void test1() {
		String S = "q";
		int N = 2;
		int K = 1;
		assertEquals(1926, new LinenCenterEasy().countStrings(S, N, K));
	}
	
	@Test(timeout=2000)
	public void test2() {
		String S = "ababab";
		int N = 5;
		int K = 4;
		assertEquals(527166180, new LinenCenterEasy().countStrings(S, N, K));
	}
	
	@Test(timeout=2000)
	public void test3() {
		String S = "fgcdx";
		int N = 10;
		int K = 3;
		assertEquals(586649223, new LinenCenterEasy().countStrings(S, N, K));
	}
	
	@Test(timeout=2000)
	public void test4() {
		String S = "ghjhhhgjhjhgjhghghjhjg";
		int N = 8;
		int K = 10;
		assertEquals(192161304, new LinenCenterEasy().countStrings(S, N, K));
	}
	
	@Test(timeout=2000)
	public void test5() {
		String S = "pdpfrpfdfdpfdpfdpfpdfldfpfldpfe" ;
		int N = 49;
		int K = 25;
		assertEquals(164673990, new LinenCenterEasy().countStrings(S, N, K));
	}
	
	@Test(timeout=2000)
	public void test6() {
		String S = "a";
		int N = 7;
		int K = 0;
		assertEquals(357828722, new LinenCenterEasy().countStrings(S, N, K));
	}
	
	@Test(timeout=2000)
	public void test7() {
		String S = "eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee" ;
		int N = 50;
		int K = 50;
		assertEquals(960113657, new LinenCenterEasy().countStrings(S, N, K));
	}
}
