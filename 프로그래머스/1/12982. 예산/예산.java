import java.util.Arrays;

class Solution {
    public int solution(int[] d, int budget) {
        int answer = 0;
        
        // 1. 신청 금액 배열을 오름차순으로 정렬
        Arrays.sort(d);
        
        // 2. 적은 금액을 신청한 부서부터 예산 차감
        for (int i = 0; i < d.length; i++) {
            // 남은 예산이 신청 금액보다 적으면 더 이상 지원 불가하므로 종료
            if (budget < d[i]) {
                break;
            }
            
            budget -= d[i]; // 예산 차감
            answer++;       // 지원한 부서 개수 증가
        }
        
        return answer;
    }
}