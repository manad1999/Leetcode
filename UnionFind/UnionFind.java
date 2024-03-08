class UnionFind
{
    int[] par;
    int[] rank;
    public UnionFind(int n)
    {
        rank = new int[n];
        par = new int[n];
        for(int i=0;i<n;i++)
        {
            par[i] = i;
        }
    }

    public int findpar(int x)
    {
        if(par[x] == x)
        {
            return x;
        }
        par[x] = findpar(par[x]);
        return par[x];
    }

    public boolean union(int x, int y)
    {
        int par_x = findpar(x), par_y = findpar(y);

        if(par_x == par_y)
        {
            return false;
        }
        if(rank[par_x] >= rank[par_y])
        {
            par[par_y] = par_x;
            rank[par_x]++;
        }
        else if(rank[par_x] < rank[par_y])
        {
            par[par_x] = par_y;
        }
        return true;
    }
}