package JavaRevisited;

/**
 * Created by Jilliankim on 11/16/15.
 *
 * Description: Palindrome are those String whose reverse is equal to original.
 * This can be done by using either StringBuffer reverse() method or by technique demonstrated in the solution here.
 */
public class IsPalindrome {

    public static void main(String[] args) {

        String test = "palindrome";
        String test1 = "andna";

        System.out.println(isPalindrome(test));
        System.out.println(isPalindrome(test1));

    }

    //what if the string has spaces? -> split
    //what if the string has a number? -> obviously false
    public static boolean isPalindrome(String input) {
        //if the length is 0 return false
        if (input.length() == 0) return false;
        else {
            int size = input.length();
            for (int i = 0; i < size/2; ++i) {
                if (input.charAt(i) != input.charAt(size - i - 1)) return false;
            }
        }
        return true;

    }
}
