class Solution {
    public String minimizeStringValue(String s) {
        
        int n = s.length();
        char[] ch = s.toCharArray();
        
        int[] freq = new int[26];
        
        for(int i=0;i<n;i++)
        {
            char c = ch[i];
            if(c != '?')
                freq[c-'a']++;
        }
        List<Integer> ls = new ArrayList<>();
        for(int i=n-1;i>=0;i--)
        {
            if(ch[i] == '?')
            {
                int mini = Integer.MAX_VALUE;
                int ind = -1;
                for(int j=0;j<26;j++)
                {
                    if(mini > freq[j])
                    {
                        mini = freq[j];
                        ind = j;
                    }
                }
                
                //ch[i] = (char)(ind+'a');
                ls.add(ind);
                freq[ind]++;
            }
        }
        
        Collections.sort(ls);
        int ind = 0;
        for(int i=0;i<n;i++)
        {
            if(ch[i] == '?')
            {
                ch[i] = (char)(ls.get(ind++)+'a');
            }
        }
        
        return new String(ch);
        
        
        
    }
}