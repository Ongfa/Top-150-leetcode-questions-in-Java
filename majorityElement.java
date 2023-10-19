/**
 * Given an array nums of size n, return the majority element.
 *
 * The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [3,2,3]
 * Output: 3
 *
 * Example 2:
 *
 * Input: nums = [2,2,1,1,1,2,2]
 * Output: 2
 *
 *
 *
 * Constraints:
 *
 *     n == nums.length
 *     1 <= n <= 5 * 104
 *     -109 <= nums[i] <= 109
 */

import java.util.Scanner;
public class majorityElement {

    public static int findMajorityElement(int[] nums) {
       if (nums == null || nums.length == 0) return 0;
       int count = 0, candidate = 0;
       for (int i = 0; i < nums.length;i++) {
           if (count == 0) candidate = nums[i];
           if (candidate == nums[i]) count++;
           else count--;
       }
       return candidate;
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the number of elements: ");
        int n = s.nextInt();
        int[] nums = new int[n];
        System.out.println("Enter the elements");
        for (int i = 0;i < n;i++) {
            nums[i] = s.nextInt();
        }
        int candidate = findMajorityElement(nums);
        System.out.printf("Output: %d\n", candidate);
    }
}
