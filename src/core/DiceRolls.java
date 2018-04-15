package core;

import java.util.Random;


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
	public int rollTheDices(int faces, int number, int passingRoll) {
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
		
		Logs.writeLog(log);
		
		return result;
	}

	
}
