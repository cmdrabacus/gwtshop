package de.leuphana.internet.baseshop.shared;


public class FieldVerifier {

	/*
	 * Ist der eingebene Name valide?
	 */
	
	public static boolean isValidName(String name) {
		if (name == null) {
			return false;
		}
		return name.length() > 3;
	}
}
