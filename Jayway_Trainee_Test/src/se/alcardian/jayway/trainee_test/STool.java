package se.alcardian.jayway.trainee_test;
/**
 * 
 * @author Sebastian Potter
 * STool = Software Tool
 */
public class STool {
	/** Name of the framework or utility */
	private String name;
	/** Framework = true, otherwise utility (false) */
	private boolean type;
	/** ID of the programming language it's written for */
	private int language;
	/** If it's intrusive or not. 0 = unknown, 1 = yes, 2 = no */
	private int intrusive;
	/** If it's open source or not. 0 = unknown, 1 = yes, 2 = no */
	private int openSource;
	
	public STool(String name, boolean type, int language, int intrusive, int openSource){
		// Using the set methods to avoid repeating the same code as in the set methods
		this.setName(name);
		this.setType(type);
		this.setLanguage(language);
		this.setIntrusive(intrusive);
		this.setOpenSource(openSource);
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isType() {
		return type;
	}
	public void setType(boolean type) {
		this.type = type;
	}
	public int getLanguage() {
		return language;
	}
	public void setLanguage(int language) {
		this.language = language;
	}
	public int getIntrusive() {
		return intrusive;
	}
	public void setIntrusive(int intrusive) {
		this.intrusive = intrusive;
	}
	public int getOpenSource() {
		return openSource;
	}
	public void setOpenSource(int openSource) {
		this.openSource = openSource;
	}
}
