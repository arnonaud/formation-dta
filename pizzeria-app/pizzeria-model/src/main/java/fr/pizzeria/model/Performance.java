package fr.pizzeria.model;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "performance")
public class Performance {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String service;
	private Date date;
	private int milliSecondes;

	public Performance(){
		
	}
	
	public Performance(String service, Date date, int milliSecondes) {

		this.service = service;
		this.date = date;
		this.milliSecondes = milliSecondes;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getMilliSecondes() {
		return milliSecondes;
	}

	public void setMilliSecondes(int milliSecondes) {
		this.milliSecondes = milliSecondes;
	}
	
	public String afficherPerformance() {
		return (this.getService()+ " "+this.getMilliSecondes()+" "+this.getDate());
	}

}
