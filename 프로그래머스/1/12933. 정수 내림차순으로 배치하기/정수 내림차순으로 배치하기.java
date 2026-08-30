import java.util.Arrays;

class Solution {
    public long solution(long n) {
    
        char[] chars = String.valueOf(n).toCharArray();
        
        Arrays.sort(chars);
        
        String reversed = new StringBuilder(new String(chars)).reverse().toString();
        
        return Long.parseLong(reversed);
    
    }
}