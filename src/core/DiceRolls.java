package core;

import java.util.Random;
import java.util.logging.Logger;


public class DiceRolls {

	/*
	 * ==============================
	 * ----------ATTRIBUTES----------
	 * ==============================
	 */
	public int diceFaces;
	public int numberOfDices;
	public int passingRoll;
	
	
	
	/*
	 * ==============================
	 * ---------CONSTRUCTORS---------
	 * ==============================
	 */
	public DiceRolls(int faces, int number, int passing) {
		diceFaces = faces;
		numberOfDices = number;
		passingRoll = passing;
	}
	
	
	
	
	/*
	 * ==============================
	 * ----------GET/SETTERS---------
	 * ==============================
	 */
	public void setDiceFaces(int diceFaces) {
		this.diceFaces = diceFaces;
	}
	
	public void setNumberOfDices(int numberOfDices) {
		this.numberOfDices = numberOfDices;
	}
	
	public void setPassingRoll(int passingRoll) {
		this.passingRoll = passingRoll;
	}
	
	
	
	/*
	 * ==============================
	 * ------------METHODS-----------
	 * ==============================
	 */
	public static int rollTheDices(int faces, int number, Logger logger) {
		int result = 0;
		String log = "Rolls : ";
		Random rand = new Random();
		
		for(int i = 1 ; i<=number ; i++) {
			int randInt = rand.nextInt(faces) + 1;
			if(i<number)
				log += randInt + " + ";
			else
				log += randInt + ".";
			result += randInt;
		}
		
		logger.info(log);
		
		return result;
	}

	//TODO roll with a passing condition
	
}
