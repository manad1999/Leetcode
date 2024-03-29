class Solution {
    public int maximumLengthSubstring(String s) {

        int n = s.length();
        char[] ch = s.toCharArray();
        int ans = 0;
        for(int i=0;i<n;i++)
        {
            int[] freq = new int[26];
            for(int j=i;j<n;j++)
            {
                freq[ch[j]-'a']++;
                boolean flag = false;
                for(int k=0;k<26;k++)
                {
                    if(freq[k] > 2)
                    {
                        flag = true;
                        break;
                    }
                }
                if(!flag)
                {
                    ans = Math.max(ans, j-i+1);
                }
                else
                {
                    break;
                }
            }
        }
        return ans;
    }
}