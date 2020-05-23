/**
 * 
 */
package Cmps252;

import java.util.Map.Entry;


import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author student
 *
 */
public class Analyst1 implements Analyst {


	private Map<String, Icourse> _lookupCourses;
	
	public Analyst1(Map<String, Icourse> lookup) {
		// TODO Auto-generated constructor stub
		if (lookup != null) {
		this._lookupCourses = lookup;
		}
		
	}


	@Override
	public Set<Icourse> getCoursesTaughtByInstructor(Instructor instructor) {
		// TODO Auto-generated method stub
		if(instructor == null) {
			return null;
		}
		
		Set<Icourse> courses = new HashSet<Icourse>();
		for (Entry<String, Icourse> course : _lookupCourses.entrySet()) {
			if(course.getValue().getSections() == null) continue;
			
			for (Isection section : course.getValue().getSections()) {
				boolean check = section.getInstructor()
						.equals(instructor);
				
				if (check) {
					courses.add(course.getValue());
				}
			}
		}
		return courses;
	}
	
	

	@Override
	public String getLogistics(String courseName) {
		// TODO Auto-generated method stub
		courseName = courseName.toUpperCase();
		if (courseName.contains(" ")) {
			courseName = courseName.replaceAll("\\s+", "");
		}

		String loc = "";
		for (Entry<String, Icourse> course : _lookupCourses.entrySet()) {
			if (course.getKey().contains(courseName)) {
				for (Isection section : course.getValue().getSections()) {
					String begin1 = section.getBeginTime1(), begin2 = section.getBeginTime2(),
							end1 = section.getEndTime1(), end2 = section.getEndTime2();
					begin1 = HelperMethods.addChar(begin1, ':');
					begin2 = HelperMethods.addChar(begin2, ':');
					end1 = HelperMethods.addChar(end1, ':');
					end2 = HelperMethods.addChar(end2, ':');
					if (section.getSchedule_2().isBlank()) {
						loc += String.format(
								"Section: %s is given in building: %s, in room: %s from %s till %s following an %s schedule.\n",
								section.getSection(), section.getBuilding_1(), section.getRoom_1(), begin1, end1,
								section.getSchedule_1());
					} else {
						loc += String.format(
								"Section: %s, building1: %s, room1: %s, beginTime1: %s, endtime1: %s, weekdays: %s \n 2nd schedule: weekdays: %s, building: %s, room: %s, beginTime:%s, endTime: %s. \n",
								section.getSection(), section.getBuilding_1(), section.getRoom_1(), begin1, end1,
								section.getSchedule_1(), section.getSchedule_2(), section.getBuilding_2(),
								section.getRoom_2(), begin2, end2);
					}
				}
			}

		}
		return loc;
	}

	@Override
	public int getCreditHours(String courseName, char term) {
		// TODO Auto-generated method stub
		if(courseName == null || courseName.isBlank() || Character.isDigit(term)) {return -1;}
		

			courseName = (courseName + term).toUpperCase();
			if (courseName.contains(" ")) {
				courseName = courseName.replaceAll("\\s+", "");
			}
			for (Entry<String, Icourse> course : _lookupCourses.entrySet()) {
				if (course.getKey().contains(courseName)) {
					return course.getValue().getCreditHours();
				}
			}
		
		
		return -1;
	}

	@Override
	public String getCrns(String courseName) {
		// TODO Auto-generated method stub
		String crns = "";
		courseName = courseName.toUpperCase();
		if (courseName.contains(" ")) {
			courseName = courseName.replaceAll("\\s+", "");
		}
		for (Entry<String, Icourse> course : _lookupCourses.entrySet()) {
			if (course.getKey().contains(courseName)) {
				for (Isection section : course.getValue().getSections()) {
					crns += String.format("Section: %1s has a CRN: %s \n", section.getSection(), section.getCrn());

				}
			}
		}

		return crns;
	}

