import org.junit.Test;
import static org.junit.Assert.*;

public class EllysXorsTest {
	
	@Test(timeout=2000)
	public void test0() {
		long L = 3L;
		long R = 10L;
		assertEquals(8L, new EllysXors().getXor(L, R));
	}
	
	@Test(timeout=2000)
	public void test1() {
		long L = 5L;
		long R = 5L;
		assertEquals(5L, new EllysXors().getXor(L, R));
	}
	
	@Test(timeout=2000)
	public void test2() {
		long L = 13L;
		long R = 42L;
		assertEquals(39L, new EllysXors().getXor(L, R));
	}
	
	@Test(timeout=2000)
	public void test3() {
		long L = 666L;
		long R = 1337L;
		assertEquals(0L, new EllysXors().getXor(L, R));
	}
	
	@Test(timeout=2000)
	public void test4() {
		long L = 1234567L;
		long R = 89101112L;
		assertEquals(89998783L, new EllysXors().getXor(L, R));
	}
}
