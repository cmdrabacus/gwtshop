package de.leuphana.internet.baseshop.shared;

import java.util.Collection;
import java.util.HashMap;

public class Cart {
	private static Cart instance = null;

	// Instanz von Cart
	public static Cart getInstance() {
		if (instance == null) {
			instance = new Cart();
		}
		return instance;
	}

	// HashMap fuer die Elemente erstellen
	private HashMap<Integer, CartElement> cartElementHashMap;

	// Objekte uebergeben
	private Exam exam;
	private CartElement cartElement;

	public Cart() {
		this.cartElementHashMap = new HashMap<Integer, CartElement>();
	}

	// Exam zur HashMap hinzufuegen
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
	// Anzahl der Elemente aus der HashMap laden
	public int getNumberOfArticles() {
		return cartElementHashMap.size();
	}

	// ValuePart aus HashMap laden
	public Collection<CartElement> getCartElements() {
		return cartElementHashMap.values();
	}

	// Element aus der HashMap loeschen
	public void delCartElement(int productNumber, CartElement cartElement) {
		this.cartElement = cartElement;
		cartElement = cartElementHashMap.get(productNumber);
		cartElement.decrease();
		if (cartElement.getQuantity() == 0) {
			cartElementHashMap.remove(productNumber);
		}
	}

	// Elemente zum Warenkorb hinzufuegen
	public void addToCart(Exam exam) {
		Cart.getInstance().addExam(exam);
	}

}
