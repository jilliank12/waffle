package CInterview.pc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by Jilliankim on 6/19/16.
 */
public class MergeIntervals {
    public static void main(String[] args) {
        Interval test1 = new Interval(0, 1);
        Interval test2 = new Interval(3, 5);
        Interval test3 = new Interval(4, 8);
        Interval test4 = new Interval(10, 12);
        Interval test5 = new Interval(9, 10);

        ArrayList<Interval> unsorted = new ArrayList<>();
        unsorted.add(test1);
        unsorted.add(test2);
        unsorted.add(test3);
        unsorted.add(test4);
        unsorted.add(test5);

        //  [(0, 1), (3, 8), (9, 12)]

        Collections.sort(unsorted, new IntervalComparator());

//        for (int i = 0; i < unsorted.size(); i++) {
//            System.out.println(unsorted.get(i).start);
//        }

        sortIntervals(unsorted);
    }

    public static ArrayList<Interval> sortIntervals(ArrayList<Interval> sorted) {
        ArrayList<Interval> merged = new ArrayList<>();
        if (sorted.size() <= 1) {
            return sorted;
        } else {
            Interval previous = sorted.get(0);
            for (int i = 0; i < sorted.size(); i++) {
                Interval current = sorted.get(i);
                if (previous.end >= current.start) {
                    Interval toMerge = new Interval(previous.start, sorted.get(i).end);
                    merged.add(toMerge);
                    previous = toMerge;
                } else {
                    //merged.add(previous);
                    previous = current;
                }
            }
            for (int i = 0; i < merged.size(); i++) {
                System.out.println(merged.get(i).start + " " + merged.get(i).end);
            }
            return merged;
        }

    }
}

class Interval {
    int start;
    int end;
    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

class IntervalComparator implements Comparator<Interval> {

    @Override
    public int compare(Interval o1, Interval o2) {
        return o1.start - o2.start;
    }

    @Override
    public boolean equals(Object obj) {
        return false;
    }
}