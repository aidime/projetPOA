package core;
//import java.io.File;

import players.*;

public class Campaign {

	/*
	 * ==============================
	 * ----------ATTRIBUTES----------
	 * ==============================
	 */
	public int id;
	public String name;
	public Player[] players;
	
	
	/*
	 * ==============================
	 * ---------CONSTRUCTORS---------
	 * ==============================
	 */
	public Campaign(int id, String name, Player[] players) {
		this.id = id;
		this.name = name;
		this.players = players;
		
		//TODO create folders for the adequate saving of the campaign for later use
//		File f = new File("C:\\RPGManager");
//		try{
//		    if(f.mkdir()) { 
//		        System.out.println("Directory Created");
//		    } else {
//		        System.out.println("Directory is not created");
//		    }
//		} catch(Exception e){
//		    e.printStackTrace();
//		} 
	}
	
	
	
	/*
	 * ==============================
	 * ----------GET/SETTERS---------
	 * ==============================
	 */
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Player[] getPlayers() {
		return players;
	}
	
	public void setPlayers(Player[] players) {
		this.players = players;
	}
	
	
	/*
	 * ==============================
	 * ------------METHODS-----------
	 * ==============================
	 */
	
	//TODO serialize and deserialize
}
