/**
 * 
 */
package Cmps252;

import java.util.Objects;

/**
 * @author student
 *
 */
public class Room1 implements Room{
	private String room;
	
	public Room1(String room) {
		this.room = room;
	}
	
	
	@Override
	public String getRoom() {
		// TODO Auto-generated method stub
		return room;
	}
	public String toString() {
		return this.getRoom();
	}
	@Override
	public boolean equals(Object o) {
		if (o == this) return true;
        if (!(o instanceof Room)) {
            return false;
        }

        Room rom = (Room) o;

        return  Objects.equals(room, rom.getRoom());
	}
	
	@Override
	public int hashCode() {

		return Objects.hash(room);
	}
}
