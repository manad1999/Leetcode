class Solution {
    public int minimumLevels(int[] nums) {
        
        int n = nums.length;
        
        int pre[] = new int[n];
        int sum = 0;
        
        for(int i=0;i<n;i++)
        {
            pre[i] = sum + (nums[i] == 0 ? -1 : 1);
            sum = pre[i];
        }
        
        for(int i=0;i<n-1;i++)
        {
            int d = pre[i];
            int other = pre[n-1] - pre[i];
            
            if(d > other)
            {
                return i+1;
            }
        }
        
        return -1;
        
    }
}