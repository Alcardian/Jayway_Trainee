package se.alcardian.jayway.trainee_test.sort;

import java.util.Comparator;
import se.alcardian.jayway.trainee_test.STool;

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
}
