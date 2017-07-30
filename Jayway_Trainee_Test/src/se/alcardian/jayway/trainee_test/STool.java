package se.alcardian.jayway.trainee_test;

import java.util.ArrayList;
import java.util.Comparator;

/** STool = Software Tool */
public class STool {
	/** Name of the framework or utility */
	private String name;
	/** Framework = true, otherwise utility (false) */
	private boolean framework;
	/** ID of the programming language it's written for */
	private int language;
	/** If it's intrusive or not. 0 = unknown, 1 = yes, 2 = no */
	private int intrusive;
	/** If it's open source or not. 0 = unknown, 1 = yes, 2 = no */
	private int openSource;
	
	public STool(String name, boolean isFramework, int language, int intrusive, int openSource){
		// Using the set methods to avoid repeating the same code as in the set methods
		this.setName(name);
		this.setFramework(isFramework);
		this.setLanguage(language);
		this.setIntrusive(intrusive);
		this.setOpenSource(openSource);
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		// Don't want any nulls here
		if(name == null){
			this.name = "";
		}else{
			this.name = name;
		}
	}
	public boolean isFramework() {
		return framework;
	}
	public void setFramework(boolean framework) {
		this.framework = framework;
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
	
	public String toFileFormat(){
		String buffer = getName()+",";
		buffer += isFramework()+",";
		buffer += getLanguage()+",";
		buffer += getIntrusive()+",";
		buffer += getOpenSource();
		return buffer;
	}
	
	// Format to be used in the list
	@Override
	public String toString() {
	    return toString(null);
	}
	
	public String toString(ArrayList<Language> lang) {
		if(lang != null){
			String temp = "";
			int i=0;
			while(temp.equals("") && i<lang.size()){
				//Found matching language ID's
				if(lang.get(i).getid() == getLanguage()){
					temp = lang.get(i).getName();
				}
				i++;
			}
		    return name+" | "+isFramework()+" | "+temp+" | "
		    		+Main.toVal(getIntrusive())+" | "+Main.toVal(getOpenSource());
		}else{
			return name+" | "+isFramework()+" | "+getLanguage()+" | "
		    		+Main.toVal(getIntrusive())+" | "+Main.toVal(getOpenSource());
		}
		
	}
	/**
	public class NameSort implements Comparator<STool>{
		@Override
	    public int compare(STool o1, STool o2) {
	        return o1.getName().compareTo(o2.getName());
	    }
	}
	
	public static Comparator<STool> SToolNameComparator
		= new Comparator<STool>() {
		public int compare(STool o1, STool o2) {
	        return o1.getName().compareTo(o2.getName());
	    }
		};
	
	public class LangSort implements Comparator<STool>{
		@Override
	    public int compare(STool o1, STool o2) {
	        if(o1.getLanguage()>o2.getLanguage()){
	        	return +1;
	        }else if(o1.getLanguage()<o2.getLanguage()){
	        	return -1;
	        }else{
	        	return o1.getName().compareTo(o2.getName());
	        }
	    }
	}
	public class TypeSort implements Comparator<STool>{
		@Override
	    public int compare(STool o1, STool o2) {
			if(o1.isFramework() == o2.isFramework()){
				return o1.getName().compareTo(o2.getName());
			}else if(o1.isFramework() && !o2.isFramework()){
				return 1;
			}else{
				return -1;
			}
	    }
	}
	public class IntrSort implements Comparator<STool>{
		@Override
	    public int compare(STool o1, STool o2) {
			if(o1.getIntrusive()>o2.getIntrusive()){
	        	return +1;
	        }else if(o1.getIntrusive()<o2.getIntrusive()){
	        	return -1;
	        }else{
	        	return o1.getName().compareTo(o2.getName());
	        }
	    }
	}**/
	/**
	 * Not used as it wasn't specified in the instructions. Implemented in-case that changes.
	 */
	public class OpenSort implements Comparator<STool>{
		@Override
	    public int compare(STool o1, STool o2) {
			if(o1.getOpenSource()>o2.getOpenSource()){
	        	return +1;
	        }else if(o1.getOpenSource()<o2.getOpenSource()){
	        	return -1;
	        }else{
	        	return o1.getName().compareTo(o2.getName());
	        }
	    }
	}
}
