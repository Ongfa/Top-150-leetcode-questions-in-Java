import java.util.Scanner;

/**
 * You are given an integer array nums. You are initially positioned at the array's first index, and each element in the array represents your maximum jump length at that position.
 *
 * Return true if you can reach the last index, or false otherwise.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [2,3,1,1,4]
 * Output: true
 * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
 *
 * Example 2:
 *
 * Input: nums = [3,2,1,0,4]
 * Output: false
 * Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.
 *
 *
 *
 * Constraints:
 *
 *     1 <= nums.length <= 104
 *     0 <= nums[i] <= 105
 */
public class jumpGame {
    public static boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) return false;
        if (nums.length == 1) return true;
        int reachableIndex = 0;
        for (int index = 0; index < nums.length;index++) {
            if (index > reachableIndex) return false;
            reachableIndex = Math.max(reachableIndex, index + nums[index]);
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the size of array: ");
        int n = s.nextInt();
        int[] nums = new int[n];
        System.out.println("Enter the prices of an array: ");
        for (int i = 0; i < n;i++) {
            nums[i] = s.nextInt();
        }
        boolean isReachable = canJump(nums);
        System.out.printf("The reachability of the last index is returned as: %b\n", isReachable);
    }
}
