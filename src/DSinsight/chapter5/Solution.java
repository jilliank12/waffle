package DSinsight.chapter5;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by Jilliankim on 11/4/15.
 */
public class Solution {
    public static void main(String[] args) {

        ArrayList<String> strings = new ArrayList<String>();
        strings.add("Hello, World!");
        strings.add("Welcome to CoderPad.");
        strings.add("This pad is running Java 8.");

        for (String string : strings) {
            System.out.println(string);
        }

        Queue queue = new LinkedList<String>();
        queue.add("new queue");
        queue.add("add1");
        queue.add("add2");

        for (int i = 0; i < queue.size(); i++) {
            System.out.println(queue.poll());
        }


        Stack stack = new Stack();

    }
}
