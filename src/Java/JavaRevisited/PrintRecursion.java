package JavaRevisited;

/**
 * Created by Jilliankim on 11/20/15.
 */
public class PrintRecursion {
    public static void main(String[] args) {
        print(5);
    }

    public static void print(int n) {
        if (n > 0) {
            for (int i = 0; i < n; i++) {
                System.out.print(n + " ");
            }
        }

    }
}
