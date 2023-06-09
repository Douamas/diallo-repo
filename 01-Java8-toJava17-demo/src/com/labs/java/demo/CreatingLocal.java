package com.labs.java.demo;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class CreatingLocal {

	public static void main(String[] args) {
		// lab-1
		// 1. Constructors
		System.out.println(new Locale("en")); // en

		Locale locEnglishGB = new Locale("en", "GB"); // en_GB
		System.out.println(locEnglishGB.getDisplayLanguage()); // anglais
		System.out.println(locEnglishGB.getDisplayCountry()); // Royaume-Uni

		// 2. Built-in constants
		System.out.println(Locale.FRENCH); // en
		Locale locFrenchFrance = Locale.FRANCE;
		System.out.println(locFrenchFrance.getDisplayLanguage()); // français
		System.out.println(locFrenchFrance.getDisplayCountry()); // France

		// 3. Locale.Builder() pattern
		Locale locArabicEgypt = new Locale.Builder().setLanguage("ar") // language first
				.setRegion("EG") // country second
				.build();

		System.out.println(locArabicEgypt); // ar_EG

		Locale locArabickuwait = new Locale.Builder().setRegion("KW") // language first
				.setLanguage("ar") // country second
				.build();

		System.out.println(locArabickuwait); // ar_KW

		// lab-2 : Localising Numbers and Currencies
		formatNumbers();
		formatCurrencies();
		parseNumbers();
		parseCurrencies();

	}

	public static void formatNumbers() {
		// format: number --> String
		double n = 77_000.11;

		System.out.println(NumberFormat.getInstance().format(n)); // 77 000,11
		System.out.println(NumberFormat.getNumberInstance(Locale.US).format(n)); // 77,000.11
	}

	public static void formatCurrencies() {

		// format: number --> String
		double n = 23.22;

		System.out.println(NumberFormat.getCurrencyInstance().format(n)); // 23,22 €
		System.out.println(NumberFormat.getCurrencyInstance(Locale.US).format(n)); // $23.22

	}

	public static void parseNumbers() {
		// parse: String --> Number
		String unitedSatesNumber = "77,00.11";
		String italianNumber = "77.00,11";
		String frenchNumber = "77 00,11";

		try {
			System.out.println(NumberFormat.getNumberInstance(Locale.US).parse(unitedSatesNumber)); // 7700.11
			System.out.println(NumberFormat.getNumberInstance(Locale.ITALY).parse(italianNumber)); // 7700.11
			System.out.println(NumberFormat.getNumberInstance(Locale.FRANCE).parse(frenchNumber)); // 77

		} catch (ParseException e) {
			e.printStackTrace();
		}

	}

	public static void parseCurrencies() {
		// parse: String --> Number
		String USCurrency = "$23.22";
		String UKCurrency = "£23.22";

		try {
			System.out.println(NumberFormat.getCurrencyInstance(Locale.US).parse(USCurrency)); // 23.22
			System.out.println(NumberFormat.getCurrencyInstance(Locale.UK).parse(UKCurrency)); // 23.22

		} catch (ParseException e) {
			e.printStackTrace();
		}

	}

}
