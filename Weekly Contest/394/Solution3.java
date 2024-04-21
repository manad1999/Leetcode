class Solution {
    public int minimumOperations(int[][] grid) {
        
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[n][11];
        for(int i=0;i<n;i++)
        {
            Arrays.fill(dp[i],-1);
        }
        return recur(0, -1, grid, dp);
    }
    
    
    public int recur(int ind, int prev, int[][] grid, int[][] dp)
    {
        if(ind == grid[0].length)
        {
            return 0;
        }
        
        if(dp[ind][prev+1] != -1)
        {
            return dp[ind][prev+1];
        }
        int sz = grid.length;
        int[] freq = new int[10];
        for(int i=0;i<sz;i++)
        {
            freq[grid[i][ind]]++;
        }
        int ans = Integer.MAX_VALUE;
        for(int i=0;i<10;i++)
        {
            if(prev != i)
            {
                ans = Math.min(ans,(sz - freq[i]) + recur(ind+1, i, grid, dp));    
            }
            
        }
        
        return dp[ind][prev+1] = ans;
    }
}