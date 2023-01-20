package ejopackage.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
@Entity
public class Levelprototype {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
    private int name;
	private String description;
    private LocalDateTime created;
    private LocalDateTime updated;
    private int maxhourz;
    @ManyToOne
    private Combinationprototype combinationprototype;
    
    @OneToOne
    private Bloomindex bloomindex;
    
    @OneToOne
    private Bulletinprototype bulletinprototype;
    
	public Levelprototype() {
	
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getName() {
		return name;
	}
	public void setName(int name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public LocalDateTime getCreated() {
		return created;
	}
	public void setCreated(LocalDateTime created) {
		this.created = created;
	}
	public LocalDateTime getUpdated() {
		return updated;
	}
	public void setUpdated(LocalDateTime updated) {
		this.updated = updated;
	}
	public Combinationprototype getCombinationprototype() {
		return combinationprototype;
	}
	public void setCombinationprototype(Combinationprototype combinationprototype) {
		this.combinationprototype = combinationprototype;
	}
	public Bloomindex getBloomindex() {
		return bloomindex;
	}
	public void setBloomindex(Bloomindex bloomindex) {
		this.bloomindex = bloomindex;
	}
	public Bulletinprototype getBulletinprototype() {
		return bulletinprototype;
	}
	public void setBulletinprototype(Bulletinprototype bulletinprototype) {
		this.bulletinprototype = bulletinprototype;
	}
	public int getMaxhourz() {
		return maxhourz;
	}
	public void setMaxhourz(int maxhourz) {
		this.maxhourz = maxhourz;
	}
  
	
	
}
