package ejopackage.helper;

import ejopackage.model.Course;

public class Coursetimer {
    
	  private int order;
	  private Course course;
	public Coursetimer(int order, Course course) {
	
		this.order = order;
		this.course = course;
	}
	public int getOrder() {
		return order;
	}
	public void setOrder(int order) {
		this.order = order;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}  
    
	

}
