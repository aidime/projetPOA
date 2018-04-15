package core;

public class Event {

	/*
	 * ==============================
	 * ----------ATTRIBUTES----------
	 * ==============================
	 */

	public String _title; //May contain monster names, NPC names, item names discovered, ... make it short
	public String _notes; //Filling this is up to the GM : can store monster stats, merchants inventory, ... can be modified in game
	
	
	/*
	 * ==============================
	 * ---------CONSTRUCTORS---------
	 * ==============================
	 */
	public Event(String _title, String _notes) {
		this._title = _title;
		this._notes = _notes;
	}



		
	/*
	 * ==============================
	 * ----------GET/SETTERS---------
	 * ==============================
	 */
	public String get_title() {
		return _title;
	}


	public void set_title(String _title) {
		this._title = _title;
	}


	public String get_notes() {
		return _notes;
	}


	public void set_notes(String _notes) {
		this._notes = _notes;
	}
	
	
	
	
	/*
	 * ==============================
	 * ------------METHODS-----------
	 * ==============================
	 */
}
