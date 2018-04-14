package users;

public class PlayerCharacter extends User{


	/*
	 * ==============================
	 * ----------ATTRIBUTES----------
	 * ==============================
	 */
	public String _nickName;
	public int _level;
	public Skills _skills;
	
	
	
	/*
	 * ==============================
	 * ---------CONSTRUCTORS---------
	 * ==============================
	 */
	//creates a brand new character, initialized with no skills and at level 1
	public PlayerCharacter(int id, String name, String nickname) {
		super(id,name);
		_nickName = nickname;
		_level = 1;
		_skills = null;
	}
	
	//creates a character at a certain level and with certain skills entered in the form
	public PlayerCharacter(int id, String name, String nickname, int level, Skills skills) {
		super(id,name);
		_nickName = nickname;
		_level = level;
		_skills = skills;
	}
	
	/*
	 * ==============================
	 * ----------GET/SETTERS---------
	 * ==============================
	 */
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
