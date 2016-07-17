package com.trianglz.bridgecrestdesign.model.SortableTable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wakeel on 14/07/16.
 */
public class SleepingData {

    public static List<Sleep> createSleepingList(){
        final Sleep day1 = new Sleep("13/07/2016",80,5,4);
        final Sleep day2 = new Sleep("14/07/2016",65,4,3);
        final Sleep day3 = new Sleep("15/07/2016",75,6,4);
        final Sleep day4 = new Sleep("16/07/2016",85,8,5);
        final Sleep day5 = new Sleep("17/07/2016",85,9,5);
        final Sleep day6 = new Sleep("18/07/2016",55,4,3);
        final Sleep day7 = new Sleep("19/07/2016",90,6,5);

        final List<Sleep> sleeps = new ArrayList<>();
        sleeps.add(day1);
        sleeps.add(day2);
        sleeps.add(day3);
        sleeps.add(day4);
        sleeps.add(day5);
        sleeps.add(day6);
        sleeps.add(day7);

        return sleeps;
    }
}
