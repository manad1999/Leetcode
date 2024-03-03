class Solution {
    public int[] resultArray(int[] nums) {
        
        int n = nums.length;
        List<Integer> ls1 = new ArrayList<>();
        List<Integer> ls2 = new ArrayList<>();
        ls1.add(nums[0]);
        ls2.add(nums[1]);
        int[] ans = new int[n];
        for(int i=2;i<n;i++)
        {
            if(ls1.get(ls1.size()-1) > ls2.get(ls2.size()-1))
            {
                ls1.add(nums[i]);
            }
            else
            {
                ls2.add(nums[i]);
            }
        }
        int ind = 0;
        for(int i=0;i<ls1.size();i++)
        {
            ans[ind++] = ls1.get(i);
        }
        for(int i=0;i<ls2.size();i++)
        {
            ans[ind++] = ls2.get(i);
        }
        return ans;
        
    }
}