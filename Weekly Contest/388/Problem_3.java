class Solution {
    public String[] shortestSubstrings(String[] arr) {
        
        int n = arr.length;
        String[] ans = new String[n];
        for(int i=0;i<n;i++)
        {
            int st = 1, end = arr[i].length();
            String res = "";
            while(st <= end)
            {
                int mid = st + (end-st)/2;
                String temp = check(arr, i, mid);
                if(!temp.equals(""))
                {
                    res = temp;
                    end = mid-1;
                }
                else
                {
                    st = mid+1;
                }
            }
            
            ans[i] = res;
        }
        
        return ans;
    }
    
    public String check(String[] arr,int ind, int len)
    {
        int n = arr.length;
        int st = 0;
        String res = "";
        for(int end=0;end<arr[ind].length();end++)
        {
            if(end-st+1 == len)
            {
                String temp = arr[ind].substring(st, end+1);
                boolean flag = true;
                for(int i=0;i<n;i++)
                {
                    if(i != ind)
                    {
                        if(arr[i].contains(temp))
                        {
                            flag = false;
                            break;
                        }
                    }
                }
                if(flag)
                {
                    if(res == "" || res.compareTo(temp) > 0)
                    {
                        res = temp;
                    }
                }
                st++;
            }
        }
        
        return res;
        
    }
}