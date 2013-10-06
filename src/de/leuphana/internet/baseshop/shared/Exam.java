package de.leuphana.internet.baseshop.shared;

import java.io.Serializable;

/*
 *  Elternklasse fuer Arbeiten
 */


public abstract class Exam implements Serializable {
	private static final long serialVersionUID = -2792992498214976880L;
	
	// Werte fuer Arbeiten
	int productnumber;
	String topic;
	int sitecount;
	int year;
	String bachelorstudent;
	int price;
	
	public Exam(){}

	public int getProductNumber() {
		return productnumber;
	}

	public void setProductNumber(int productnumber) {
		this.productnumber = productnumber;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public int getSiteCount() {
		return sitecount;
	}

	public void setSiteCount(int sitecount) {
		this.sitecount = sitecount;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getBachelorstudent() {		
		return bachelorstudent;
	}
	
	public void setBachelorstudent(String bachelorstudent) {
		this.bachelorstudent = bachelorstudent;
	}

	public int getPrice() {
		return price;
	}

	
}
