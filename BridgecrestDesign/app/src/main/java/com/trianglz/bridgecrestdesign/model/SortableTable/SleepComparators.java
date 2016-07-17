package com.trianglz.bridgecrestdesign.model.SortableTable;

import java.util.Comparator;

/**
 * Created by wakeel on 14/07/16.
 */
public class SleepComparators {

    private SleepComparators() {

    }

    public static Comparator<Sleep> getSleepDateComparator() {
        return new SleepDateComparator();
    }

    public static Comparator<Sleep> getSleepRatioComparator() {
        return new SleepRatioComparator();
    }

    public static Comparator<Sleep> getSleepTotalComparator() {
        return new SleepTotalComparator();
    }

    public static Comparator<Sleep> getSleepRatingsComparator() {
        return new SleepRatingsComparator();
    }

    private static class SleepDateComparator implements Comparator<Sleep> {

        @Override
        public int compare(final Sleep sleep1, final Sleep sleep2) {
            return sleep1.getDay().compareTo(sleep2.getDay());
        }
    }

    private static class SleepRatioComparator implements Comparator<Sleep> {

        @Override
        public int compare(final Sleep sleep1, final Sleep sleep2) {
            return sleep1.getQuality() - (sleep2.getQuality());
        }
    }

    private static class SleepTotalComparator implements Comparator<Sleep> {

        @Override
        public int compare(final Sleep sleep1, final Sleep sleep2) {
            if (sleep1.getTotalSlept() < sleep2.getTotalSlept()) return -1;
            if (sleep1.getTotalSlept() > sleep2.getTotalSlept()) return 1;
            return 0;
        }
    }

    private static class SleepRatingsComparator implements Comparator<Sleep> {

        @Override
        public int compare(final Sleep sleep1, final Sleep sleep2) {
            if (sleep1.getInterrupts() < sleep2.getInterrupts()) return -1;
            if (sleep1.getInterrupts() > sleep2.getInterrupts()) return 1;
            return 0;
        }
    }

}
