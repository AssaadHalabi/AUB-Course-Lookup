/**
 * 
 */
package Cmps252;

/**
 * @author student
 *
 */
public interface Isection {

	public String getCrn();
	
	public int getActualEnrollment();

	
	public Instructor getInstructor();

	
	public String getSection() ;
	
			
	public String getBeginTime1() ;

	/**
	 * @return the beginTime2
	 */
		
	public String getBeginTime2();
	
	/**
	 * @return the endTime1
	 */
		
	public String getEndTime1();


	/**
	 * @return the endTime2
	 */
		
	public String getEndTime2() ;
	

	/**
	 * @return the building_1
	 */
		
	public Building getBuilding_1() ;


	/**
	 * @return the building_2
	 */
		
	public Building getBuilding_2() ;

	
	/**
	 * @return the room_1
	 */
		
	public Room getRoom_1() ;

	/**
	 * @return the room_2
	 */
		
	public Room getRoom_2();


	/**
	 * @return the schedule_1
	 */
		
	public String getSchedule_1() ;
	

	/**
	 * @return the schedule_2
	 */
		
	public String getSchedule_2() ;

	/**
	 * @return the seatsAvail
	 */
		
	public int getSeatsAvail() ;

	/**
	 * @return
	 */
	Location getLocation1();

	/**
	 * @return
	 */
	Location getLocation2();
	boolean equals(Object o);
	int hashCode();

	/**
	 * @return
	 */
	String getSubject();

	/**
	 * @return
	 */
	String getCode();

	/**
	 * @return
	 */
	Course getCourse();



	
	
}
