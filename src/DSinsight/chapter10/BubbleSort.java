package DSinsight.chapter10;

/**
 * Created by Jilliankim on 11/3/15.
 */
public class BubbleSort {

    void bubbleSort(int a[], int n) {
        for (int pass = n - 1; pass >= 0; pass--) {
            for (int i = 0; i < pass -1; i++) {
                if(a[i] > a[i+1]) {
                    int temp = a[i];
                    a[i] = a[i+1];
                    a[i+1] = temp;
                }
            }
        }
    }

    void bubbleSortImproved(int a[], int n) {
        int swapped = 1;
//        for (int pass = n -1; pass >= 0 && swapped; pass--) {
//
//        }
    }
}
