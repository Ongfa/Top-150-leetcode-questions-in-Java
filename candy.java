import java.util.Arrays;
import java.util.Scanner;

/**
 * There are n children standing in a line. Each child is assigned a rating value given in the integer array ratings.
 *
 * You are giving candies to these children subjected to the following requirements:
 *
 *     Each child must have at least one candy.
 *     Children with a higher rating get more candies than their neighbors.
 *
 * Return the minimum number of candies you need to have to distribute the candies to the children.
 *
 *
 *
 * Example 1:
 *
 * Input: ratings = [1,0,2]
 * Output: 5
 * Explanation: You can allocate to the first, second and third child with 2, 1, 2 candies respectively.
 *
 * Example 2:
 *
 * Input: ratings = [1,2,2]
 * Output: 4
 * Explanation: You can allocate to the first, second and third child with 1, 2, 1 candies respectively.
 * The third child gets 1 candy because it satisfies the above two conditions.
 *
 *
 *
 * Constraints:
 *
 *     n == ratings.length
 *     1 <= n <= 2 * 104
 *     0 <= ratings[i] <= 2 * 104
 */
public class candy {
    public static int getCandy(int[] ratings) {
        int n = ratings.length;
        int totalCandies = 0;
        int[] leftRating = new int[n];
        Arrays.fill(leftRating, 1);
        for (int i = 1;i < n;i++) {
            if (ratings[i] > ratings[i - 1]) leftRating[i] = leftRating[i - 1] + 1;
        }
        int[] rightRating = new int[n];
        Arrays.fill(rightRating, 1);
        for (int i = n - 2;i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) rightRating[i] = rightRating[i + 1] + 1;
        }

        for (int i = 0;i < n;i++) {
            totalCandies += Math.max(leftRating[i], rightRating[i]);
        }

        return totalCandies;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the no. of ratings: ");
        int n = sc.nextInt();
        System.out.println("Enter the ratings: ");
        int[] ratings = new int[n];
        for (int i = 0;i < n ;i++){
            ratings[i] = sc.nextInt();
        }
        int totalCandies = getCandy(ratings);
        System.out.printf("Total candies %d\n", totalCandies);
    }
}
