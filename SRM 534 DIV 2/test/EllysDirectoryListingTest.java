import org.junit.Test;
import static org.junit.Assert.*;

public class EllysDirectoryListingTest {
	
	@Test(timeout=2000)
	public void test0() {
		String[] files = new String[] {"ContestApplet.jnlp", ".", "Image.jpg", "..", "Book.pdf", "Movie.avi"};
		assertArrayEquals(new String[] {"ContestApplet.jnlp", "Movie.avi", "Image.jpg", "Book.pdf", "..", "." }, new EllysDirectoryListing().getFiles(files));
	}
	
	@Test(timeout=2000)
	public void test1() {
		String[] files = new String[] {"Image.jpg", "..", "."};
		assertArrayEquals(new String[] {"Image.jpg", "..", "." }, new EllysDirectoryListing().getFiles(files));
	}
	
	@Test(timeout=2000)
	public void test2() {
		String[] files = new String[] {"..", ".", "Image.jpg"};
		assertArrayEquals(new String[] {"Image.jpg", ".", ".." }, new EllysDirectoryListing().getFiles(files));
	}
	
	@Test(timeout=2000)
	public void test3() {
		String[] files = new String[] {"No", "..", "Zaphod", ".", "Just", "very", "very...", "Improbable"};
		assertArrayEquals(new String[] {"No", "Improbable", "Zaphod", "very...", "Just", "very", ".", ".." }, new EllysDirectoryListing().getFiles(files));
	}
	
	@Test(timeout=2000)
	public void test4() {
		String[] files = new String[] {"www.topcoder.com", "Ever.tried", ".", "Ever.failed", "..", "No", "Matter.", "Try", "Again.", "Fail", "Again..", "Fail.Better"};
		assertArrayEquals(new String[] {"www.topcoder.com", "Ever.tried", "Fail.Better", "Ever.failed", "Again..", "No", "Matter.", "Try", "Again.", "Fail", "..", "." }, new EllysDirectoryListing().getFiles(files));
	}
	
	@Test(timeout=2000)
	public void test5() {
		String[] files = new String[] {"This", ".", "is", "tricky", "test", ".."};
		assertArrayEquals(new String[] {"This", "test", "is", "tricky", "..", "." }, new EllysDirectoryListing().getFiles(files));
	}
}
