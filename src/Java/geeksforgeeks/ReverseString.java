package geeksforgeeks;

import java.util.Stack;

/**
 * Created by Jilliankim on 6/18/16.
 *
 * Stack | Set 3 (Reverse a string using stack)
 Given a string, reverse it using stack. For example “GeeksQuiz” should be converted to “ziuQskeeG”.
 Following is simple algorithm to reverse a string using stack.
 1) Create an empty stack.
 2) One by one push all characters of string to stack.
 3) One by one pop all characters from stack and put
 them back to string.
 Following are C and Python programs that implements above algorithm.
 */
public class ReverseString {

    public static void main(String[] args) {
        String test1 = "reverse";
        System.out.println(reverse(test1));

    }
    //implement a stack with array than Stack Object
    public static String reverse(String input) {
        char[] stack = input.toCharArray();
        char[] reversed = new char[stack.length];
        int position = stack.length - 1;
        for (int i = 0; i < stack.length; i++) {
            reversed[i] = stack[position--];
        }

        return new String(reversed);
    }
}
