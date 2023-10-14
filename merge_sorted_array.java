/**
 * Problem description
 * You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n, representing the number of elements in nums1 and nums2 respectively.
 *
 * Merge nums1 and nums2 into a single array sorted in non-decreasing order.
 *
 * The final sorted array should not be returned by the function, but instead be stored inside the array nums1. To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged, and the last n elements are set to 0 and should be ignored. nums2 has a length of n.
 *
 *
 *
 * Example 1:
 *
 * Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * Output: [1,2,2,3,5,6]
 * Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
 * The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.
 *
 * Example 2:
 *
 * Input: nums1 = [1], m = 1, nums2 = [], n = 0
 * Output: [1]
 * Explanation: The arrays we are merging are [1] and [].
 * The result of the merge is [1].
 *
 * Example 3:
 *
 * Input: nums1 = [0], m = 0, nums2 = [1], n = 1
 * Output: [1]
 * Explanation: The arrays we are merging are [] and [1].
 * The result of the merge is [1].
 * Note that because m = 0, there are no elements in nums1. The 0 is only there to ensure the merge result can fit in nums1.
 *
 *
 *
 * Constraints:
 *
 *     nums1.length == m + n
 *     nums2.length == n
 *     0 <= m, n <= 200
 *     1 <= m + n <= 200
 *     -109 <= nums1[i], nums2[j] <= 109
 */

import java.util.Scanner;
public class merge_sorted_array {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1, p2 = n - 1, i = nums1.length - 1;
        while (p1 >= 0 && p2 >= 0) {
            if(nums1[p1] > nums2[p2]) {
                nums1[i--] = nums1[p1--];
            } else {
                nums1[i--] = nums2[p2--];
            }
        }
        while(p2 >= 0) {
            nums1[i--] = nums2[p2--];
        }
        for (int j = 0; j < nums1.length; j++) {
            System.out.println(nums1[j] + "\n");
        }
        return;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter size of nums1: ");
        int m = s.nextInt();
        System.out.println("Enter size of nums2: ");
        int n = s.nextInt();
        System.out.println("Enter the sorted array nums1: ");
        int nums1[] = new int[m + n];
        int i = 0;
        for(; i < m;i++) {
            nums1[i] = s.nextInt();
        }
        for(; i < m + n;i++) {
            nums1[i] = 0;
        }
        System.out.println("Enter the sorted array nums2: ");
        int nums2[] = new int[n];
        for (int j = 0; j < n; j++) {
            nums2[j] = s.nextInt();
        }
        System.out.println("The merged sorted array is: ");
        merge(nums1, m, nums2, n);
    }
}