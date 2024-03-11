class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        
        Arrays.sort(capacity);
        int n = apple.length;
        int m = capacity.length;
        int sum =0;
        for(int i=0;i<n;i++)
        {
            sum+= apple[i];
        }
        int ct = 0;
        for(int i= m-1;i>=0;i--)
        {
            sum -= capacity[i];
            ct++;
            if(sum <= 0)
            {
                return ct;
            }
        }
        return ct;
        
    }
}