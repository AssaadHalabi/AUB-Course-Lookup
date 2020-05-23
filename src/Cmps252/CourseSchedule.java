package Cmps252;

import static org.junit.Assert.assertTrue;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * 
 */

/**
 * @author student
 *
 */

public class CourseSchedule {

	 
	public static void main(String[] args) throws IOException {
		
				ParseSchedule parser = new ParseSched();
				Map<String, Icourse> courses = new LinkedHashMap<String, Icourse>();
				courses = parser.parseAllFiles();
				System.out.println("Please input the name(first line) and term(second line , f for Fall and s for Spring) of the course you want to search: ");
				System.out.println("Note: -1 credit course it means that this course is being given in the next term. ");
				Scanner scn = new Scanner(System.in);
				String cours = scn.nextLine();
				String term1 = scn.next();
				char term = term1.charAt(0);
				
				scn.close();
				cours = cours.toUpperCase();
				

				Analyst Esraa = new Analyst1(courses);

				System.out.printf("%s is a " + Esraa.getCreditHours(cours,term) + " credit course\n", cours);
				System.out.printf("%s CRNS:\n" + Esraa.getCrns(cours) + "\n", cours);
				
				System.out.println("\nInstructors:\n");
				for (Instructor instrs : Esraa.getInstructors(cours)) {
					System.out.printf("Professor %s %s gives %s.\n", instrs.getInstructor_FName(),
							instrs.getInstructor_Surame(), cours);
				}
				System.out.println(" \nLogistics: \n");
				System.out.println(Esraa.getLogisticsByCrn("10947")); 
				System.out.println(cours+ " has "+Esraa.getAvailableSeatsByCourseName(cours,term)+ " available seats.");
				
//				System.out.println("\n\npredefined tests for cmps 253 and 200: ");
//				Instructor ins = new Instructor("Mahmoud", "Bdeir");
//				System.out.println("The courses taught by prof Bdeir are: ");
//				for (Icourse icourse : Esraa.getCoursesTaughtByInstructor(ins)) {
//					System.out.printf("%s %s.\n", icourse.getSubject(), icourse.getCode());
//				}
//				
//				System.out.println("Cmps 253 is a " + Esraa.getCreditHours("CmPs    253")
//						+ " credit course(but it is actually a 9 credit course).");
//				System.out.println("Cmps 253 CRNS:\n" + Esraa.getCrns("Cmps 253"));
//				System.out.printf("Professor : %s %s teaches the course with CRN 20900.\n",
//						Esraa.getInstructorByCrn("20900").getInstructor_FName(),
//						Esraa.getInstructorByCrn("20900").getInstructor_Surame());
//				System.out.println("Cmps 200 is given by:");
//				for (Instructor instrs : Esraa.getInstructors("Cmps 200")) {
//					System.out.println(instrs.getInstructor_FName() + " " + instrs.getInstructor_Surame() );
//				}
//				System.out.println(Esraa.getLogistics("Cmps 253"));
//				System.out.println(Esraa.getLogisticsByCrn("20901")  );
//				System.out.println("AvailableSeatsByCourseName "+Esraa.getAvailableSeatsByCourseName("cmps 253"));
//				System.out.println("AvailableSeatsByCRN "+Esraa.getAvailableSeatsByCRN("20900"));
//				for (Location loc : Esraa.getLocation("Acct 210")) {
//					System.out.println(loc.getBuilding().getBUILDING() + " " + loc.getRoom().getRoom() );
//				}
//				
				
//				for (Icourse icourse : Esraa.GetCoursesByLocationString("nicely 415", 'F')){
//				System.out.println(icourse.getSubject()+icourse.getCode());
//				}
//				
//					
//					System.out.println(Esraa.getAvailableSeatsByCourseName("cive541",'F'));
//					System.out.println(Esraa.getBillingHours("CHEM 399"));
//					System.out.println(Esraa.getAvailableSeatsByCourseName("cive612", 'S'));
//				
//
//			}
				System.out.print(Esraa.getCreditHours("Cmps 255", 'F'));

			
	}
}


