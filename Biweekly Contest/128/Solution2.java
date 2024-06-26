class Solution {
    public int minRectanglesToCoverPoints(int[][] points, int w) {
        
        Arrays.sort(points, (a, b)-> (a[0]-b[0]));
        int n = points.length;
        int ans = 0;
        int ind = 0;
        while(ind < n)
        {
            int temp = ind+1;
            int lim = points[ind][0] + w;
            while(temp<n && points[temp][0] <= lim)
            {
                temp++;
            }
            ans++;
            ind = temp;
        }
        return ans;
    }
}Hello
