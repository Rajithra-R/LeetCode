// space optimization

class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n == 0) return 0;
        
        // Arrays should be of size [2][3] to accommodate cap values 0, 1, and 2
        int[][] cur = new int[2][3]; 
        int[][] after = new int[2][3];

        for(int i = n - 1; i >= 0; i--) {
            for(int buy = 0; buy <= 1; buy++) {
                for(int cap = 1; cap <= 2; cap++) { // Cap starts from 1 to 2
                    if (buy == 1) { // Buy case
                        cur[buy][cap] = Math.max(-prices[i] + after[0][cap], 0 + after[1][cap]);
                    } else { // Sell case
                        cur[buy][cap] = Math.max(prices[i] + after[1][cap - 1], 0 + after[0][cap]);
                    }
                }
            }
            // Copy cur into after
            for (int buy = 0; buy <= 1; buy++) {
                for (int cap = 0; cap <= 2; cap++) {
                    after[buy][cap] = cur[buy][cap];
                }
            }
        }
        return after[1][2]; 
    }
}
// 1 - buy
// 0 - dont buy

//Tabulation
/*
for(int i=n-1;i>=0;i--)
        {
            for(int buy=0;buy<2;buy++)
            {
                for(int cap=1;cap<3;cap++)
                {
                    if(buy == 1) // buy
                    {
                        dp[i][buy][cap] = Math.max(-prices[i] + dp[i+1][0][cap] , 0 + dp[i+1][1][cap]);
                    }
                    else  // sell
                    {
                        dp[i][buy][cap] = Math.max(prices[i] + dp[i+1][1][cap-1] , 0 + dp[i+1][0][cap]);  // since cap val is decreasing start from 1
                    }
                }
            }
        }
        return dp[0][1][2];
*/