import org.junit.Test;
import static org.junit.Assert.*;

public class MagicNamingTest {
	
	@Test(timeout=2000)
	public void test0() {
		String magicName = "aba";
		assertEquals(2, new MagicNaming().maxReindeers(magicName));
	}
	
	@Test(timeout=2000)
	public void test1() {
		String magicName = "babbaba";
		assertEquals(2, new MagicNaming().maxReindeers(magicName));
	}
	
	@Test(timeout=2000)
	public void test2() {
		String magicName = "philosophersstone";
		assertEquals(5, new MagicNaming().maxReindeers(magicName));
	}
	
	@Test(timeout=2000)
	public void test3() {
		String magicName = "knuthmorrispratt";
		assertEquals(7, new MagicNaming().maxReindeers(magicName));
	}
	
	@Test(timeout=2000)
	public void test4() {
		String magicName = "acrushpetrtourist";
		assertEquals(7, new MagicNaming().maxReindeers(magicName));
	}
	
	@Test(timeout=2000)
	public void test5() {
		String magicName = "zzzzz";
		assertEquals(5, new MagicNaming().maxReindeers(magicName));
	}
}
