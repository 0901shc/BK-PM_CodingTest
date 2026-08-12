class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        int n = nums.length;

        // 1. 서로 다른 3개의 숫자를 고르는 모든 조합 탐색
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    int sum = nums[i] + nums[j] + nums[k];
                    
                    // 2. 더한 값이 소수인지 확인
                    if (isPrime(sum)) {
                        answer++;
                    }
                }
            }
        }

        return answer;
    }

    // 소수 판별 메서드
    private boolean isPrime(int num) {
        // 2 미만의 숫자는 소수가 아님 (이 문제에서는 최소 합이 6 이상이므로 생략 가능하나 원칙적으로 작성)
        if (num < 2) return false;
        
        // 해당 숫자의 제곱근까지만 나누어 떨어지는지 검사하여 시간 복잡도 최소화
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false; // 나누어 떨어지면 소수가 아님
            }
        }
        
        return true; // 나누어 떨어지지 않으면 소수
    }
}