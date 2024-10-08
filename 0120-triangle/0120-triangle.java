class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int dp[][] = new int[n][n];
        for(int i=0;i<n;i++)
        {
            dp[n-1][i] = triangle.get(n-1).get(i); // fill the last row
        }
        for(int i=n-2;i>=0;i--) // from last 2nd row
        {
            for(int j=i;j>=0;j--)
            {
                int d = triangle.get(i).get(j) + dp[i+1][j];
                int p = triangle.get(i).get(j)  + dp[i+1][j+1];
                dp[i][j] = Math.min(d,p);
            }
        }
        return dp[0][0];
    }
}   