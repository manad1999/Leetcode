class Solution {
    int MOD = 1000_000_007;
    public int sumOfPower(int[] nums, int k) {
        
        int n = nums.length;
        int[][][] dp = new int[n][n+1][k+1];
        
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                Arrays.fill(dp[i][j], -1);
            }
        }
       return recur(0,-1,k, nums,dp); 
    }
    
    public int recur(int ind, int prev, int k, int[] nums, int[][][] dp)
    {
        if(ind == nums.length)
        {
            if(k == 0)
            {
                return (int)((ind-1 == prev ? 1 : findval( ind,  prev)) %MOD);
            }
            return 0;
        }
        if(k < 0)
        {
            return 0;
        }
        if(dp[ind][prev+1][k] != -1)
        {
            return dp[ind][prev+1][k];
        }
        
        long take = 0;
        if(prev == -1 || k - nums[ind] >=0)
        {
            take = ((long)((ind-1 == prev ? 1 : findval( ind,  prev)) % MOD) * ((long)recur(ind+1, ind, k - nums[ind], nums,dp)) % MOD ) %MOD;
        }
        long nottake = (recur(ind+1,prev, k, nums, dp)) %MOD;
        
        return dp[ind][prev+1][k] = (int)((take+ nottake) %MOD);
    }


    public long findval(int ind, int prev)
    {
        long mul = 1;
        int len = ind - prev-1;
        for(int i = 0;i<len;i++)
        {
            mul = (mul * 2) % MOD;
        }
        return  mul;
    }
}