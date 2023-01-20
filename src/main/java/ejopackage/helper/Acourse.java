package ejopackage.helper;

public class Acourse {
	
	private String name;
	
    private int level;
    private int hourz;
    private int importance;
     private int combinationid;
	private int codecategoryid;

	public Acourse() {

	}
  
	public Acourse(String name, int level, int hourz, int importance, int combinationid, int codecategoryid) {
		this.name = name;
		this.level = level;
		this.hourz = hourz;
		this.importance = importance;
		this.combinationid = combinationid;
		this.codecategoryid = codecategoryid;
	
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCodecategoryid() {
		return codecategoryid;
	}
	public void setCodecategoryid(int codecategoryid) {
		this.codecategoryid = codecategoryid;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getHourz() {
		return hourz;
	}

	public void setHourz(int hourz) {
		this.hourz = hourz;
	}

	public int getImportance() {
		return importance;
	}

	public void setImportance(int importance) {
		this.importance = importance;
	}

	public int getCombinationid() {
		return combinationid;
	}

	public void setCombinationid(int combinationid) {
		this.combinationid = combinationid;
	}

   	

}
