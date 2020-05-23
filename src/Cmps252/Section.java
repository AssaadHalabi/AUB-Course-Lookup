/**
 * 
 */
package Cmps252;

import java.util.Objects;
import java.util.Set;

/**
 * @author student
 *
 */
public class Section implements Isection  {
	private String subject;
	private String code;
	private Instructor instructor;
	private String crn;
	private String section;
	private Location location1;
	private Location location2;
	private String beginTime1;
	private String beginTime2;
	private String endTime1;
	private String endTime2;
	private String schedule_1;
	private String schedule_2;
	private int actualEnrollment;
	private int seatsAvail;
	private Course course;
	

	public Section( Instructor instructor, String crn, String section, Location location1, Location location2, String beginTime1, String beginTime2, String endTime1, String endTime2, String schedule_1, String schedule_2, int actualEnrollment, int seatsAvail,String subject,String code, Icourse course) {
				
				this.instructor= instructor;
				this.crn= crn;
				this.section= section;
				this.location1= location1;
				this.location2= location2;
				this.beginTime1= beginTime1;
				this.beginTime2= beginTime2;
				this.endTime1= endTime1;
				this.endTime2= endTime2;
				this.schedule_1= schedule_1;
				this.schedule_2= schedule_2;
				this.actualEnrollment= actualEnrollment;
				this.seatsAvail= seatsAvail;
				this.subject = subject;
				this.code = code;
				this.course = (Course) course;

			
	}
	@Override
	public String getCrn() {
		// TODO Auto-generated method stub
		return this.crn;
	}

	

	@Override
	public int getActualEnrollment() {
		// TODO Auto-generated method stub
		return this.actualEnrollment;
	}

	@Override
	public Instructor getInstructor() {
		// TODO Auto-generated method stub
		return this.instructor;
	}


	/**
	 * @return the beginTime1
	 */
	@Override
	public String getBeginTime1() {
		return beginTime1;
	}


	/**
	 * @return the beginTime2
	 */
	@Override
	public String getBeginTime2() {
		return beginTime2;
	}

	/**
	 * @return the endTime1
	 */
	@Override
	public String getEndTime1() {
		return endTime1;
	}

	/**
	 * @return the endTime2
	 */
	@Override
	public String getEndTime2() {
		return endTime2;
	}

	/**
	 * @return the building_1
	 */
	@Override
	public Building getBuilding_1() {
		return location1.getBuilding();
	}

	/**
	 * @return the building_2
	 */
	@Override
	public Building getBuilding_2() {
		return location2.getBuilding();
	}


	/**
	 * @return the room_1
	 */
	@Override
	public Room getRoom_1() {
		return location1.getRoom();
	}


	/**
	 * @return the room_2
	 */
	@Override
	public Room getRoom_2() {
		return location1.getRoom();
	}


	/**
	 * @return the schedule_1
	 */
	@Override
	public String getSchedule_1() {
		return schedule_1;
	}


	/**
	 * @return the schedule_2
	 */
	@Override
	public String getSchedule_2() {
		return schedule_2;
	}



	/**
	 * @return the seatsAvail
	 */
	@Override
	public int getSeatsAvail() {
		return seatsAvail;
	}

	

	/**
	 * @return the location1
	 */
	@Override
	public Location getLocation1() {
		return location1;
	}

	

	/**
	 * @return the location2
	 */
	@Override
	public Location getLocation2() {
		return location2;
	}
	/**
	 * @return the section
	 */
	@Override
	public String getSection() {
		return section;
	}
	public boolean equals(Object o) {
		if (o == this) return true;
        if (!(o instanceof Isection)) {
            return false;
        }

        Isection cours = (Section) o;

        return  Objects.equals(crn, cours.getCrn()) &&
                Objects.equals(section, cours.getSection()) &&
                Objects.equals(location1, cours.getLocation1()) &&
                Objects.equals(location2, cours.getLocation2()) &&
                Objects.equals(beginTime1, cours.getBeginTime1()) &&
                Objects.equals(beginTime2, cours.getBeginTime2()) &&
                Objects.equals(endTime1, cours.getEndTime1()) &&
                Objects.equals(endTime2, cours.getEndTime2()) &&
                Objects.equals(schedule_1, cours.getSchedule_1()) &&
                Objects.equals(schedule_2, cours.getSchedule_2()) &&
                Objects.equals(actualEnrollment, cours.getActualEnrollment()) &&
                Objects.equals(seatsAvail, cours.getSeatsAvail()) &&
                Objects.equals(instructor, cours.getInstructor());
	}
	
	public int hashCode() {

		return Objects.hash(instructor,crn,section,location1,location2,beginTime1,beginTime2,endTime1,endTime2,schedule_1,schedule_2,actualEnrollment,seatsAvail);

	

	}
	
	/**
	 * @return the course
	 */
	@Override
	public Course getCourse() {
		return course;
	}
	/**
	 * @return the subject
	 */
	@Override
	public String getSubject() {
		return subject;
	}
	/**
	 * @return the code
	 */
	@Override
	public String getCode() {
		return code;
	}
}
