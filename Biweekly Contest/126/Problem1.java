class Solution {
    public int sumOfEncryptedInt(int[] nums) {
        
        int n = nums.length;
        int ans = 0;
        for(int i=0;i<n;i++)
        {
            int temp = nums[i];
            int maxi = 0;
            int ct = 0;
            while(temp > 0)
            {
                int dig = temp % 10;
                maxi = Math.max(maxi, dig);
                temp = temp/10;
                ct++;
            }
            int num = 0;
            while(ct > 0)
            {
                num += maxi * (int)Math.pow(10, ct-1);
                ct--;
                
            }
            ans+= num;
        }
        
        return ans;
        
        
    }
}