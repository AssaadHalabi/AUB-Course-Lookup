/**
 * 
 */
package Cmps252;

import java.util.Map;
import java.util.Set;

/**
 * @author student
 *
 */
public interface Analyst {
	
	public Set<Icourse> getCoursesTaughtByInstructor(Instructor instructor);
	public Icourse getCourseByCrn(String crn);
	public int getCreditHours(String courseName, char term);
	public String getCrns(String courseName);
	public Set<Instructor> getInstructors(String courseName);
	public Instructor getInstructorByCrn(String crn);
	public float getBillingHours(String courseName, char term);
	public Set<Icourse> GetCoursesByLocationString(String location,char term);
	public Set<Icourse>GetCoursesByLocation(Location location, char term);
	int getAvailableSeatsByCourseName(String courseName,char term);
	int getAvailableSeatsByCRN(String crn);
	String getLogistics(String courseName);
	String getLogisticsByCrn(String crn);
	Set<Location> getLocation(String courseName);
	
	
	
	
	

}
