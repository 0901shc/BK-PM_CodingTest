class Solution {
    public int[] solution(int n, int m) {
        int origin_n = n;
        int origin_m = m;
        int gcd = 0;
        int lcm = 0;
        
        
        while(m!=0){
            int temp = n%m;
            n = m;
            m = temp;
        }
        
        gcd = n;
        lcm = origin_n*origin_m/gcd;
        
        
        
        return new int[]{gcd, lcm};        
    }
}