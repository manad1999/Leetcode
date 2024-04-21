class Solution {
    public boolean[] findAnswer(int n, int[][] edges) {
        
        List<List<int[]>> adj = new ArrayList<>();
        List<Set<Integer>> par = new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            adj.add(new ArrayList<>());
            par.add(new HashSet<>());
        }
        for(int i=0;i<edges.length;i++)
        {
            int u = edges[i][0], v = edges[i][1], cost = edges[i][2];
            
            adj.get(u).add(new int[]{v, cost});
            adj.get(v).add(new int[]{u,cost});
        }
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[1] - b[1]));
        pq.add(new int[]{0,0});
        while(!pq.isEmpty())
        {
            int[] polled = pq.poll();
            if(dist[polled[0]] < polled[1])
                continue;
            
            for(int[]  v :adj.get(polled[0]))
            {
                if(dist[polled[0]] + v[1] < dist[v[0]])
                {
                    par.get(v[0]).clear();
                    par.get(v[0]).add(polled[0]);
                    dist[v[0]] = dist[polled[0]] + v[1];
                    pq.add(new int[]{v[0], dist[v[0]]});
                }
                else if(dist[polled[0]] + v[1] == dist[v[0]])
                {
                    par.get(v[0]).add(polled[0]);
                }
            }
        }
        
        Set<String> good = new HashSet<>();
        
        Queue<Integer> q = new LinkedList<>();
        q.add(n-1);
        
        while(!q.isEmpty())
        {
            int polled = q.poll();
            for(Integer parent : par.get(polled))
            {
                good.add(polled+","+parent);
                q.add(parent);
            }
        }
        boolean ans[] = new boolean[edges.length];
        
        for(int i=0;i<edges.length;i++)
        {
            int u = edges[i][0], v = edges[i][1];
            if(good.contains(u+","+v) || good.contains(v+","+u)) //par.get(u).contains(v) || par.get(v).contains(u)
            {
                ans[i] = true;
            }
        }
        return ans;
        
        
    }
}