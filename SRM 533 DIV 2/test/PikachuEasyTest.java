import org.junit.Test;
import static org.junit.Assert.*;

public class PikachuEasyTest {
	
	@Test(timeout=2000)
	public void test0() {
		String word = "pikapi";
		assertEquals("YES", new PikachuEasy().check(word));
	}
	
	@Test(timeout=2000)
	public void test1() {
		String word = "pipikachu";
		assertEquals("YES", new PikachuEasy().check(word));
	}
	
	@Test(timeout=2000)
	public void test2() {
		String word = "pikaqiu";
		assertEquals("NO", new PikachuEasy().check(word));
	}
	
	@Test(timeout=2000)
	public void test3() {
		String word = "topcoder";
		assertEquals("NO", new PikachuEasy().check(word));
	}
	
	@Test(timeout=2000)
	public void test4() {
		String word = "piika";
		assertEquals("NO", new PikachuEasy().check(word));
	}
	
	@Test(timeout=2000)
	public void test5() {
		String word = "chupikachupipichu";
		assertEquals("YES", new PikachuEasy().check(word));
	}
	
	@Test(timeout=2000)
	public void test6() {
		String word = "pikapipachu";
		assertEquals("NO", new PikachuEasy().check(word));
	}
}
