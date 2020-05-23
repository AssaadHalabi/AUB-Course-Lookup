/**
 * 
 */
package UnitTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Cmps252.Analyst;
import Cmps252.Analyst1;
import Cmps252.CourseSchedule;
import Cmps252.FileParser;
import Cmps252.Icourse;
import Cmps252.Instructor;
import Cmps252.Isection;
import Cmps252.Location;
import Cmps252.ParseFile;
import Cmps252.ParseSched;
import Cmps252.ParseSchedule;
import Cmps252.Section;

/**
 * @author student
 *
 */
class Analyst1Test {
	
	public Analyst Esraa;
	
	@BeforeEach
	void init() {
	ParseSchedule parser = new ParseSched();
	Map<String, Icourse> courses = new LinkedHashMap<String, Icourse>();
	try {
		courses = parser.parseAllFiles();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	Esraa = new Analyst1(courses);
	}
	
	/**
	 * Test method for {@link Cmps252.Analyst1#getCoursesTaughtByInstructor(Cmps252.Instructor)}.
	 * @throws IOException 
	 */
	@Test
	void testGetCoursesTaughtByInstructor() throws IOException {
	
		
		Instructor ins = new Instructor("Mahmoud", "Bdeir");
		for (Icourse c : Esraa.getCoursesTaughtByInstructor(ins)) {
			assertTrue(c.getCode().contains("253")  || c.getCode().contains("252") || c.getCode().contains("297R")  || c.getCode().contains("272")  || c.getCode().contains("299") ||  c.getCode().contains("255")   , "Courses not being returned correctly");
			
		}
		
	}
	
	@Test
	void testGetCoursesTaughtByInstructorNull() throws IOException {
	
		
		
	
		assertTrue(Esraa.getCoursesTaughtByInstructor(null) == null, "Instructor is null");
			
		
		
	}
	
	
	
	/**
	 * Test method for {@link Cmps252.Analyst1#getLogistics(java.lang.String)}.
	 */
	@Test
	void testGetLogistics() {
		assertTrue(Esraa.getLogistics("Cmps 255").contains("Section: 2, building1: BIOL, room1: SLH, beginTime1: 13:00, endtime1: 13:50, weekdays: M W") );
	}

	/**
	 * Test method for {@link Cmps252.Analyst1#getCreditHours(java.lang.String)}.
	 */
	@Test
	void testGetCreditHours() {
		assertEquals("Credit hours not correct",3, Esraa.getCreditHours("CMPS255", 'F'));
	}
	@Test
	void testGetCreditHoursEmpty() {
		assertEquals("Credit hours not correct",3, Esraa.getCreditHours("Cmps255",'F'));
	}
	@Test
	void testGetCreditHoursInt() {
		assertEquals("Credit hours not correct",-1, Esraa.getCreditHours("55255",'F'));
	}
	@Test
	void testGetCreditHoursInvalid() {
		assertEquals("Credit hours not correct",-1, Esraa.getCreditHours("55255121212121",'F'));
	}
	@Test
	void testGetCreditHoursUnder() {
		assertEquals("Credit hours not correct",-1, Esraa.getCreditHours("_",'F'));
	}
	@Test
	void testGetCreditHoursWrong() {
		assertEquals("Credit hours not correct",-1, Esraa.getCreditHours("sasaaaasaaaaa",'F'));
	}
	@Test
	void testGetCreditHoursIntTerm() {
		assertEquals("Credit hours not correct",-1, Esraa.getCreditHours("cmps255",'1'));
	}

	/**
	 * Test method for {@link Cmps252.Analyst1#getCrns(java.lang.String)}.
	 */
	@Test
	void testGetCrns() {
		assertTrue(Esraa.getCrns("Cmps255").contains("10946") && Esraa.getCrns("Cmps255").contains("10947"), "Crns not returned" );
	}
	@Test
	void testGetCrnsNameWithSpaces() {
		assertTrue(Esraa.getCrns("Cm ps           2 5 5").contains("10946") && Esraa.getCrns("Cm ps           2 5 5").contains("10947"), "Crns not returned" );
	}
	
	@Test
	void testGetCrnsNameWithBadCaps() {
		assertTrue(Esraa.getCrns("CMPs255").contains("10946") && Esraa.getCrns("CMPs255").contains("10947"), "Crns not returned" );
	}
	
	/**
	 * Test method for {@link Cmps252.Analyst1#getInstructors(java.lang.String)}.
	 */
	@Test
	void testGetInstructors() {
		 
		 for (Instructor instr : Esraa.getInstructors("Cmps255")) {
			 
			assertTrue((instr.getInstructor_FName().contains("Mahmoud")&& instr.getInstructor_Surame().contains("Bdeir")) || (instr.getInstructor_FName().contains("Izzat")&& instr.getInstructor_Surame().contains("Hajj")) ," Instructors aren't correct");
		}
	}
	
	@Test
	void testGetInstructorIntegers() {
		 
		 for (Instructor instr : Esraa.getInstructors("12121212121")) {
			 
			assertEquals(null, instr, "Integer instructor name");
		}
	}
	@Test
	void testGetInstructors2() {
		 
		 for (Instructor instr : Esraa.getInstructors("Cmps253")) {
			 
			assertTrue((instr.getInstructor_FName().contains("Mahmoud")&& instr.getInstructor_Surame().contains("Bdeir")) ," Instructors aren't correct");
		}
	}

	/**
	 * Test method for {@link Cmps252.Analyst1#getBillingHours(java.lang.String)}.
	 */
	@Test
	void testGetBillingHours() {
		assertTrue(3.0 == Esraa.getBillingHours("Cmps255", 'F'), "Billing hours are not correct");
	}
	@Test
	void testGetBillingHoursInt() {
		assertTrue(-1 == Esraa.getBillingHours("Cmps255", '1'), "Billing hours are not correct");
	}
	@Test
	void testGetBillingHoursSpace() {
		assertTrue(3 == Esraa.getBillingHours("Cmps             255", 'F'), "Billing hours are not correct");
	}
	
	/**
	 * Test method for {@link Cmps252.Analyst1#getLogisticsByCrn(java.lang.String)}.
	 */
	@Test
	void testGetLogisticsByCrn() {
		assertTrue(Esraa.getLogisticsByCrn("10947").contains("Section: 2, building1: BIOL, room1: SLH, beginTime1: 13:00, endtime1: 13:50, weekdays: M W") && Esraa.getLogisticsByCrn("10947").contains("2nd schedule: weekdays: F , building: NICELY, room: SLH, beginTime:13:00, endTime: 13:50."));
	}
	@Test
	void testGetLogisticsByCrnAlphabetical() {
		assertTrue(Esraa.getLogisticsByCrn("ABDSCA") == null, "CRN should be a number");
	}
	@Test
	void testGetLogisticsByCrnempty() {
		assertTrue(Esraa.getLogisticsByCrn("") == null, "CRN should not be empty");
	}
	
	@Test
	void testGetLogisticsByCrnUnder() {
		assertTrue(Esraa.getLogisticsByCrn("_")== null);
	}
	@Test
	void testGetLogisticsByCrnNull() {
		assertTrue(Esraa.getLogisticsByCrn(null)== null);
	}
	/**
	 * Test method for {@link Cmps252.Analyst1#getInstructorByCrn(java.lang.String)}.
	 */
	@Test
	void testGetInstructorByCrn() {
		assertEquals("Mahmoud", Esraa.getInstructorByCrn("10947").getInstructor_FName());
		assertEquals("Bdeir", Esraa.getInstructorByCrn("10947").getInstructor_Surame());
	}
	

	/**
	 * Test method for {@link Cmps252.Analyst1#getCourseByCrn(java.lang.String)}.
	 */
	@Test
	void testGetCourseByCrn() {
		assertEquals("CMPS",Esraa.getCourseByCrn("10947").getSubject());
		assertEquals("255", Esraa.getCourseByCrn("10947").getCode());
	}
	
	@Test
	void testGetACourseByCrn() {
		assertEquals("ACCT",Esraa.getCourseByCrn("10008").getSubject());
		assertEquals("210", Esraa.getCourseByCrn("10008").getCode());
	}
	
	
	
	/**
	 * Test method for {@link Cmps252.Analyst1#GetCoursesByLocationString(java.lang.String)}.
	 */
	@Test
	void testGetCoursesByLocationString() {
		for (Icourse icourse : Esraa.GetCoursesByLocationString("nicely 415", 'F')){
			String name = icourse.getSubject()+icourse.getCode();
			assertTrue( name.contains("MATH203") || name.contains("ECON213") || name.contains("MATH201") || name.contains("MATH101") || name.contains("PSPA210") || name.contains("STAT210") || name.contains("MATH204") || name.contains("MATH218"), "Course in Nicely 415 aren't correct");
			}
	}
	@Test
	void testGetCoursesByLocationSpaceString() {
		for (Icourse icourse : Esraa.GetCoursesByLocationString("nicely           415", 'F')){
			String name = icourse.getSubject()+icourse.getCode();
			assertTrue( name.contains("MATH203") || name.contains("ECON213") || name.contains("MATH201") || name.contains("MATH101") || name.contains("PSPA210") || name.contains("STAT210") || name.contains("MATH204") || name.contains("MATH218"), "Course in Nicely 415 aren't correct");
			}
	}
		
		@Test
		void testGetCoursesByLocationCapsString() {
			for (Icourse icourse : Esraa.GetCoursesByLocationString("niCelY 415", 'F')){
				String name = icourse.getSubject()+icourse.getCode();
				assertTrue( name.contains("MATH203") || name.contains("ECON213") || name.contains("MATH201") || name.contains("MATH101") || name.contains("PSPA210") || name.contains("STAT210") || name.contains("MATH204") || name.contains("MATH218"), "Course in Nicely 415 aren't correct");
			}
				}
	@Test
	void testGetCoursesByLocationSpringString() {
		for (Icourse icourse : Esraa.GetCoursesByLocationString("nicely 415", 'S')){
			String name = icourse.getSubject()+icourse.getCode();
			assertTrue(name.contains("MATH101") || name.contains("MATH201") || name.contains("MATH203") || name.contains("PSPA222") || name.contains("MATH211") || name.contains("STAT201") || name.contains("STAT210") || name.contains("MATH102") || name.contains("MATH204") || name.contains("MATH218"), "Course in Nicely 415 aren't correct");
			}
	}
	@Test
	void testGetCoursesByLocationCaps2SpringString() {
		for (Icourse icourse : Esraa.GetCoursesByLocationString("niCEly 415", 'S')){
			String name = icourse.getSubject()+icourse.getCode();
			assertTrue(name.contains("MATH101") || name.contains("MATH201") || name.contains("MATH203") || name.contains("PSPA222") || name.contains("MATH211") || name.contains("STAT201") || name.contains("STAT210") || name.contains("MATH102") || name.contains("MATH204") || name.contains("MATH218"), "Course in Nicely 415 aren't correct");
			}
	}
	
	@Test
	void testGetCoursesByLocationCaps3SpringString() {
		for (Icourse icourse : Esraa.GetCoursesByLocationString("NICEly          415", 'S')){
			String name = icourse.getSubject()+icourse.getCode();
			assertTrue(name.contains("MATH101") || name.contains("MATH201") || name.contains("MATH203") || name.contains("PSPA222") || name.contains("MATH211") || name.contains("STAT201") || name.contains("STAT210") || name.contains("MATH102") || name.contains("MATH204") || name.contains("MATH218"), "Course in Nicely 415 aren't correct");
			}
	}
	/**
	 * Test method for {@link Cmps252.Analyst1#getAvailableSeatsByCourseName(java.lang.String)}.
	 */
	@Test
	void testGetNegativeAvailableSeatsByCourseName() {
		assertEquals(-7, Esraa.getAvailableSeatsByCourseName("cmps255",'F'), "Wrong total number of avail seats");
	}
	@Test
	void testGetZeroAvailableSeatsByCourseName() {
		assertEquals(0, Esraa.getAvailableSeatsByCourseName("cive542",'S'), "Wrong total number of avail seats");
	}
	@Test
	void testGetPositiveAvailableSeatsByCourseName() {
		assertEquals(10, Esraa.getAvailableSeatsByCourseName("cive612",'S'), "Wrong total number of avail seats");
	}

	/**
	 * Test method for {@link Cmps252.Analyst1#getAvailableSeatsByCRN(java.lang.String)}.
	 */
	@Test
	void testGetAvailableSeatsByCRN() {
		assertEquals(0,Esraa.getAvailableSeatsByCRN("10947"),"Wrong number of avail seats");
	}

	/**
	 * Test method for {@link Cmps252.Analyst1#getLocation(java.lang.String)}.
	 */
	@Test
	void testGetL() {
		
		for ( Location loc : Esraa.getLocation("Cmps 252")) {
			assertTrue(loc.getBuilding().getBUILDING().equals("NICELY") && loc.getRoom().getRoom().equals("214"));
		
	}
	}
	@Test
	void testGetLocation() {
			
			for (Location loc : Esraa.getLocation("Cmps 255")) {
				
				assertTrue(loc.getBuilding().getBUILDING().equals("BLISS")  || loc.getBuilding().getBUILDING().equals("BIOL") || loc.getBuilding().getBUILDING().equals("NICELY") );
				
			}
			
		}
		
	}


