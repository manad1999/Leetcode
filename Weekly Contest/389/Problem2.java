class Solution {
    public long countSubstrings(String s, char c) {
        
        int n = s.length();
        long ct = 0;
        for(int i=0;i<n;i++)
        {
            ct += s.charAt(i) == c ? 1 : 0;
        }
        
        return (ct* (ct+1))/2;
        
    }
}