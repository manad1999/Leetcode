class Pair
{
    int v, cost;
    Pair(int v, int cost)
    {
        this.v = v;
        this.cost = cost;
    }
}
class Solution {
    public int[] countPairsOfConnectableServers(int[][] edges, int signalSpeed) {
        
        int n = edges.length+1;
        
        List<List<Pair>> adj = new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++)
        {
            int u = edges[i][0];
            int v = edges[i][1];
            int cost = edges[i][2];
            
            adj.get(u).add(new Pair(v, cost));
            adj.get(v).add(new Pair(u, cost));
        }
        int[] ans = new int[n];
        
        for(int i=0;i<n;i++)
        {
            Queue<int[]> q = new LinkedList<>();
            
            int ct = 0;
            int[] vis = new int[n];
            vis[i] = 1;
            for(Pair p : adj.get(i))
            {
                q.add(new int[]{p.v,p.cost,ct});
                vis[p.v] = 1;
                ct++;
            }
            int[] cap = new int[ct];
            
            while(!q.isEmpty())
            {
                int sz = q.size();
                
                for(int j=0;j<sz;j++)
                {
                    int[] popped = q.poll();
                    
                    if(popped[1] % signalSpeed == 0)
                    {
                        cap[popped[2]]++;
                    }
                    
                    for(Pair p : adj.get(popped[0]))
                    {
                        if(vis[p.v] == 0)
                        {
                            q.add(new int[]{p.v, popped[1] + p.cost, popped[2]});
                            vis[p.v] = 1;
                        }
                        
                    }
                }
            }
            if(cap.length <= 1)
            {
                continue;
            }
            int tot = 0;
            for(int j=0;j<cap.length;j++)
            {
                tot += cap[j];    
            }
            
            for(int j=0;j<cap.length;j++)
            {
                ans[i] += cap[j] * (tot - cap[j]);
                tot -= cap[j];
            }
            //System.out.println(Arrays.toString(cap));
        }
        
        return ans;
    }
}