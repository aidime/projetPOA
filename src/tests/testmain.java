package tests;

import players.*;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import core.*;

public class testmain {

	public static void main (String[] args) throws IOException {
		
//		Logger logger = Logger.getLogger("MyLog");  
//	    FileHandler fh;
//	    File logging = new File("logging.txt");
//	    logging.getParentFile().mkdirs(); // correct!
//	    if (!logging.exists()) {
//	        logging.createNewFile();
//	    } 
//	    //String campaignName = ""; //TODO take the campaign name from the current campaign, or better, the id
//
//	    try {  
//
//	        // This block configure the logger with handler and formatter  
//	        fh = new FileHandler("C:/temp/test/MyLogFile.log", true);  //TODO replace according to changes
//	        logger.addHandler(fh);
//	        SimpleFormatter formatter = new SimpleFormatter();  
//	        fh.setFormatter(formatter);  
//
//	        logger.info("First log");
//
//	    } catch (SecurityException e) {  
//	        e.printStackTrace();  
//	    } catch (IOException e) {  
//	        e.printStackTrace();  
//	    }  
//	    
//	    
//	    BufferedWriter writer = null;
//        try {
//            //create a temporary file
//            String timeLog = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
//            File logFile = new File(timeLog);
//
//            // This will output the full path where the file will be written to...
//            System.out.println(logFile.getCanonicalPath());
//
//            writer = new BufferedWriter(new FileWriter(logFile,true));
//            writer.write("Hello world!");
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                // Close the writer regardless of what happens...
//                writer.close();
//            } catch (Exception e) {
//            }
//        }
	    
        
	    
	    // the following statement is used to log any messages  
        //logger.info(log); 
		
		
        
        //create a temporary file
        File logFile = new File("Logs.log");

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
		
		logger.info("Added players " + p1._nickName + " and " + p2._nickName + ".");
		
		
		Player[] players = new Player[] {
				p1,
				p2
		};
		
		
		Campaign naheulbeuk = new Campaign(0, "Le Donjon de Naheulbeuk", players);
		logger.info("Created new campaign named : " + naheulbeuk.name + ".");
		
		logger.info("Lets try to roll two six-faced dices...");
		DiceRolls.rollTheDices(6,2,logger);
		
	}
	
}
