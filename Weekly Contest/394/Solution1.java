class Solution {
    public int numberOfSpecialChars(String word) {
        
        int[] freq1 = new int[26];
        int[] freq2 = new int[26];
        
        for(char c : word.toCharArray())
        {
            if(c >=97 && c <=122)
            {
                freq2[c-97]++;
            }
            else
            {
                freq1[c-65]++;
            }
        }
        
        //System.out.println(Arrays.toString(freq1) + " " + Arrays.toString(freq2));
        int ans = 0;
        for(int i=0;i<26;i++)
        {
            if(freq1[i] != 0 && freq2[i] != 0)
            {
                ans++;
            }
        }
        return ans;
        
    }
}