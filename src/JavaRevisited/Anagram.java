package JavaRevisited;

/**
 * Created by Jilliankim on 11/17/15.
 *
 * Description: Check if two strings are anagrams
 *
 * solution: either mapping each character in alphabet to 26 unique prime numbers
 * or hashmap
 */
public class Anagram {

    public static void main(String[] args) {

    }

    public static boolean isAnagram(String str1, String str2) {
        //if lengths are different return false
        if (str1.length() != str2.length()) return false;
        else if (str1.length() == 0 || str2.length() == 0) return false;
        else {


        }
        return true;
    }
}
