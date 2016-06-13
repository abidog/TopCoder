import org.junit.Test;
import static org.junit.Assert.*;

public class CaptureFishTest {
	
	@Test(timeout=2000)
	public void test0() {
		String fish = "OXOXO";
		assertEquals(0, new CaptureFish().getParity(fish));
	}
	
	@Test(timeout=2000)
	public void test1() {
		String fish = "OO";
		assertEquals(1, new CaptureFish().getParity(fish));
	}
	
	@Test(timeout=2000)
	public void test2() {
		String fish = "**OX**";
		assertEquals(0, new CaptureFish().getParity(fish));
	}
	
	@Test(timeout=2000)
	public void test3() {
		String fish = "O***O***O***O";
		assertEquals(1, new CaptureFish().getParity(fish));
	}
}
