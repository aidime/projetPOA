package core;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Logs {

	
	public static void writeLog(String log) {  

	    Logger logger = Logger.getLogger("MyLog");  
	    FileHandler fh;  
	    
	    String campaignName = "";

	    try {  

	        // This block configure the logger with handler and formatter  
	        fh = new FileHandler("C:/RPGManager/"+campaignName+"/"+campaignName+".log", true);  
	        logger.addHandler(fh);
	        SimpleFormatter formatter = new SimpleFormatter();  
	        fh.setFormatter(formatter);  

	        // the following statement is used to log any messages  
	        logger.info(log);  

	    } catch (SecurityException e) {  
	        e.printStackTrace();  
	    } catch (IOException e) {  
	        e.printStackTrace();  
	    }  

	      

	}
	
}
