import java.util.*;
class ST
{
    int[] seg;
    public ST(int n)
    {
        seg = new int[4*n];
    }

    public void build(int ind, int low, int high, int[] arr)
    {
        if(low == high)
        {
            seg[ind] = arr[low];
            return;
        }
        int mid = (low + high) / 2;
        build(2*ind+1 ,low, mid, arr);
        build(2*ind+2, mid+1, high, arr);
        seg[ind] = seg[2*ind+1] + seg[2*ind+2];
        return;
    }
    public int query(int ind, int low, int high, int l, int r, int[] arr)
    {
        if(high < l || low > r)
        {
            return 0;
        }

        if(low >=l && high <= r)
        {
            return seg[ind];
        }
        int mid = (low + high)/2; 
        int left = query(2*ind+1, low, mid,l, r, arr);
        int right = query(2*ind+2, mid+1, high,l, r, arr);

        return left + right;
    }

    public void update(int ind, int low, int high, int index, int val)
    {
        if(low == high)
        {
            seg[ind] = val;
            return;
        }
        int mid = (low + high) / 2;
        if(index > mid)
        {
            update(2*ind+2, mid+1, high,index, val);    
        }
        else
        {
            update(2*ind+1 ,low, mid, index, val);    
        }
        seg[ind] = seg[2*ind+1] + seg[2*ind+2];
        return; 
    }

}
class SegementTree
{
    public static void main(String[] arg)
    {
        Scanner sc = new Scanner(System.in);

        int[] arr = new int[]{5,2,4,1,3,7,6,4,5};
        int n = arr.length;
        ST tree = new ST(arr.length);
        tree.build(0, 0,n-1, arr);
        System.out.println("Query: ");
        int q = sc.nextInt();
        int[][] query = new int[q][3];
        for(int i=0;i<q;i++)
        {
            System.out.println("Type: ");
            int type = sc.nextInt();

            if(type == 0)
            {
                System.out.println("Range: ");
                int l = sc.nextInt();
                int r = sc.nextInt();
                System.out.println(tree.query(0, 0, n-1, l, r, arr));
            }
            else
            {
                System.out.println("Update: ");
                int ind = sc.nextInt();
                int val = sc.nextInt();
                tree.update(0, 0, n-1, ind, val);

            }
        }
    }
}