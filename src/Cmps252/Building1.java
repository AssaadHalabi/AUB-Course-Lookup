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
public class Building1 implements Building {
	private String building;
	
	public Building1(String building) {
		this.building = building;
		
	}
	
	@Override
	public String getBUILDING() {
		// TODO Auto-generated method stub
		return building;
	}
	
	public String toString() {
		return this.getBUILDING();
	}
	
	@Override
	public boolean equals(Object o) {
		if (o == this) return true;
        if (!(o instanceof Building)) {
            return false;
        }

        Building build = (Building) o;

        return  Objects.equals(building, build.getBUILDING());
	}
	
	@Override
	public int hashCode() {

		return Objects.hash(building);
	}
	
	
}