	@Override
	public Set<Instructor> getInstructors(String courseName) {
		// TODO Auto-generated method stub
		if(courseName == null || courseName.isEmpty()) {
			return null;
		}
		try {
			
			Integer.parseInt(courseName);
			
		} catch (Exception e) {
			
		
		courseName = courseName.toUpperCase();
		if (courseName.contains(" ")) {
			courseName = courseName.replaceAll("\\s+", "");
		}

		Set<Instructor> instrs = new HashSet<Instructor>();
		for (Entry<String, Icourse> course : _lookupCourses.entrySet()) {
			if (course.getKey().contains(courseName)) {
				for (Isection section : course.getValue().getSections()) {

					if (section.getInstructor().getInstructor_FName().equals(".")
							&& section.getInstructor().getInstructor_Surame().equals("STAFF")) {
						Instructor added = new Instructor("Staff", "");
						instrs.add(added);
					} else {
						instrs.add(section.getInstructor());
					}
					if (section.getActualEnrollment() == 0) {
						break;
					}
				}
			}
		}
		return instrs;
		}
		return null;
	}

	@Override
	public float getBillingHours(String courseName, char term) {
		// TODO Auto-generated method stub
		if(courseName == null || courseName.isBlank() || Character.isDigit(term)) {return -1;}
	
			
		
		courseName = (courseName+term).toUpperCase();
		if (courseName.contains(" ")) {
			courseName = courseName.replaceAll("\\s+", "");
		}
		for (Entry<String, Icourse> course : _lookupCourses.entrySet()) {
			if (course.getKey().contains(courseName)) {
				return course.getValue().getBillingHours();
			}
		}
		
		return -1;

	}

	@Override
	public String getLogisticsByCrn(String crn) {
		// TODO Auto-generated method stub
		if(crn == "" && crn == null) {
			return null;
		}
		try {
			Integer.parseInt(crn);
		} catch (Exception e) {
			return null;
		}
		String loc = "";
		for (Entry<String, Icourse> course : _lookupCourses.entrySet()) {

			for (Isection section : course.getValue().getSections()) {
				if (section.getCrn().equals(crn)) {
					String begin1 = section.getBeginTime1(), begin2 = section.getBeginTime2(),
							end1 = section.getEndTime1(), end2 = section.getEndTime2();
					begin1 = HelperMethods.addChar(begin1, ':');
					begin2 = HelperMethods.addChar(begin2, ':');
					end1 = HelperMethods.addChar(end1, ':');
					end2 = HelperMethods.addChar(end2, ':');
					if(!(section.getSchedule_1().isBlank())){
					if (section.getSchedule_2().isBlank()) {
						loc += String.format(
								"Section: %s is given in building: %s, in room: %s from %s till %s following an %s schedule.\n",
								section.getSection(), section.getBuilding_1(), section.getRoom_1(), begin1, end1,
								section.getSchedule_1());
					} else {
						loc += String.format(
								"Section: %s, building1: %s, room1: %s, beginTime1: %s, endtime1: %s, weekdays: %s \n 2nd schedule: weekdays: %s, building: %s, room: %s, beginTime:%s, endTime: %s. \n",
								section.getSection(), section.getBuilding_1(), section.getRoom_1(), begin1, end1,
								section.getSchedule_1(), section.getSchedule_2(), section.getBuilding_2(),
								section.getRoom_2(), begin2, end2);
					}
					}
				}

			}
		}
		return loc;
	}

	public Instructor getInstructorByCrn(String crn) {

		for (Entry<String, Icourse> course : _lookupCourses.entrySet()) {

			for (Isection section : course.getValue().getSections()) {
				if (section.getCrn().equals(crn)) {
					return section.getInstructor();

				}
			}
		}
		return null;

	}

	@Override
	public Icourse getCourseByCrn(String crn) {
		// TODO Auto-generated method stub
		if (crn.length() != 5 || crn.isEmpty()) {
			return null;
		}
		try {
			Integer.parseInt(crn);
		} catch (Exception e) {
			return null;
		}
		for (Icourse course : _lookupCourses.values()) {
			for (Isection section : course.getSections()) {
				if (section.getCrn().equals(crn)) {
					return section.getCourse();
				}
			}
		}
		return null;
	}

