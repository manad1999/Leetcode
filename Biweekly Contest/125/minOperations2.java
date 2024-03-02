class Solution {
    public int minOperations(int[] nums, int k) {
        
        PriorityQueue<Long> pq = new PriorityQueue<>((a, b)-> {
            if( a > b)
            {
                return 1;
            }
            else if(b > a)
            {
                return -1;
            }
            return 0;
        });
        int n = nums.length;
        for(int i=0;i<n;i++)
        {
            pq.add((long)nums[i]);
        }
        int ct = 0;
        while(pq.size() >= 2)
        {
            if(pq.peek() >= k)
            {
                return ct;
            }
            long poll1 = pq.poll();
            long poll2 = pq.poll();
            ct++;
            pq.add(poll1 * 2 + poll2);
            
        }
        
        return ct;
        
            
    }
}