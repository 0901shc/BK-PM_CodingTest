class Solution {
    public int solution(String dartResult) {
        int[] scores = new int[3]; // 3번의 다트 점수를 저장할 배열
        int idx = -1;              // 현재 처리 중인 다트 라운드 인덱스

        for (int i = 0; i < dartResult.length(); i++) {
            char c = dartResult.charAt(i);

            // 1. 숫자 (점수) 처리
            if (Character.isDigit(c)) {
                idx++; // 새로운 라운드 시작
                
                // 점수가 10인 경우 예외 처리
                if (c == '1' && dartResult.charAt(i + 1) == '0') {
                    scores[idx] = 10;
                    i++; // 뒤의 '0'은 처리했으므로 인덱스 건너뛰기
                } else {
                    // char '0'~'9'를 실제 int 값으로 변환 ('0'을 빼줌)
                    scores[idx] = c - '0';
                }
            } 
            // 2. 보너스 (S, D, T) 처리
            else if (c == 'S' || c == 'D' || c == 'T') {
                if (c == 'D') {
                    scores[idx] = (int) Math.pow(scores[idx], 2);
                } else if (c == 'T') {
                    scores[idx] = (int) Math.pow(scores[idx], 3);
                }
                // 'S'는 1제곱이므로 별도 처리를 생략합니다.
            } 
            // 3. 옵션 (*, #) 처리
            else if (c == '*') {
                scores[idx] *= 2; // 현재 라운드 2배
                if (idx > 0) {
                    scores[idx - 1] *= 2; // 이전 라운드가 있다면 이전 라운드도 2배
                }
            } else if (c == '#') {
                scores[idx] *= -1; // 현재 라운드 마이너스
            }
        }

        // 4. 총합 계산
        int totalScore = 0;
        for (int score : scores) {
            totalScore += score;
        }

        return totalScore;
    }
}