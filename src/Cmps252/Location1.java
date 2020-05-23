/**
 * 
 */
package Cmps252;

import java.util.Objects;

/**
 * @author student
 *
 */
public class Location1 implements Location{
	private Building building;
	private Room room;
	
	/**
	 * 
	 */
	public Location1(Building building,Room room) {
		// TODO Auto-generated constructor stub
		this.room = room;
		this.building = building;
	}
	/**
	 * @param string
	 * @param string2
	 */
	public Location1(String build, String room) {
		// TODO Auto-generated constructor stub
		Building b = new Building1(build);
		Room r = new Room1(room);
		this.building = b;
		this.room = r;
	}
	@Override
	public Building getBuilding() {
		// TODO Auto-generated method stub
		return this.building;
	}

	@Override
	public Room getRoom() {
		// TODO Auto-generated method stub
		return this.room;
	}
	@Override
	public boolean equals(Object o) {
		if (o == this) return true;
        if (!(o instanceof Location)) {
            return false;
        }

        Location Location = (Location) o;

        return  Objects.equals(building, Location.getBuilding()) &&
                Objects.equals(room, Location.getRoom());
	}
	@Override
	public int hashCode() {

		return Objects.hash(building, room);
	}
	
}
