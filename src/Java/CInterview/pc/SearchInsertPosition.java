package CInterview.pc;

/**
 * Created by Jilliankim on 6/19/16.
 */
public class SearchInsertPosition {
    //[1, 3, 5, 6], 5
    public static void main(String[] args) {
        int[] test1 = {1, 3, 5, 6};
        System.out.println(findPosition(test1, 5, 1, 6));

    }

    public static int findPosition(int[] arr, int target, int start, int end) {
        int mid = (start + end) /2;
        if (target == arr[mid]) {
            return mid;
        } else if (target<arr[mid]) {
            return start < mid ? findPosition(arr, target, start, mid-1) : start;
        } else {
            return end > mid ? findPosition(arr, target, mid+1, end) : end;
        }
    }
}
