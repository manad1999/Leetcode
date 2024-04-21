class Solution {
    public int numberOfSpecialChars(String word) {
        
        int[] freq1 = new int[26];
        int[] freq2 = new int[26];
        Arrays.fill(freq1, -1);
        Arrays.fill(freq2, -1);
        int n = word.length();
        for( int i=0;i<n;i++)
        {
            char c = word.charAt(i);
            if(c >=97 && c <=122)
            {
                freq1[c-97] = i;
            }
            else
            {
                if(freq2[c-65] == -1)
                    freq2[c-65] = i;
            }
        }
        
        //System.out.println(Arrays.toString(freq1) + " " + Arrays.toString(freq2));
        int ans = 0;
        for(int i=0;i<26;i++)
        {
            if(freq1[i]!= -1 && freq2[i]!= -1 && freq1[i] < freq2[i] )
            {
                ans++;
            }
        }
        
        return ans;
        
    }
}