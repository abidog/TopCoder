import org.junit.Test;
import static org.junit.Assert.*;

public class MinskyMysteryDiv2Test {
	
	@Test(timeout=2000)
	public void test0() {
		long N = 2L;
		assertEquals(3L, new MinskyMysteryDiv2().computeAnswer(N));
	}
	
	@Test(timeout=2000)
	public void test1() {
		long N = 3L;
		assertEquals(4L, new MinskyMysteryDiv2().computeAnswer(N));
	}
	
	@Test(timeout=2000)
	public void test2() {
		long N = 4L;
		assertEquals(4L, new MinskyMysteryDiv2().computeAnswer(N));
	}
	
	@Test(timeout=2000)
	public void test3() {
		long N = 15L;
		assertEquals(8L, new MinskyMysteryDiv2().computeAnswer(N));
	}
	
	@Test(timeout=2000)
	public void test4() {
		long N = 24L;
		assertEquals(14L, new MinskyMysteryDiv2().computeAnswer(N));
	}
}
