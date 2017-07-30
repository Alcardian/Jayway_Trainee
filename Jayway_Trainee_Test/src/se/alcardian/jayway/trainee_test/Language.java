package se.alcardian.jayway.trainee_test;

import java.util.ArrayList;

public class Language {
	/** Name of the programming language */
	private String name;
	/** The unique ID of the programming language */
	private int id;
	
	public Language(String name, int id, ArrayList<STool> stool, ArrayList<Language> lang){
		// Using the set methods to avoid repeating the same code as in the set methods
		this.setName(name);
		this.setID(id, stool, lang);
	}
	
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name = name;
	}
	public int getid(){
		return id;
	}
	/**
	 * Sets the id but first checks against the list of STool if any will be affected & updates them.
	 * @param id
	 * @param stool Send null if you want to ignore updating the STool list
	 * @param lang Send null if you want to ignore possible duplicate ID's
	 * @return
	 */
	public boolean setID(int id, ArrayList<STool> stool, ArrayList<Language> lang){
		if(lang != null){
			// Check if the new id is already in use
			for(int i=0;i<lang.size();i++){
				// If we found a Language already using the 'new' id number
				if(lang.get(i).getid() == id){
					// Will not make any change, return false
					return false;
				}
			}
			
			// Change id of existing STool to match the update
			for(int i=0;i<stool.size();i++){
				if(stool.get(i).getLanguage() == getid()){
					stool.get(i).setLanguage(id);
				}
			}
			this.id = id;
			return true;
		}else{
			this.id = id;
			return true;
		}
	}
	
	@Override
	public String toString() {
	    return getName()+" | "+getid();
	}
	
	public String toFileFormat(){
		String tmp = getName()+",";
		tmp += getid();
		return tmp;
	}
}
