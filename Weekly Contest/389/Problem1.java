class Solution {
    public boolean isSubstringPresent(String s) {
        
        int n = s.length();
        Set<String> set = new HashSet<>();
        
        for(int i=0;i<n-1;i++)
        {
            set.add(s.substring(i, i+2));
        }
        
        for(int i = n-1;i>=1;i--)
        {
            String temp = s.charAt(i) +""+ s.charAt(i-1);
            if(set.contains(temp))
            {
                return true;
            }
        }
        return false;
        
    }
}