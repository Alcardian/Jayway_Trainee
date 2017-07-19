package se.alcardian.jayway.trainee_test;

public class Language {
	/** Name of the programming language */
	private String name;
	/** The unique ID of the programming language */
	private int id;
	
	public Language(String name, int id){
		// Using the set methods to avoid repeating the same code as in the set methods
		this.setName(name);
		this.setID(id);
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
	public void setID(int id){
		this.id = id;
	}
}
