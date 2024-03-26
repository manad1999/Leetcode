class Solution {
    public long[] mostFrequentIDs(int[] nums, int[] freq) {
        PriorityQueue<long[]> pq = new PriorityQueue<>((a,b) -> {
            if(a[1] > b[1])return -1;
            else if(a[1] < b[1])return 1;
            return 0;
        });
        Map<Long, Long> map = new HashMap<>();
        int n = nums.length;
        long[] ans = new long[n];
        for(int i=0;i<n;i++)
        {
            long num = nums[i];
            map.put(num , map.getOrDefault(num, 0L) + freq[i]);
            pq.add(new long[]{num, map.get(num)});
            //System.out.println(i + " " + pq + " " + map.get(pq.peek()[0]) +" " + pq.peek()[1]);
            while(!pq.isEmpty() && map.get(pq.peek()[0]) != pq.peek()[1])
            {
                pq.poll();
            }

            ans[i] = pq.peek()[1];

        }

        return ans;


    }
}