class Solution {
    public int minOperations(int[] nums, int k) {
        
        Arrays.sort(nums);
        int n = nums.length;
        for(int i=0;i<n;i++)
        {
            if(nums[i] < k)
            {
                continue;
            }
            else
            {
                return i;
            }
        }
        
        return n;
        
    }
}