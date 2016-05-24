package JavaRevisited;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.*;
import java.io.*;
import java.net.*;

/**
 * Created by Jilliankim on 11/17/15.
 *
 * Description: Check if two strings are anagrams
 *
 * solution: either mapping each character in alphabet to 26 unique prime numbers
 * or hashmap
 */
public class Anagram {

    private static Map<String,List<String>> anagramsMap = new HashMap<>(100);
    public static void main(String[] args) {
        String[] input = {
                "akka", "akak", "baab", "baba", "bbaa"
        };

        for (String s: input) {
            char[] word = s.toCharArray();
            Arrays.sort(word);
            String key = String.valueOf(word);
            if (!anagramsMap.containsKey(key)) {
                anagramsMap.put(key, new ArrayList < String > ());
            }

            anagramsMap.get(key).add(s);
        }

        System.out.println("anagramsMap = " + anagramsMap);

    }

    public List<String> anagrams(String[] strs) {
        ArrayList<String> result = new ArrayList<String>();
        if (strs == null || strs.length == 0)
            return result;
        HashMap<String, ArrayList<Integer>> map = new HashMap<String, ArrayList<Integer>>();
        for (int i = 0; i < strs.length; i++) {
            char[] arr = strs[i].toCharArray();
            Arrays.sort(arr);
            String t = String.valueOf(arr);
            if (map.get(t) == null) {
                ArrayList<Integer> l = new ArrayList<Integer>();
                l.add(i);
                map.put(t, l);
            } else {
                map.get(t).add(i);
            }
        }
        for (ArrayList<Integer> l : map.values()) {
            if (l.size() > 1) {
                for (Integer i : l) {
                    result.add(strs[i]);
                }
            }
        }
        return result;
    }

}
