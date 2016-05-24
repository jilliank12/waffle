package CodingInterview;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Jilliankim on 11/19/15.
 */
public class IsomorphicStrings {
    public static void main(String[] args) {

        String s1 = "egg";
        String t1 = "add";

        String s2 = "foo";
        String t2 = "bar";

//        System.out.println(isIsomorphic(s1, t1));
        System.out.println(isIsomorphic(s2, t2));

    }

    public static boolean isIsomorphic(String s, String t) {
        if (s == null || t == null) return false;
        if (s.length() == 0 || t.length() == 0) return true;
        if (s.length() != t.length()) return false;

        HashMap<Character, Character> map = new HashMap<Character, Character>();
        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);

            if (map.containsKey(c1)) {
                if (map.get(c1) != c2) return false;
            } else {
                if (!map.containsValue(c2)) {
                    map.put(c1, c2);
                } else return false;
            }
//            Character c = getKey(map, c2);

        }
        return true;

    }

//    public static Character getKey(HashMap<Character, Character> map, Character target) {
//        for (Map.Entry<Character, Character> entry : map.entrySet()) {
//            if (entry.getValue().equals(target)) {
//                return entry.getKey();
//            }
//        }
//        return null;
//    }
}
