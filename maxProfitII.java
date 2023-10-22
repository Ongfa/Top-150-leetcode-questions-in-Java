import java.util.Scanner;

/**
 * You are given an integer array prices where prices[i] is the price of a given stock on the ith day.
 *
 * On each day, you may decide to buy and/or sell the stock. You can only hold at most one share of the stock at any time. However, you can buy it then immediately sell it on the same day.
 *
 * Find and return the maximum profit you can achieve.
 *
 *
 *
 * Example 1:
 *
 * Input: prices = [7,1,5,3,6,4]
 * Output: 7
 * Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
 * Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
 * Total profit is 4 + 3 = 7.
 *
 * Example 2:
 *
 * Input: prices = [1,2,3,4,5]
 * Output: 4
 * Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
 * Total profit is 4.
 *
 * Example 3:
 *
 * Input: prices = [7,6,4,3,1]
 * Output: 0
 * Explanation: There is no way to make a positive profit, so we never buy the stock to achieve the maximum profit of 0.
 *
 *
 *
 * Constraints:
 *
 *     1 <= prices.length <= 3 * 104
 *     0 <= prices[i] <= 104
 */
public class maxProfitII {

    public static int findMaxProfitForAllStocks(int[] prices) {
        int i = 0, buyStock, sellStock, maxProfit = 0, len = prices.length - 1;
        while (i < len) {
            while (i < len && prices[i + 1] <= prices[i]) i++;
            buyStock = prices[i];

            while (i < len && prices[i + 1] > prices[i]) i++;
            sellStock = prices[i];

            maxProfit += sellStock - buyStock;
        }
        return maxProfit;
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the size of array: ");
        int n = s.nextInt();
        int[] prices = new int[n];
        System.out.println("Enter the prices of an array: ");
        for (int i = 0; i < n;i++) {
            prices[i] = s.nextInt();
        }
        int maxProfit = findMaxProfitForAllStocks(prices);
        System.out.printf("The max profit is: %d\n", maxProfit);
    }
}