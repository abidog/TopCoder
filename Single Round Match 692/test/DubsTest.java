import org.junit.Test;
import static org.junit.Assert.*;

public class DubsTest {
	
	@Test(timeout=2000)
	public void test0() {
		long L = 10L;
		long R = 10L;
		assertEquals(0L, new Dubs().count(L, R));
	}
	
	@Test(timeout=2000)
	public void test1() {
		long L = 10L;
		long R = 20L;
		assertEquals(1L, new Dubs().count(L, R));
	}
	
	@Test(timeout=2000)
	public void test2() {
		long L = 49L;
		long R = 101L;
		assertEquals(6L, new Dubs().count(L, R));
	}
	
	@Test(timeout=2000)
	public void test3() {
		long L = 1111111L;
		long R = 111111111L;
		assertEquals(11000001L, new Dubs().count(L, R));
	}
	
	@Test(timeout=2000)
	public void test4() {
		long L = 91750002841L;
		long R = 91751522033L;
		assertEquals(151920L, new Dubs().count(L, R));
	}
}
