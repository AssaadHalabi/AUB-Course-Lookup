/**
 * 
 */
package UnitTests;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Cmps252.DownloadPage;

/**
 * @author student
 *
 */
class DownloadPageTest {

	
	DownloadPage p = new DownloadPage();
	/**
	 * Test method for {@link Cmps252.DownloadPage#DownloadWebPage(java.lang.String, java.lang.String)}.
	 */
	@Test
	void testDownloadWebPage() {
		
			assertEquals(true, p.DownloadWebPage("https://www-banner.aub.edu.lb/catalog/schd_C.htm", "DownloadTesting"));
		 
	}


}
