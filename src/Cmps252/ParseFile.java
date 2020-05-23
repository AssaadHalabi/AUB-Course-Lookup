/**
 * 
 */
package Cmps252;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * @author student
 *
 */
public class ParseFile implements FileParser {

	@Override
	public Map<String, Icourse> Parse(String fileName) throws IOException {
		Document doc;
		Map<String, Icourse> courses = new LinkedHashMap<String, Icourse>();
		File f = new File(fileName);
		doc = Jsoup.parse(f, "UTF-8");
		Elements TDs = doc.select("td");

		int foundAt = 0;
		for (int j = 0; j < TDs.size(); j++) {
			Element td = TDs.get(j);
			if (td.ownText().contains("C R N")) {
				foundAt = j + 36;
				break;
			}
		}

		String term = TDs.get(foundAt - 1).text(), subject = TDs.get(foundAt + 1).text(),
				code = TDs.get(foundAt + 2).text(), title = TDs.get(foundAt + 4).text(),
				cldg = TDs.get(foundAt + 7).text();
		int creditHours = Integer.parseInt(TDs.get(foundAt + 5).text());
		float billingHrs = Float.parseFloat(TDs.get(foundAt + 6).text());

		Icourse cr = new Course(term, subject, code, title, creditHours, cldg, billingHrs);
		Set<Isection> sects = new HashSet<Isection>();

		while (foundAt <= TDs.size()) {
			term = TDs.get(foundAt - 1).text();
			String crn = TDs.get(foundAt).text();
			subject = TDs.get(foundAt + 1).text();
			code = TDs.get(foundAt + 2).text();
			String section = TDs.get(foundAt + 3).text();
			title = TDs.get(foundAt + 4).text();
			creditHours = Integer.parseInt(TDs.get(foundAt + 5).text());
			billingHrs = Float.parseFloat(TDs.get(foundAt + 6).text());
			cldg = TDs.get(foundAt + 7).text();
			int actEnr = Integer.parseInt(TDs.get(foundAt + 8).text());
			int seatsRem = Integer.parseInt(TDs.get(foundAt + 9).text());
			String begin1 = TDs.get(foundAt + 10).text();
			String end1 = TDs.get(foundAt + 11).text();
			Building bldg1 = new Building1(TDs.get(foundAt + 12).text());
			Room room1 = new Room1(TDs.get(foundAt + 13).text());
			Location location1 = new Location1(bldg1, room1);
			String sched1 = TDs.get(foundAt + 14).text() + TDs.get(foundAt + 15).text() + TDs.get(foundAt + 16).text()
					+ TDs.get(foundAt + 17).text() + TDs.get(foundAt + 18).text() + TDs.get(foundAt + 19).text()
					+ TDs.get(foundAt + 20).text();
			sched1 = HelperMethods.fixSched(sched1);
			String begin2 = TDs.get(foundAt + 21).text();
			String end2 = TDs.get(foundAt + 22).text();
			Building bldg2 = new Building1(TDs.get(foundAt + 23).text());
			Room room2 = new Room1(TDs.get(foundAt + 24).text());
			Location location2 = new Location1(bldg2, room2);
			String sched2 = TDs.get(foundAt + 25).text() + TDs.get(foundAt + 26).text() + TDs.get(foundAt + 27).text()
					+ TDs.get(foundAt + 28).text() + TDs.get(foundAt + 29).text() + TDs.get(foundAt + 30).text()
					+ TDs.get(foundAt + 31).text();
			sched2 = HelperMethods.fixSched(sched2);
			String instFname = TDs.get(foundAt + 32).text();
			String instLname = TDs.get(foundAt + 33).text();
			Instructor ins = new Instructor(instFname, instLname);
			

			if (!(cr.getSubject().equals(subject) && cr.getCode().equals(code)) || !(cr.getSubject().equals(subject) && cr.getCode().equals(code) && cr.getTerm().equals(term))) {
					cr = new Course(cr.getTerm(),cr.getSubject(),cr.getCode(),cr.getTitle(), cr.getCreditHours(),cr.getCollege(),cr.getBillingHours(), sects);
					String courseName = cr.getSubject() + cr.getCode() +cr.getTerm().charAt(0);
					courses.put(courseName, cr);
					cr = new Course(term, subject, code, title, creditHours, cldg, billingHrs);
					Isection sc = new Section(ins, crn, section, location1, location2, begin1, begin2, end1, end2, sched1,
							sched2, actEnr, seatsRem,subject,code,cr);
					sects = new HashSet<Isection>();
					sects.add(sc);
				
				

			} else {
					Isection sc = new Section(ins, crn, section, location1, location2, begin1, begin2, end1, end2, sched1,
						sched2, actEnr, seatsRem,subject,code,cr);
					sects.add(sc);
				
				
			}

			// System.out.println(TDs.get(foundAt).text());
			// System.out.println(TDs.get(foundAt+34).text());
			foundAt += 36;

			if (foundAt >= TDs.size() && (cr.getSubject().equals(subject) && cr.getCode().equals(code))) {
				cr = new Course(cr.getTerm(),cr.getSubject(),cr.getCode(),cr.getTitle(), cr.getCreditHours(),cr.getCollege(),cr.getBillingHours(), sects);
				Isection sc = new Section(ins, crn, section, location1, location2, begin1, begin2, end1, end2, sched1,
						sched2, actEnr, seatsRem,subject,code,cr);
				sects.add((Isection) sc);
				String courseName = cr.getSubject() + cr.getCode()+cr.getTerm().charAt(0);
				courses.put(courseName, cr);
			} 

		}

		return courses;
	}

}
