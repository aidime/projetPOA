package core;

public class Event {

	/*
	 * ==============================
	 * ----------ATTRIBUTES----------
	 * ==============================
	 */
	public int _id;
	public String _name;
	public String[] _content; //May contain monster names, NPC names, item names discovered, ... aims to be the support of the GM's imagination
	public String _notes; //Filling this is up to the GM : can store monster stats, merchants inventory, ... can be modified in game
	
	
	/*
	 * ==============================
	 * ---------CONSTRUCTORS---------
	 * ==============================
	 */
	public Event(int _id, String _name, String[] _content, String _notes) {
		super();
		this._id = _id;
		this._name = _name;
		this._content = _content;
		this._notes = _notes;
	}
	
	
	
	
	/*
	 * ==============================
	 * ----------GET/SETTERS---------
	 * ==============================
	 */
	
	
	
	/*
	 * ==============================
	 * ------------METHODS-----------
	 * ==============================
	 */
}
