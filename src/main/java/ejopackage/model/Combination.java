package ejopackage.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Combination {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)	
	private int id;
    private String name;
    @ManyToOne
    private School school;
    @ManyToOne Combinationprototype combinationprototype;
   
	public Combination(int id, String name, School school) {

		this.id = id;
		this.name = name;
		this.school = school;
	}
	public Combination() {

	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public School getSchool() {
		return school;
	}
	public void setSchool(School school) {
		this.school = school;
	}
	public Combinationprototype getCombinationprototype() {
		return combinationprototype;
	}
	public void setCombinationprototype(Combinationprototype combinationprototype) {
		this.combinationprototype = combinationprototype;
	}
	
	
    
    
}
