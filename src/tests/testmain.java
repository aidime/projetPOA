package tests;

import players.*;
import core.*;

public class testmain {

	public static void main (String[] args) {
		
		Player p1 = new Player(0,"Paul","Aidime");
		Player p2 = new Player(1,"Marion","KyZoar");
		
		
		
		
		Player[] players = new Player[] {
				p1,
				p2
		};
		
		
		Logs.writeLog("Added players" + p1._nickName + " and " + p2._nickName + ".");
		
		Campaign naheulbeuk = new Campaign(0, "Le Donjon de Naheulbeuk", players);
		Logs.writeLog("Created new campaign named : " + naheulbeuk.name);
		
		Logs.writeLog("Lets try to roll two six-faced dices...");
		DiceRolls.rollTheDices(6,2);
		
		
	}
	
}
