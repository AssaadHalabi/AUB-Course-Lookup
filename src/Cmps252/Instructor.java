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
public class Instructor {
	private String instructor_FName;
	private String instructor_Surame;
	
	
	public Instructor(String first, String second) {
		if (first != null && second != null) {
		
		this.instructor_FName = first;
		this.instructor_Surame = second;
		}
	}
	
	public String getInstructor_FName() {
		return this.instructor_FName;
	}
	public String getInstructor_Surame() {
		return this.instructor_Surame;
	}

	
	public boolean equals(Object o) {
		if (o == this) return true;
        if (!(o instanceof Instructor)) {
            return false;
        }
        
        Instructor instr = (Instructor) o;

        return  Objects.equals(instructor_FName.toLowerCase(), instr.getInstructor_FName().toLowerCase()) &&
                Objects.equals(instructor_Surame.toLowerCase(), instr.getInstructor_Surame().toLowerCase());
	}
	
	public int hashCode() {

		return Objects.hash(instructor_FName,instructor_Surame);
	}
}
