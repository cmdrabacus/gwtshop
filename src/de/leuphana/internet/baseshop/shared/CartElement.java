package de.leuphana.internet.baseshop.shared;

import java.io.Serializable;

public class CartElement implements Serializable {

	private static final long serialVersionUID = 4031161156573867422L;
	
	private int quantity = 0;
	
	private Exam exam;

	public CartElement(Exam exam) {
		this.exam = exam;

	}

	public Exam getExam() {
		return exam;
	}

	public void increase() {
		quantity++;
	}

	public void decrease() {
		quantity--;
	}

	public int getQuantity() {
		return quantity;
	}

}
