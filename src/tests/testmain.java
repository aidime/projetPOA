package tests;

import java.io.File;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import core.Campaign;
import core.DiceRolls;
import players.*;

public class testmain {

	public static void main (String[] args) throws IOException, ClassNotFoundException {
				
		//create a  file
        File logFile = new File("tests/Logs.log");
        File parent = logFile.getParentFile();
        if (!parent.exists() && !parent.mkdirs()) {
            throw new IllegalStateException("Couldn't create dir: " + parent);
        }
		
        // This will output the full path where the file will be written to...
        System.out.println(logFile.getCanonicalPath());

		Logger logger = Logger.getLogger("MyLog");  
	    FileHandler fh;
        
        try {  
	        //This block configure the logger with handler and formatter  
	        fh = new FileHandler(logFile.getCanonicalPath(), true);  //TODO replace according to changes
	        logger.addHandler(fh);
	        SimpleFormatter formatter = new SimpleFormatter();  
	        fh.setFormatter(formatter);  

	        logger.info("First log");

	    } catch (SecurityException e) {  
	        e.printStackTrace();  
	    } catch (IOException e) {  
	        e.printStackTrace();  
	    } 
        
          
        
		Player p1 = new Player(0,"Paul","Aidime");
		Player p2 = new Player(1,"Marion","KyZoar");
		
		p1._skills = new Skills(1,2,3,4,5,6,7);
		p1._skills = new Skills(7,6,5,4,3,2,1);
		
		logger.info("Added players " + p1._nickName + " and " + p2._nickName + ".");
		
		
		Player[] players = new Player[] {
				p1,
				p2
		};
		
		
		Campaign naheulbeuk = new Campaign(0, "Le Donjon de Naheulbeuk", players);
		logger.info("Created new campaign named : " + naheulbeuk.name + ".");
		
		logger.info("Lets try to roll two six-faced dices...");
		DiceRolls.rollTheDices(6,2,logger);
		
		//TODO test serialization
		//Player p3 = new Player("Aidime");
		//
		//logger.info(p1.toString());
		//logger.info(p3.toString());
		
		//p3.set_health(5);
		
		
	}
	
}
