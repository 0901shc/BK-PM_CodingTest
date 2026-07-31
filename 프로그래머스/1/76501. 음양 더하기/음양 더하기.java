class Solution {
    public int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;
        
        for (int i = 0; i < absolutes.length; i++) {
            // signs[i]가 true이면 양수(+), false이면 음수(-)로 계산하여 더합니다.
            answer += signs[i] ? absolutes[i] : -absolutes[i];
        }
        
        return answer;
    }
}