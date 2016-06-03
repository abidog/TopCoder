import org.junit.Test;
import static org.junit.Assert.*;

public class LuckyRemainderTest {
	
	@Test(timeout=2000)
	public void test0() {
		String X = "123";
		assertEquals(6, new LuckyRemainder().getLuckyRemainder(X));
	}
	
	@Test(timeout=2000)
	public void test1() {
		String X = "24816";
		assertEquals(3, new LuckyRemainder().getLuckyRemainder(X));
	}
	
	@Test(timeout=2000)
	public void test2() {
		String X = "8";
		assertEquals(8, new LuckyRemainder().getLuckyRemainder(X));
	}
	
	@Test(timeout=2000)
	public void test3() {
		String X = "11235813213455";
		assertEquals(7, new LuckyRemainder().getLuckyRemainder(X));
	}
}
