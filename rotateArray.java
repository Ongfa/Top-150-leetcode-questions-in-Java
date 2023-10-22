/**
 * Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,4,5,6,7], k = 3
 * Output: [5,6,7,1,2,3,4]
 * Explanation:
 * rotate 1 steps to the right: [7,1,2,3,4,5,6]
 * rotate 2 steps to the right: [6,7,1,2,3,4,5]
 * rotate 3 steps to the right: [5,6,7,1,2,3,4]
 *
 * Example 2:
 *
 * Input: nums = [-1,-100,3,99], k = 2
 * Output: [3,99,-1,-100]
 * Explanation:
 * rotate 1 steps to the right: [99,-1,-100,3]
 * rotate 2 steps to the right: [3,99,-1,-100]
 *
 *
 *
 * Constraints:
 *
 *     1 <= nums.length <= 105
 *     -231 <= nums[i] <= 231 - 1
 *     0 <= k <= 105
 *
 *
 *
 * Follow up:
 *
 *     Try to come up with as many solutions as you can. There are at least three different ways to solve this problem.
 *     Could you do it in-place with O(1) extra space?
 */

import java.util.Scanner;

public class rotateArray {

    public static void reverse(int nums[], int i, int j) {
        int leftIndex = i;
        int rightIndex = j;

        while(leftIndex < rightIndex) {
            int temp = nums[leftIndex];
            nums[leftIndex] = nums[rightIndex];
            nums[rightIndex] = temp;

            leftIndex++;
            rightIndex--;
        }
    }
    public static void rotate(int[] nums, int k) {
        k = k % nums.length;
        if (k < 0) {
            k += nums.length;
        }
        reverse(nums, 0, nums.length - k - 1);
        reverse(nums, nums.length - k, nums.length - 1);
        reverse(nums, 0, nums.length - 1);
        System.out.println("The rotated array is: ");
        for (int i = 0;i < nums.length;i++) {
            System.out.printf("%d\t", nums[i]);
        }
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the size of array");
        int n = s.nextInt();
        int[] nums = new int[n];
        System.out.println("Enter the elements of an array: ");
        for (int i = 0; i < n;i++) {
            nums[i] = s.nextInt();
        }
        System.out.println("Enter k: ");
        int k = s.nextInt();
        rotate(nums, k);
    }
}
