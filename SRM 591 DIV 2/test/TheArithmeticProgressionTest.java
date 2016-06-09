import org.junit.Test;
import static org.junit.Assert.*;

public class TheArithmeticProgressionTest {
	
	@Test(timeout=2000)
	public void test0() {
		int a = 0;
		int b = 1;
		int c = 2;
		assertEquals(0.0, new TheArithmeticProgression().minimumChange(a, b, c), 1e-9);
	}
	
	@Test(timeout=2000)
	public void test1() {
		int a = 0;
		int b = 2;
		int c = 1;
		assertEquals(1.5, new TheArithmeticProgression().minimumChange(a, b, c), 1e-9);
	}
	
	@Test(timeout=2000)
	public void test2() {
		int a = 3;
		int b = 2;
		int c = 1;
		assertEquals(0.0, new TheArithmeticProgression().minimumChange(a, b, c), 1e-9);
	}
	
	@Test(timeout=2000)
	public void test3() {
		int a = 4;
		int b = 4;
		int c = 8;
		assertEquals(2.0, new TheArithmeticProgression().minimumChange(a, b, c), 1e-9);
	}
}
