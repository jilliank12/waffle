package CodingInterview;

/**
 * Created by Jilliankim on 11/19/15.
 */
public class RotateArray {

    public static void main(String[] args) {
        int[] num;
        num = new int[] {1, 2, 3, 4, 5, 6, 7};

        rotate(num, 3);

        for (int i = 0; i < num.length; i++) {
            System.out.print(num[i] + " ");
        }

    }

    public static void rotate(int[] arr, int order) {
        order = order % arr.length;

        if (arr == null || order < 0) {
            throw new IllegalArgumentException("Illegal Argument");
        }

        int a = arr.length - order;
        reverse(arr, 0, a-1);
        reverse(arr, a, arr.length - 1);
        reverse(arr, 0, arr.length - 1);

    }

    public static void reverse(int[] arr, int left, int right) {
        if (arr == null || arr.length == 1) return;
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }

}
