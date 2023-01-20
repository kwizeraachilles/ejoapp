package ejopackage.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Schoolcalender {
 
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)	
	private int id;
	private int startYear;
	private int  endYear;
	private int currentsemester;

	
	public Schoolcalender() {
	 this.startYear=LocalDate.now().getYear();
	 this.endYear=LocalDate.now().getYear()+1;
	  this.currentsemester=1;
	}

	public Schoolcalender(int startYear, int endYear, int currentsemester) {
		
		this.startYear = startYear;
		this.endYear = endYear;
		this.currentsemester = currentsemester;
	
	}

	public int getStartYear() {
		return startYear;
	}

	public void setStartYear(int startYear) {
		this.startYear = startYear;
	}

	public int getEndYear() {
		return endYear;
	}

	public void setEndYear(int endYear) {
		this.endYear = endYear;
	}

	public int getCurrentsemester() {
		return currentsemester;
	}

	public void setCurrentsemester(int currentsemester) {
		this.currentsemester = currentsemester;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
 
}