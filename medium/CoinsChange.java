/**
You are given coins of different denominations and a total amount of money amount. Write a function to compute the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

Example 1:
coins = [1, 2, 5], amount = 11
return 3 (11 = 5 + 5 + 1)

Example 2:
coins = [2], amount = 3
return -1.

Note:
You may assume that you have an infinite number of each kind of coin.
*/

public int coinChange(int[] coins, int amount) {
    if ((coins == null || coins.length == 0) && amount != 0)
        return -1;
    if (amount == 0)
        return 0;
    if (coins.length == 1 && (coins[0] > amount || amount % coins[0] != 0))
        return -1;

    int[] minNumberCoins = new int[amount + 1];
    int N = coins.length;
    minNumberCoins[0] = 0;

    for (int m = 1; m <= amount; m++) {
        minNumberCoins[m] = Integer.MAX_VALUE;
        for (int coin : coins) {
            if (m >= coin && minNumberCoins[m - coin] != Integer.MAX_VALUE) {
                int numCoins = minNumberCoins[m - coin] + 1;
                minNumberCoins[m] = Math.min(numCoins, minNumberCoins[m]);
            }
        }
    }

    if (minNumberCoins[amount] == Integer.MAX_VALUE)
        return -1;
    return minNumberCoins[amount];
}
