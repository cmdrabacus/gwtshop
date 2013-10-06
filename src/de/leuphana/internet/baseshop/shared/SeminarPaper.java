package de.leuphana.internet.baseshop.shared;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class SeminarPaper extends Exam implements Serializable {
	private static final long serialVersionUID = -104200536559141294L;
	
	// Werte fuer Seminararbeit
	private String course;
	private String lecturer;
	private String bachelorstudent;
	private int price;
	
	public SeminarPaper() {
	}
	
	@Id
	@GeneratedValue
	@Override
	public int getProductNumber() {
		return productnumber;
	}

	@Override
	public void setProductNumber(int productnumber) {
		this.productnumber = productnumber;
	}

	@Override
	public String getTopic() {
		return topic;
	}

	@Override
	public void setTopic(String topic) {
		this.topic = topic;
	}

	@Override
	public int getSiteCount() {
		return sitecount;
	}

	@Override
	public void setSiteCount(int sitecount) {
		this.sitecount = sitecount;
	}

	@Override
	public int getYear() {
		return year;
	}
	
	@Override
	public void setYear(int year) {
		this.year = year;
	}
	
	@Override
	public String getBachelorstudent() {
		return bachelorstudent;
	}
	
	@Override
	public void setBachelorstudent(String bachelorstudent) {
		this.bachelorstudent = bachelorstudent;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getLecturer() {
		return lecturer;
	}

	public void setLecturer(String lecturer) {
		this.lecturer = lecturer;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
}
