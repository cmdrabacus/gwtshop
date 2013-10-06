package de.leuphana.internet.baseshop.shared;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class BachelorThesis extends Exam implements Serializable {
	private static final long serialVersionUID = 3282998458292781891L;
	
	// Werte fuer Bachelorarbeit
	private String bachelorstudent;
	private String firstexaminer;
	private String secondexaminer;
	private int price;
	
	public BachelorThesis() {
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

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getFirstexaminer() {
		return firstexaminer;
	}

	public void setFirstexaminer(String firstexaminer) {
		this.firstexaminer = firstexaminer;
	}

	public String getSecondexaminer() {
		return secondexaminer;
	}

	public void setSecondexaminer(String secondexaminer) {
		this.secondexaminer = secondexaminer;
	}
}