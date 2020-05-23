/**
 * 
 */
package Cmps252;

import java.util.Set;

/**
 * @author student
 *
 */
public interface Icourse {
	
	
	String getSubject();


	/**
	 * @return
	 */
	String getCode();


	/**
	 * @return
	 */
	String getTitle();


	/**
	 * @return
	 */
	int getCreditHours();


	/**
	 * @return
	 */
	String getCollege();


	/**
	 * @return
	 */
	float getBillingHours();


	/**
	 * @return
	 */
	Set<Isection> getSections();


	/**
	 * @return
	 */
	String getTerm();
	boolean equals(Object o);
	int hashCode();

	

}
