class Solution {
    public int minimumOperationsToWriteY(int[][] grid) {
        
        int n = grid.length;
        
        int[] y = new int[3];
        int[] tot= new int[3];
        for(int i=0;i<n/2;i++)
        {
            
                y[grid[i][i]]++;
                y[grid[i][n-i-1]]++; 
        }
        
        for(int i= n/2;i<n;i++)
        {
            y[grid[i][n/2]]++;
        }
        
        
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                tot[grid[i][j]]++;
            }
        }
        for(int i=0;i<3;i++)
        {
            tot[i] -= y[i];
        }
        
        //System.out.println(Arrays.toString(tot) + " " + Arrays.toString(y));
        
        int ans = Integer.MAX_VALUE;
       
        for(int i=0;i<3;i++)
        {
            int curr = tot[i];
            int mini = Integer.MAX_VALUE;
            for(int j=0;j<3;j++)
            {
                if(i != j)
                {
                    curr += y[j];
                    mini = Math.min(mini, tot[j]);
                }
            }
            curr += mini;
            ans = Math.min(ans, curr);
        }
        return ans;
        
    }
}