	@Override
	// Assumes location is building + room or building
	public Set<Icourse> GetCoursesByLocationString(String location, char term) {
		// TODO Auto-generated method stub
		
		location = location.toUpperCase();
		if (location.contains(" ")) {
			location = location.replaceAll("\\s+", "");
		}
		Set<Icourse> courses = new HashSet<>();
		if (HelperMethods.containsRoom(location)) {
			String build = HelperMethods.extractBuilding(location);
			String room = HelperMethods.extractRoom(location);
			for (Icourse course : _lookupCourses.values()) {
				if(course.getTerm().charAt(0) != term ) {
					continue;
				}
				for (Isection section : course.getSections()) {
					if (section.getBuilding_1().getBUILDING().equals(build)
							|| section.getBuilding_2().getBUILDING().equals(build)) {
						if (section.getRoom_1().getRoom().equals(room) || section.getRoom_2().getRoom().equals(room)) {
							courses.add(course);
						}

					}
				}
			}
		}

		else {
			for (Icourse course : _lookupCourses.values()) {
				for (Isection section : course.getSections()) {
					if (section.getBuilding_1().getBUILDING().equals(location)
							|| section.getBuilding_2().getBUILDING().equals(location)) {

						courses.add(course);
					}
				}
			}
		}

		return courses;
	}

	@Override
	public Set<Icourse> GetCoursesByLocation(Location location, char term) {
		// TODO Auto-generated method stub
		Set<Icourse> courses = new HashSet<>();
		for (Entry<String, Icourse> course : _lookupCourses.entrySet()) {
			if (course.getValue().getTerm().charAt(0) != term) {
				continue;
			}
			for (Isection section : course.getValue().getSections()) {
				if (section.getLocation1().equals(location) || section.getLocation2().equals(location)) {
					courses.add(course.getValue());
				}
			}
		}

		return courses;
	}

	@Override
	public int getAvailableSeatsByCourseName(String courseName,char term) {
		// TODO Auto-generated method stub
		int totalAvail = 0;
		courseName = (courseName + term).toUpperCase();
		if (courseName.contains(" ")) {
			courseName = courseName.replaceAll("\\s+", "");
		}
		for (Entry<String, Icourse> course : _lookupCourses.entrySet()) {
			
			if (course.getKey().contains(courseName)) {
				for (Isection section : course.getValue().getSections()) {
					totalAvail+=section.getSeatsAvail();
				}
			}
			
		}
		return totalAvail;
	}
	

	@Override
	public int getAvailableSeatsByCRN(String crn) {
		// TODO Auto-generated method stub
		for (Entry<String, Icourse> course : _lookupCourses.entrySet()) {

			for (Isection section : course.getValue().getSections()) {
				if (section.getCrn().equals(crn)) {
					
				return section.getSeatsAvail();
					}
				}
		
	}
		return 0;
}


	@Override
	public Set<Location> getLocation(String courseName) {
		// TODO Auto-generated method stub
		Set<Location> locs = new HashSet<Location>();
		courseName = courseName.toUpperCase();
		if (courseName.contains(" ")) {
			courseName = courseName.replaceAll("\\s+", "");
		}
		for (Entry<String, Icourse> course : _lookupCourses.entrySet()) {
			
			if (course.getKey().contains(courseName)) {
				for (Isection section : course.getValue().getSections()) {
					
					if (!(section.getLocation1().getBuilding().getBUILDING().equals(".") && section.getLocation1().getRoom().getRoom().equals("." ))) {
						locs.add(section.getLocation1());
					}
					
					if (!(section.getLocation2().getBuilding().getBUILDING().equals(".") && section.getLocation2().getRoom().getRoom().equals("." ) )) {
						locs.add(section.getLocation2());
					}
				}
				}
		}
		
		
		return locs;
	}
}
