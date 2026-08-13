class Solution {
    public long[] solution(int x, int n) {
        // 결과를 담을 길이가 n인 long 타입 배열 선언
        long[] answer = new long[n];
        
        for (int i = 0; i < n; i++) {
            // int 범위를 초과하는 계산을 방지하기 위해 x를 long으로 형변환
            answer[i] = (long) x * (i + 1);
        }
        
        return answer;
    }
}