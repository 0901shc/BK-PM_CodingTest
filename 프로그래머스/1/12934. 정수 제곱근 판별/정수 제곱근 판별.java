class Solution {
    public long solution(long n) {
        // 1. n의 제곱근 구하기
        long x = (long) Math.sqrt(n);
        
        // 2. x를 제곱했을 때 n이 되면 (x + 1)의 제곱 반환
        if (x * x == n) {
            return (x + 1) * (x + 1);
        }
        
        // 3. 제곱근이 양의 정수가 아니라면 -1 반환
        return -1;
    }
}