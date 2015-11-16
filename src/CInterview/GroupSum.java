package CInterview;

/**
 * Created by Jilliankim on 10/25/15.
 */
public class GroupSum {

    public static void main(String[] args) {
        int nums[] = new int[3];
        nums[0] = 5;
        nums[1] = 6;
        nums[2] = 2;
        System.out.println(groupSum6(0, nums, 7));

        System.out.println(groupSum0(0, nums, 7));
    }

    /*
    * cases to consider
    * 1. what if int[] nums are too long? (like too many elements in the array)
    * 2. what if the target number is negative?
    * in case of groupSum6(1, {6, 4, 5}, 9) -> true because the position of the index should override
    * */

    //sum is always going to be nums[index] to nums[nums.length] == target
    public static boolean groupSum6(int index, int[] nums, int target) {
        //array is shorter than the given index
        if (index >= nums.length) {
            return target == 0;
        }

        if (groupSum6(index+1, nums, target-nums[index])) {
            return true;
        }
        if (nums[index] != 6 && groupSum6(index+1, nums, target)) {
            return true;
        }
        return false;
    }

    public static boolean groupSum0(int index, int[] nums, int target) {
        if (index >= nums.length) {
            return target == 0;
        }
        if (nums[index] == 6) {
            return groupSum0(index + 1, nums, target - 6);
        } else {
            return groupSum0(index + 1, nums, target - nums[index]) || groupSum0(index + 1, nums, target);
        }
    }
}
