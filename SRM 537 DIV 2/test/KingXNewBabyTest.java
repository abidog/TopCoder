import org.junit.Test;
import static org.junit.Assert.*;

public class KingXNewBabyTest {
	
	@Test(timeout=2000)
	public void test0() {
		String name = "dengklek";
		assertEquals("YES", new KingXNewBaby().isValid(name));
	}
	
	@Test(timeout=2000)
	public void test1() {
		String name = "gofushar";
		assertEquals("NO", new KingXNewBaby().isValid(name));
	}
	
	@Test(timeout=2000)
	public void test2() {
		String name = "dolphinigle";
		assertEquals("NO", new KingXNewBaby().isValid(name));
	}
	
	@Test(timeout=2000)
	public void test3() {
		String name = "mystictc";
		assertEquals("NO", new KingXNewBaby().isValid(name));
	}
	
	@Test(timeout=2000)
	public void test4() {
		String name = "rngringo";
		assertEquals("NO", new KingXNewBaby().isValid(name));
	}
	
	@Test(timeout=2000)
	public void test5() {
		String name = "misof";
		assertEquals("NO", new KingXNewBaby().isValid(name));
	}
	
	@Test(timeout=2000)
	public void test6() {
		String name = "metelsky";
		assertEquals("YES", new KingXNewBaby().isValid(name));
	}
}
