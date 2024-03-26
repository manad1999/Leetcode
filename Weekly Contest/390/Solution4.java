class Trie
{
    Trie[] links;
    char c;
    int min_len, min_ind;
    Trie(char c)
    {
        this.c = c;
        links = new Trie[26];
        min_len = Integer.MAX_VALUE;
        min_ind = -1;
    }
}
class Solution {
    public int[] stringIndices(String[] container, String[] q) {
        
        int n = container.length;
        Trie trie = new Trie('.');
        int default_min = Integer.MAX_VALUE;
        int default_ind = -1; 
        for(int i=0;i<n;i++)
        {
            char[] ch = container[i].toCharArray();
            Trie temp = trie;
            for(int j = ch.length-1;j>=0;j--)
            {
                char c = ch[j];
                if(temp.links[c-'a'] == null)
                    temp.links[c-'a'] = new Trie(c);
                if(temp.links[c-'a'].min_len > ch.length)
                {
                    temp.links[c-'a'].min_len = ch.length;
                    temp.links[c-'a'].min_ind = i;
                }
                temp = temp.links[c-'a'];
            }
            if(default_min > ch.length)
            {
                default_min = ch.length;
                default_ind = i;
            }
        }
        int m = q.length;
        int[] ans = new int[m];
        trie.min_ind = default_ind;
        for(int i=0;i<m;i++)
        {
            char[] ch = q[i].toCharArray();
            Trie temp = trie;
            for(int j = ch.length-1;j>=0;j--)
            {
                int c = ch[j];
                if(temp.links[c-'a'] != null)temp = temp.links[c-'a'];
                else{ break; }
            }
            ans[i] = temp.min_ind;
        }

        return ans;


    }
}