/**
 * 
 */
package Cmps252;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author student
 *
 */
public class ParseSched implements ParseSchedule {

	@Override
	// Assumes that the pages are still placed in the location where they were
	// downloaded to
	public Map<String, Icourse> parseAllFiles() throws IOException {
		// TODO Auto-generated method stub
		Map<String, Icourse> lookupCourses = new LinkedHashMap<String, Icourse>();
//		PageDownloader download = new DownloadPage();
		String fileName;
//		String url;
		FileParser parser = new ParseFile();
		for (int i = 65; i < 86; i++) {
			if (i == 74 || i == 75 || i == 81)
				continue;
			fileName = String.format("Downloaded%c.html", (char) i);
			lookupCourses.putAll(parser.Parse(fileName));
		}

//		for (int i = 65; i < 86; i++) {
//			if (i == 74 || i == 75 || i == 81)
//				continue;
//			fileName = String.format("Downloaded%c.html", (char) i);
//			url = String.format("https://www-banner.aub.edu.lb/catalog/schd_%s.htm", (char) i);
//			download.DownloadWebPage(url, fileName);
//		}

		
		return lookupCourses;

	}
}
