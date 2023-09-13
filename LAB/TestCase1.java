package LAB;
import java.util.*;

public class TestCase1 {

            public int maxProfit(int[] prices) {
                if (prices == null || prices.length < 2) {
                    return 0; // Not enough prices to make a profit
                }

                int minPrice = prices[0]; // Initialize the minimum price as the first day's price
                int maxProfit = 0; // Initialize the maximum profit as 0

                for (int i = 1; i < prices.length; i++) {
                    // Check if the current price allows for a higher profit
                    if (prices[i] > minPrice) {
                        int potentialProfit = prices[i] - minPrice;
                        maxProfit = Math.max(maxProfit, potentialProfit);
                    } else {
                        // Update the minimum price to the current day's price
                        minPrice = prices[i];
                    }
                }

                return maxProfit;
            }

            public static void main(String[] args) {
                TestCase1 solution = new  TestCase1();
                int[] prices = {7, 1, 5, 3, 6, 4};
                int maxProfit = solution.maxProfit(prices);
                System.out.println("Max Profit: " + maxProfit);
            }
        }


