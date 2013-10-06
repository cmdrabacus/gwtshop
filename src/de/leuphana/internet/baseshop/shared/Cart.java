package de.leuphana.internet.baseshop.shared;

import java.util.Collection;
import java.util.HashMap;

public class Cart {
	private static Cart instance = null;

	// Singleton
	public static Cart getInstance() {
		if (instance == null) {
			instance = new Cart();
		}
		return instance;
	}

	// Create hashmap
	private HashMap<Integer, CartElement> cartElementHashMap;

	// Transfer objects
	private Exam exam;
	private CartElement cartElement;

	public Cart() {
		this.cartElementHashMap = new HashMap<Integer, CartElement>();
	}

	// Add exam to hashmap
	public void addExam(Exam exam) {
		this.exam = exam;
		if (cartElementHashMap.containsKey(this.exam.getProductNumber())) {
			CartElement cartElement = cartElementHashMap.get(exam
					.getProductNumber());
			cartElement.increase();
		} else {
			cartElement = new CartElement(this.exam);
			cartElement.increase();
			cartElementHashMap.put(this.exam.getProductNumber(), cartElement);
		}
	
	}
	// Get quantity
	public int getNumberOfArticles() {
		return cartElementHashMap.size();
	}

	// Get values
	public Collection<CartElement> getCartElements() {
		return cartElementHashMap.values();
	}

	// Delete elements
	public void delCartElement(int productNumber, CartElement cartElement) {
		this.cartElement = cartElement;
		cartElement = cartElementHashMap.get(productNumber);
		cartElement.decrease();
		if (cartElement.getQuantity() == 0) {
			cartElementHashMap.remove(productNumber);
		}
	}
	public void addToCart(Exam exam) {
		Cart.getInstance().addExam(exam);
	}

}
