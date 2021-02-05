package fr.dauphine.mido.as.projetjava.utils;

import java.time.LocalDate;

public class Utilitaires {

	public static boolean isAlpha(String s) {
		return s.matches("[A-Za-z]+");
	}

	public static boolean isMail(String s) {
		String EMAIL_REGEX = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
		return s.matches(EMAIL_REGEX);
	}

	public static boolean isTelNumber(String num) {
		return num.matches("(0|\\+33|0033)[1-9][0-9]{8}");
	}

	public static boolean isGoodDate(int year) {
		LocalDate currentDate = LocalDate.now();
		int currentYear = currentDate.getYear();
		if(currentYear - year < 120 && year < currentYear)
			return true;
		return false;
	}

}
