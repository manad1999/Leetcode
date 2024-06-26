class Solution {
    public long numberOfSubarrays(int[] nums) {
        int n = nums.length;
        Stack<Integer> st = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();
        long ans = n;
        for(int i=0;i<n;i++)
        {
            int num = nums[i];
            while(!st.isEmpty() && st.peek() < num)
            {
                int val = st.pop();
                map.put(val, map.get(val)-1);
                if(map.get(val) == 0)
                    map.remove(val);
            }
            if(map.containsKey(num))
                ans += map.get(num);
            st.add(num);
            map.put(num, map.getOrDefault(num, 0)+1);
        }

        return ans;

        
    }
}