package geeksforgeeks;

import java.util.*;

/**
 * Created by Jilliankim on 6/21/16.
 * Design a data structure that supports following operations in Θ(1) time.
 * insert(x): Inserts an item x to the data structure if not already present.
 * remove(x): Removes an item x from the data structure if present.
 * search(x): Searches an item x in the data structure.
 * getRandom(): Returns a random element from current set of elements
 */
public class CustomDS {
    ArrayList<Integer> list;
    Map<Integer, Integer> map;

    public CustomDS() {
        list = new ArrayList<>();
        map = new HashMap<>();
    }

    void add(int x) {
        if (map.get(x) != null) return;
        int elem = list.size();
        list.add(elem);
        map.put(x, elem);
    }

    void remove(int x) {
        Integer index = map.get(x);
        if (index == null) return;
        map.remove(x);
        int listSize = list.size();
        Collections.swap(list, index, listSize-1);
        list.remove(listSize-1);
        map.put(x, index);
    }

    int search(int x) {
        return map.get(x);
    }

    int getRandom() {
        Random rand = new Random();
        int index = rand.nextInt(list.size());
        return list.get(index);

    }
}

class Main {
    public static void main (String[] args)
    {
        CustomDS ds = new CustomDS();
        ds.add(10);
        ds.add(20);
        ds.add(30);
        ds.add(40);
        System.out.println(ds.search(30));
        ds.remove(20);
        ds.add(50);
        System.out.println(ds.search(50));
        System.out.println(ds.getRandom());
    }
}

