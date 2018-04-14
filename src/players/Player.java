package players;

public class Player {


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
	public Skills _skills;
	
	
	
	/*
	 * ==============================
	 * ---------CONSTRUCTORS---------
	 * ==============================
	 */
	//creates a brand new character, initialized with no skills and at level 1
	public Player(int id, String name, String nickname) {
		_id = id;
		_name = name;
		_nickName = nickname;
		_level = 1;
		_health = 10;
		_skills = null;
	}
	
	//creates a character at a certain level and with certain skills entered in the form
	//used to get a saved character back into the app
	public Player(int id, String name, String nickname, int level, int health, Skills skills) {
		_id = id;
		_name = name;
		_nickName = nickname;
		_level = level;
		_health = health;
		_skills = skills;
	}
	
	

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
}
