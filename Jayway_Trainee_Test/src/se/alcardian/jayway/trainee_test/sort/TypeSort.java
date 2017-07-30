package se.alcardian.jayway.trainee_test.sort;

import java.util.Comparator;
import se.alcardian.jayway.trainee_test.STool;

public class TypeSort implements Comparator<STool>{
	@Override
    public int compare(STool o1, STool o2) {
		if(o1.isFramework() == o2.isFramework()){
			return o1.getName().compareTo(o2.getName());
		}else if(o1.isFramework() && !o2.isFramework()){
			return -1;
		}else{
			return 1;
		}
    }
}
