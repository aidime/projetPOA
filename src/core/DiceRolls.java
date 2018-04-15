package core;

import java.util.Random;
import java.util.logging.Logger;


public class DiceRolls {
	
	
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
