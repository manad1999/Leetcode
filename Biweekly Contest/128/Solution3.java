class Solution {
    public int[] minimumTime(int n, int[][] edges, int[] disappear) {
        
        List<List<int[]>> adj = new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        for(int i=0;i<edges.length;i++)
        {
            int u = edges[i][0], v = edges[i][1], cost = edges[i][2];
            adj.get(u).add(new int[]{v, cost});
            adj.get(v).add(new int[]{u, cost});
            
        }
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> (a[1] - b[1]));
        pq.add(new int[]{0, 0});
        dist[0] = 0;
        while(!pq.isEmpty())
        {
            int[] poll = pq.poll();
            if(poll[1] > dist[poll[0]])
            {
                continue;
            }
            for(int[] temp : adj.get(poll[0]))
            {
                if(dist[poll[0]] + temp[1] < dist[temp[0]] && disappear[temp[0]] > dist[poll[0]] + temp[1])
                {
                    dist[temp[0]] = dist[poll[0]] + temp[1];
                    pq.add(new int[]{temp[0], dist[temp[0]]});
                }
            }
        }
        

        for(int i=0;i<n;i++)
        {
            if(dist[i] == Integer.MAX_VALUE)
            {
                dist[i] = -1;
            }
        }
        return dist;
    }
}