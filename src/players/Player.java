package players;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.Arrays;

public class Player implements Serializable{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	/*
	 * ==============================
	 * ----------ATTRIBUTES----------
	 * ==============================
	 */
	public int _id;
	public String _name;
	public String _nickName;
	public int _level;
	public int _health;
	public int _initiative;
	public Skills _skills;
	public String[] _inventory;
	//TODO manque l'xp ?
	
	
	/*
	 * ==============================
	 * ---------CONSTRUCTORS---------
	 * ==============================
	 */
	//creates a brand new character, initialized with no skills and at level 1
	public Player(int id, String name, String nickname) throws IOException {
		_id = id;
		_name = name;
		_nickName = nickname;
		_level = 1;
		_health = 10;
		_initiative = 100;
		_skills = null;
		_inventory = null;
		
		File playerFile = new File("tests/players/"+_nickName);
        File parent = playerFile.getParentFile();
        if (!parent.exists() && !parent.mkdirs()) {
            throw new IllegalStateException("Couldn't create dir: " + parent);
        }
        
        SerializationUtil.serialize(this,"tests/players/"+_nickName);
        
	}
	
	public Player(String fileName) throws ClassNotFoundException, IOException {
		SerializationUtil.deserialize("tests/players/"+fileName);
	}
	
	//creates a character at a certain level and with certain skills entered in the form
	//used to get a saved character back into the app
	//TODO do we really need that with the (de)serialization ?
//	public Player(int id, String name, String nickname, int level, int health, int initiative, Skills skills, String[] inventory) {
//		_id = id;
//		_name = name;
//		_nickName = nickname;
//		_level = level;
//		_health = health;
//		_initiative = initiative;
//		_skills = skills;
//		_inventory = inventory;
//	}
	
	




	/*
	 * ==============================
	 * ----------GET/SETTERS---------
	 * ==============================
	 */
	public int get_id() {
		return _id;
	}

	public void set_id(int _id) {
		this._id = _id;
	}

	public String get_name() {
		return _name;
	}

	public void set_name(String _name) {
		this._name = _name;
	}
	
	public String get_nickName() {
		return _nickName;
	}

	public void set_nickName(String nickName) {
		_nickName = nickName;
	}

	public int get_level() {
		return _level;
	}

	public void set_level(int level) {
		_level = level;
	}

	public int get_health() {
		return _health;
	}

	public void set_health(int health) {
		_health = health;
	}
	
	public int get_initiative() {
		return _initiative;
	}

	public void set_initiative(int _initiative) {
		this._initiative = _initiative;
	}
	
	public Skills get_skills() {
		return _skills;
	}

	public void set_skills(Skills skills) {
		_skills = skills;
	}
	
	
	/*
	 * ==============================
	 * ------------METHODS-----------
	 * ==============================
	 */
	public void savePlayerState(Player player) throws IOException {
		//TODO
		SerializationUtil.serialize(player, player._nickName);
	}
	
	public void loadPlayerState(String playerName) throws ClassNotFoundException, IOException {
		//TODO
		SerializationUtil.deserialize(playerName);
	}
	
	public void playerDamage(int damage) {
		_health -= damage;
	}
	
	public void playerHeal(int healAmount) {
		_health += healAmount;
	}
	
	
	@Override
	public String toString() {
		return "Player id : " + _id 
				+ "\nName : " + _name 
				+ "\nNickName : " + _nickName 
				+ "\nLevel : " + _level
				+ "\nHealth : " + _health 
				+ "\nInitiative : " + _initiative 
				+ "\nSPECIAL : " + _skills._skills.toString()
				+ "\nInventory : " + Arrays.toString(_inventory);
	}
}
