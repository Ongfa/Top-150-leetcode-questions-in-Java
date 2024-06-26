import java.util.Scanner;

/**
 * Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
 *
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 *
 * You must write an algorithm that runs in O(n) time and without using the division operation.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,4]
 * Output: [24,12,8,6]
 *
 * Example 2:
 *
 * Input: nums = [-1,1,0,-3,3]
 * Output: [0,0,9,0,0]
 *
 *
 *
 * Constraints:
 *
 *     2 <= nums.length <= 105
 *     -30 <= nums[i] <= 30
 *     The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 *
 *
 *
 * Follow up: Can you solve the problem in O(1) extra space complexity? (The output array does not count as extra space for space complexity analysis.)
 */

public class productArrayExceptSelf {
    public static int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] productList = new int[len];
        productList[0] = 1;
        for(int i = 1;i < len; i++) {
            productList[i] = productList[i - 1] * nums[i - 1];
        }
        int right = 1;
        for(int i = len - 1; i >= 0; i--) {
            productList[i] *= right;
            right *= nums[i];
        }
        return productList;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of array: ");
        int len = sc.nextInt();
        System.out.println("Enter the elements: ");
        int[] nums = new int[len];
        for (int i = 0;i < len;i++) {
            nums[i] = sc.nextInt();
        }
        int[] productArray = productExceptSelf(nums);
        for (int j : productArray) {
            System.out.printf("%d\t", j);
        }
    }
}
