package CodingInterview;

import java.util.*;

/**
 * Created by Jilliankim on 11/20/15.
 *
 * Comment: I was really confused with the term "inner join" because I was thinking A^B, instead of A U B,
 * more like {1, 2, 7} for the output.
 *
 * I don't think this is much of a help from this morning..
 * The printing out values doesn't work for right now (but I gotta run for work!).
 * But definitely thank you for your time for the interview!
 *
 */
public class FindDuplicates {

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 5, 7, 1, 2, 1};
        int[] b = {1, 2, 1, 8, 2, 7};
        //expected output is 1 1 2 2 7 1 1 2 2 1 1 because if your pointer is at a[0], it searches for items in b
        // (or the order doesn't matter)

        join(a, b);
        //when I print out, I get
        //1 2
        //2 2
        //these are just counting occurrences in array a, but I actually want to count like this
        //1 2, 2 2, 3 1, 5 1, 7 1
        //and then when I go through b, if set.getValue() > 0 print out if (set.getKey(i) == b[i]) then print out b[i] set.containsKey(i).getValue() times
        //so at b[0] = 1, but my map will have <1, 2> so print out 1 twice


    }

    public static void join(int[] a, int []b) {

        //if arrays are both empty
        if (a.length == 0 || b.length == 0) return;

        Map<Integer, Integer> findDuplicate = new HashMap<>();

        for (int i : b) {
            Integer count = findDuplicate.get(i);
            if (count == null) {
                findDuplicate.put(i, 1);
            } else {
                findDuplicate.put(i, count + 1);
            }
        }

        for (int value : a) {
            Integer count = findDuplicate.get(value);
            if (count != null) {
                for (int i = 0; i < count; i++) {
                    System.out.print(value + " ");
                }
            }
        }
    }


}
