package se.alcardian.jayway.trainee_test.sort;

import java.util.Comparator;
import se.alcardian.jayway.trainee_test.STool;

public class NameSort implements Comparator<STool>{
	@Override
    public int compare(STool o1, STool o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
