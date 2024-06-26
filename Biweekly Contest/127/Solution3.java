class Solution {
    public int minimumSubarrayLength(int[] nums, int k) {
        int n = nums.length;
        int[] freq = new int[32];
        int st = 0;
        int ans = Integer.MAX_VALUE;
        for(int end=0;end<n;end++)
        {
            int num = nums[end];
            String str = String.format("%32s", Integer.toBinaryString(num)).replace(" ","0");
            
            for(int i = 0;i<32;i++)
            {
                if(str.charAt(i)== '1')
                {
                    freq[i]++;
                }
            }
            long val = 0;
            for(int i=31;i>=0;i--)
            {
                val = val + (freq[i] == 0 ? 0 : 1) * (long)Math.pow(2, 31-i);
            } 
            while(st<=end && val >= k)1
            {
                ans = Math.min(ans, end-st+1);
                
                String str_st = String.format("%32s", Integer.toBinaryString(nums[st])).replace(" ","0");
            
                for(int i = 0;i<32;i++)
                {
                    if(str_st.charAt(i)== '1')
                    {
                        freq[i]--;
                    }
                }
                st++;
                long temp_val = 0;
                for(int i=31;i>=0;i--)
                {
                    temp_val = temp_val + (freq[i] == 0 ? 0 : 1) * (long)Math.pow(2, 31-i);
                }
                val = temp_val;
            }
        }
         return ans == Integer.MAX_VALUE ? -1:ans;
        
    }
}