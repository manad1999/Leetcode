class Solution {
    public long[] unmarkedSumArray(int[] nums, int[][] q) {
        
        int n = nums.length;
        int[] vis = new int[n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> {
            if(a[0] == b[0])
            {
                return a[1]-b[1];
            }
            return a[0] - b[0];
        });
        
        long sum = 0;
        
        for(int i=0;i<nums.length;i++)
        {
            sum += nums[i];
            pq.add(new int[]{nums[i], i});
        }
        //System.out.println(sum);
        int m = q.length;
        long[] ans = new long[m];
        for(int i=0;i<m;i++)
        {
            int ind = q[i][0];
            int round = q[i][1];
            if(vis[ind] == 0)
            {
                sum -= nums[ind];
            }
            vis[ind] =1;
            
            while(!pq.isEmpty() && round > 0)
            {
                int[] polled = pq.poll();
                if(vis[polled[1]] == 0)
                {
                    
                    sum -= nums[polled[1]];
                    vis[polled[1]] = 1;
                }
                else
                {
                    continue;
                }
                
                round--;
            }
          ///  System.out.println(sum);
            
            ans[i] = sum;
        }
        
        return ans;
        
    }
}