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
public class Course implements Icourse {
	private String term;
	private String subject;
	private String code;
	private String title;
	private int creditHours;
	private String college;
	private float BillingHours;
	private Set<Isection> sections;
	
	
	
	public Course(String term, String subject, String code, String title, int creditHours, String college, float BillingHours, Set<Isection> sections ){
		
		this.term=term;
		this.subject=subject;
		this.code=code;
		this.title=title;
		this.creditHours=creditHours;
		this.college=college;
		this.BillingHours=BillingHours;
		this.sections=sections;
		
		
	}
	public Course(String term, String subject, String code, String title, int creditHours, String college, float BillingHours){
		
		this.term=term;
		this.subject=subject;
		this.code=code;
		this.title=title;
		this.creditHours=creditHours;
		this.college=college;
		this.BillingHours=BillingHours;
		
	}
	
	public boolean equals(Course other) {
		return (this.term.equals(other.getTerm()) && this.subject.equals(other.getSubject())&& this.code.equals(other.getCode()));
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
	/**
	 * @return the title
	 */
	@Override
	public String getTitle() {
		return title;
	}
	/**
	 * @return the creditHours
	 */
	@Override
	public int getCreditHours() {
		return creditHours;
	}
	
	/**
	 * @return the college
	 */
	@Override
	public String getCollege() {
		return college;
	}

	/**
	 * @return the billingHours
	 */
	@Override
	public float getBillingHours() {
		return BillingHours;
	}
	/**
	 * @return the sections
	 */
	@Override
	public Set<Isection> getSections() {
		return sections;
	}
	/**
	 * @return the term
	 */
	@Override
	public String getTerm() {
		return term;
	}
	public boolean equals(Object o) {
		if (o == this) return true;
        if (!(o instanceof Icourse)) {
            return false;
        }

        Icourse cours = (Course) o;

        return  Objects.equals(term, cours.getTerm()) &&
                Objects.equals(subject, cours.getSubject()) &&
                Objects.equals(code, cours.getCode()) &&
                Objects.equals(creditHours, cours.getCreditHours()) &&
                Objects.equals(college, cours.getCollege()) &&
                Objects.equals(BillingHours, cours.getBillingHours()) &&
                Objects.equals(title, cours.getTitle()) &&
                Objects.equals(sections, cours.getSections());
	}
	
	public int hashCode() {

		return Objects.hash(  term,  subject,  code,  title,  creditHours,  college,  BillingHours);
	}
	
	

}
