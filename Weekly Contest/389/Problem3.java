class Solution {
    public int minimumDeletions(String word, int k) {
        
        int n = word.length();
        
        int[] freq = new int[26];
        char[] ch = word.toCharArray();
        for(int i=0;i<n;i++)
        {
            freq[ch[i]-'a']++;
        }
        
        Arrays.sort(freq);
        
        int[] pre = new int[26];
        int sum = 0;
        for(int i=0;i<26;i++)
        {
            pre[i] = sum + freq[i];
            sum = pre[i];       
        }
        int ans = Integer.MAX_VALUE;
        for(int i=0;i<26;i++)
        {
            int before = i-1 >=0 ? pre[i-1]:0;
            int ahead = 0;
            int target = freq[i] + k;
            
            int st = i+1, end = 25;
            int res = -1;
            while(st<=end)
            {
                int mid = st + (end-st)/2;
                
                if(freq[mid] > target)
                {
                    res = mid;
                    end = mid-1;
                }
                else
                {
                    st = mid+1;
                }
            }
            
            if(res != -1)
            {
                ahead = (pre[25] - pre[res-1]) - (target * (25-res+1));
            }
            
            ans = Math.min(ans, before + ahead);
        }
        
        
        return ans;
        
        
    }
}