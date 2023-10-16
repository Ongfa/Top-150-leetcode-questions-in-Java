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
    public static void merge(int[] firstArray, int m, int[] secondArray, int n) {
        int pointer1 = m - 1, pointer2 = n - 1, i = firstArray.length - 1;
        while (pointer1 >= 0 && pointer2 >= 0) {
            if(firstArray[pointer1] > secondArray[pointer2]) {
                firstArray[i--] = firstArray[pointer1--];
            } else {
                firstArray[i--] = secondArray[pointer2--];
            }
        }
        while(pointer2 >= 0) {
            firstArray[i--] = secondArray[pointer2--];
        }
        for (int j = 0; j < firstArray.length; j++) {
            System.out.println(firstArray[j] + "\n");
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter size of first sorted array: ");
        int m = s.nextInt();
        System.out.println("Enter size of second sorted array: ");
        int n = s.nextInt();
        System.out.println("Enter the elements of first sorted array: ");
        int firstArray[] = new int[m + n];
        int i = 0;
        for(; i < m;i++) {
            firstArray[i] = s.nextInt();
        }
        for(; i < m + n;i++) {
            firstArray[i] = 0;
        }
        System.out.println("Enter the elements for second sorted array: ");
        int secondArray[] = new int[n];
        if (n > 0) {
            for (int j = 0; j < n; j++) {
                secondArray[j] = s.nextInt();
            }
        } else {
            System.out.println("ERROR: Second sorted array cannot be null");
            return;
        }
        System.out.println("The merged sorted array is: ");
        merge(firstArray, m, secondArray, n);
    }
}
