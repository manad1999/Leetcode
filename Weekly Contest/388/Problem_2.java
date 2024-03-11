class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        
        int n = happiness.length;
        Arrays.sort(happiness);
        int rm = 0;
        long ans = 0;
        for(int i=n-1;i>=n-k;i--)
        {
            long val = Math.max(0, happiness[i] - rm);
            ans += (val);
            rm++;
        }
        return ans;
        
    }
}