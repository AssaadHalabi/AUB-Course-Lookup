/**
 * 
 */
package UnitTests;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import Cmps252.Course;
import Cmps252.Icourse;
/**
 * @author student
 *
 */
class CourseTest {
	
		Icourse cours = new Course("Fall2019-2020(202010)","ACCT","210","FinancialAccounting",3,"SB",3);
		
	/**
	 * Test method for {@link Cmps252.Course#Course(java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, java.lang.String, float, java.util.Set)}.
	 */
	@Test
	void testCourseStringStringStringStringIntStringFloatSetOfIsection() {
		
	}

	/**
	 * Test method for {@link Cmps252.Course#Course(java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, java.lang.String, float)}.
	 */
	@Test
	void testCourseStringStringStringStringIntStringFloat() {
		Icourse course = new Course("Fall2019-2020(202010)","ACCT","210","FinancialAccounting",3,"SB",3);
		assertTrue("Course isn't being created successfully", cours.equals(course));
	}

	/**
	 * Test method for {@link Cmps252.Course#getCreditHours()}.
	 */
	@Test
	void testGetCreditHours() {
		assertEquals( 3, cours.getCreditHours(),"Credit hours are wrong");
	}

}
