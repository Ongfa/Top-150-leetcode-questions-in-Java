import java.util.Scanner;

/**
 * Given an array of integers citations where citations[i] is the number of citations a researcher received for their ith paper, return the researcher's h-index.
 *
 * According to the definition of h-index on Wikipedia: The h-index is defined as the maximum value of h such that the given researcher has published at least h papers that have each been cited at least h times.
 *
 *
 *
 * Example 1:
 *
 * Input: citations = [3,0,6,1,5]
 * Output: 3
 * Explanation: [3,0,6,1,5] means the researcher has 5 papers in total and each of them had received 3, 0, 6, 1, 5 citations respectively.
 * Since the researcher has 3 papers with at least 3 citations each and the remaining two with no more than 3 citations each, their h-index is 3.
 *
 * Example 2:
 *
 * Input: citations = [1,3,1]
 * Output: 1
 *
 *
 *
 * Constraints:
 *
 *     n == citations.length
 *     1 <= n <= 5000
 *     0 <= citations[i] <= 1000
 */
public class hIndex {
    public static int findHIndex(int[] citations) {
        int left = 0, right = citations.length;
        while (left < right) {
            int mid = (left + right + 1) / 2;
            int countCitations = 0;
            for (int i = 0; i < citations.length; i++) {
                if (citations[i] >= mid) countCitations++;
            }
            if (countCitations >= mid) left = mid;
            else right = mid - 1;
        }
        return left;
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
        int hIndex = findHIndex(nums);
        System.out.printf("The h index is: %d\n", hIndex);
    }
}
