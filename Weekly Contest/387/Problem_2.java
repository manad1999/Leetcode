class Solution {
    public int countSubmatrices(int[][] grid, int k) {
        
        int m = grid.length, n = grid[0].length;
        int[][] pre = new int[m][n];
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                pre[i][j] = (j-1 >= 0 ? pre[i][j-1] : 0) + grid[i][j];
            }
        }
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                pre[i][j] = (i-1 >= 0 ? pre[i-1][j] : 0) + pre[i][j];
            }
        }
        int ans = 0;
        for(int i=0;i<m;i++)
        {
           for(int j=0;j<n;j++)
           {
               if(pre[i][j] <=k)
               {
                   ans++;
               }
           }
        }
        return ans;
    }
}