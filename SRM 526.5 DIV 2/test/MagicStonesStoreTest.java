import org.junit.Test;
import static org.junit.Assert.*;

public class MagicStonesStoreTest {
	
	@Test(timeout=2000)
	public void test0() {
		int n = 1;
		assertEquals("NO", new MagicStonesStore().ableToDivide(n));
	}
	
	@Test(timeout=2000)
	public void test1() {
		int n = 2;
		assertEquals("YES", new MagicStonesStore().ableToDivide(n));
	}
	
	@Test(timeout=2000)
	public void test2() {
		int n = 3;
		assertEquals("YES", new MagicStonesStore().ableToDivide(n));
	}
	
	@Test(timeout=2000)
	public void test3() {
		int n = 5;
		assertEquals("YES", new MagicStonesStore().ableToDivide(n));
	}
}
