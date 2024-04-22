package net.ishukone.perplexedtheta;

import java.io.IOException;
import java.util.Scanner;

// jake lost his fucking mind writing this crappy program
// milestone: my first Java app, hopefully one of my last

// this is really ugly, Java
public class Main {
	public static void main(String[] args) throws IOException {
		// vars
		String givenValue;
		String currencyTo;
		float myGivenValue = 0.00F;

		// init new currencyConverter object & misc nonsense
		currencyConverter myCurrencyConverter = new currencyConverter();
		Scanner terminalInput = new Scanner(System.in); // to read strings

		// say hi
		System.out.println("Welcome! This program takes any given numeric input, and a currency code, and converts the");
		System.out.println("first input (e.g. the numeric value) into the given currency code. e.g. if you enter 1.77 and");
		System.out.println("select eur, you will get 1.77 gbp in eur.\n");

		// ask for input & handle bad shit somehow
		System.out.print("Hello! Please enter your currency value, e.g. 1.00 []: ");
		givenValue = terminalInput.nextLine();
		// the below can fuck right off
		try {
			myGivenValue = Float.parseFloat(givenValue);
		} catch (NumberFormatException nfe) {
			System.out.println("Not a valid numeric value! Goodbye.\n");
			System.exit(127);
		}
		// who invented this demented, over-complicated syntax

		// ask for input & handle bad shit somehow
		System.out.println("Next, please enter the currency to convert to [eur/gbp]: ");
		currencyTo = terminalInput.nextLine();
		// v WHAT IS THIS FUCKERY v
		if(!currencyTo.toLowerCase().equals("eur") && !currencyTo.toLowerCase().equals("gbp")) {
			System.out.println("Not a currency! Goodbye.\n");
			System.exit(127); // bad
		} else if(currencyTo.toLowerCase().equals("eur")) {
			// this line below is how you round a float. painful innit?
			double eurValue = Math.round(myCurrencyConverter.convertToEur(myGivenValue) * Math.pow(10, 2)) / Math.pow(10, 2);
			System.out.println(givenValue + " gbp to eur is " + eurValue + "\n"); // last goodbye
		} else if(currencyTo.toLowerCase().equals("gbp")) {
			double gbpValue = Math.round(myCurrencyConverter.convertToEur(myGivenValue) * Math.pow(10, 2)) / Math.pow(10, 2);
			System.out.println(givenValue + " eur to gbp is " + gbpValue + "\n");
		}

		return; // good
	}
}

// wooo class #2
class currencyConverter {
	// global vars
	static float eurInGbp = 1.1612F;

	public static float convertToEur(float gbp) {
		return gbp * eurInGbp; // to convert gbp to eur, multiply gbp by eurInGbp
	}

	public static float convertToGbp(float eur) {
		return eur / eurInGbp; // to convert eur to gbp, divide eur by eurInGbp
	}
}
