package ejopackage.helper;

import java.util.List;

public class CombinationDTO {

	private String name;
	private String description;
	private List<CourseDTO>  levelOne;
	private List<CourseDTO>  levelTwo;
	private List<CourseDTO>  levelThree;
	private List<CourseDTO>  levelFour;
	private List<CourseDTO>  levelFive;
	private List<CourseDTO>  levelSix;
	public CombinationDTO() {
	
	}
	
	public CombinationDTO(String name, String description, List<CourseDTO> levelOne, List<CourseDTO> levelTwo,
			List<CourseDTO> levelThree, List<CourseDTO> levelFour, List<CourseDTO> levelFive,
			List<CourseDTO> levelSix) {
	
		this.name = name;
		this.description = description;
		this.levelOne = levelOne;
		this.levelTwo = levelTwo;
		this.levelThree = levelThree;
		this.levelFour = levelFour;
		this.levelFive = levelFive;
		this.levelSix = levelSix;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<CourseDTO> getLevelOne() {
		return levelOne;
	}
	public void setLevelOne(List<CourseDTO> levelOne) {
		this.levelOne = levelOne;
	}
	public List<CourseDTO> getLevelTwo() {
		return levelTwo;
	}
	public void setLevelTwo(List<CourseDTO> levelTwo) {
		this.levelTwo = levelTwo;
	}
	public List<CourseDTO> getLevelThree() {
		return levelThree;
	}
	public void setLevelThree(List<CourseDTO> levelThree) {
		this.levelThree = levelThree;
	}
	public List<CourseDTO> getLevelFour() {
		return levelFour;
	}
	public void setLevelFour(List<CourseDTO> levelFour) {
		this.levelFour = levelFour;
	}
	public List<CourseDTO> getLevelFive() {
		return levelFive;
	}
	public void setLevelFive(List<CourseDTO> levelFive) {
		this.levelFive = levelFive;
	}
	public List<CourseDTO> getLevelSix() {
		return levelSix;
	}
	public void setLevelSix(List<CourseDTO> levelSix) {
		this.levelSix = levelSix;
	}
	
	
	
	

}
