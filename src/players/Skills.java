package players;

import java.util.Map;

//import core.Logs;

public class Skills {

	/*
	 * ==============================
	 * ----------ATTRIBUTES----------
	 * ==============================
	 */
	public Map<String, Integer> _skills;
	
	
	/*
	 * ==============================
	 * ---------CONSTRUCTORS---------
	 * ==============================
	 */
	//to simplify the implementation, we will use the very basic "SPECIAL" system from the Fallout series of game
	//SPECIAL stands for Strength Perception Endurance Charisma Intelligence Agility Luck
	public Skills(int s, int p, int e, int c, int i, int a, int l) {
		_skills.put("S", s);
		_skills.put("P", p);
		_skills.put("E", e);
		_skills.put("C", c);
		_skills.put("I", i);
		_skills.put("A", a);
		_skills.put("L", l);
	}
	
	
	/*
	 * ==============================
	 * ----------GET/SETTERS---------
	 * ==============================
	 */

	public Map<String, Integer> get_skills() {
		return _skills;
	}


	public void set_skills(Map<String, Integer> _skills) {
		this._skills = _skills;
	}

	
	
	/*
	 * ==============================
	 * ------------METHODS-----------
	 * ==============================
	 */
//	public int getSkillValue(String skillname) {
//		int val = 0;
//		for (Map.Entry<String, Integer> entry : _skills.entrySet()) {
//			if(skillname.equals(entry.getKey())){
//				val = entry.getValue().intValue();
//			}
//		}
//		return val;
//	}
	
	
	
	public void increaseSkillvalue(String skillname, int increase) {
		for (Map.Entry<String, Integer> entry : _skills.entrySet()) {
			if(skillname.equals(entry.getKey())){
				entry.setValue(entry.getValue().intValue() + increase);
			}
		}
		
		//TODO Logs.writeLog(skillname + " of " + nickname + " increased by " + increase.toString() + ".");
		
	}


	@Override
	public String toString() {
		return "SPECIAL\n" + _skills.values();
	}



	
}
