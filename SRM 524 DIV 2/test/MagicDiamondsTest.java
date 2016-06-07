import org.junit.Test;
import static org.junit.Assert.*;

public class MagicDiamondsTest {
	
	@Test(timeout=2000)
	public void test0() {
		long n = 2L;
		assertEquals(2L, new MagicDiamonds().minimalTransfer(n));
	}
	
	@Test(timeout=2000)
	public void test1() {
		long n = 4294967297L;
		assertEquals(1L, new MagicDiamonds().minimalTransfer(n));
	}
	
	@Test(timeout=2000)
	public void test2() {
		long n = 2147483647L;
		assertEquals(2L, new MagicDiamonds().minimalTransfer(n));
	}
	
	@Test(timeout=2000)
	public void test3() {
		long n = 1L;
		assertEquals(1L, new MagicDiamonds().minimalTransfer(n));
	}
}
