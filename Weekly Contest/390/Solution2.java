class Solution {
    public int minOperations(int k) {
        int ans = Integer.MAX_VALUE;
        for(int i=1;i<=k;i++)
        {
            int part = (int)Math.ceil(k * (1.0) / i);

            int curr = part-1 + (i-1);
           // System.out.println(i+ " " + curr);
            ans = Math.min(curr, ans);
        }

        return ans;
        
    }
}