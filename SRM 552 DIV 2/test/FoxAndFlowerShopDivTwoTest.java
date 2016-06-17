import org.junit.Test;
import static org.junit.Assert.*;

public class FoxAndFlowerShopDivTwoTest {
	
	@Test(timeout=2000)
	public void test0() {
		String[] flowers = new String[] {"F.F",
 ".F.",
 ".F."};
		int r = 1;
		int c = 1;
		assertEquals(2, new FoxAndFlowerShopDivTwo().theMaxFlowers(flowers, r, c));
	}
	
	@Test(timeout=2000)
	public void test1() {
		String[] flowers = new String[] {"F..",
 "...",
 "..."};
		int r = 0;
		int c = 0;
		assertEquals(0, new FoxAndFlowerShopDivTwo().theMaxFlowers(flowers, r, c));
	}
	
	@Test(timeout=2000)
	public void test2() {
		String[] flowers = new String[] {".FF.F.F",
 "FF...F.",
 "..FF.FF"};
		int r = 1;
		int c = 2;
		assertEquals(6, new FoxAndFlowerShopDivTwo().theMaxFlowers(flowers, r, c));
	}
	
	@Test(timeout=2000)
	public void test3() {
		String[] flowers = new String[] {"F",
 ".",
 "F",
 "F",
 "F",
 ".",
 "F",
 "F"};
		int r = 4;
		int c = 0;
		assertEquals(3, new FoxAndFlowerShopDivTwo().theMaxFlowers(flowers, r, c));
	}
	
	@Test(timeout=2000)
	public void test4() {
		String[] flowers = new String[] {".FFF..F...",
 "FFF...FF.F",
 "..F.F.F.FF",
 "FF..F.FFF.",
 "..FFFFF...",
 "F....FF...",
 ".FF.FF..FF",
 "..F.F.FFF.",
 ".FF..F.F.F",
 "F.FFF.FF.F"};
		int r = 4;
		int c = 3;
		assertEquals(32, new FoxAndFlowerShopDivTwo().theMaxFlowers(flowers, r, c));
	}
}
