import java.util.Arrays;

class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;
        
        // 1. col번째 컬럼 기준 오름차순, 동일 시 첫 번째 컬럼(index 0) 기준 내림차순 정렬
        int targetCol = col - 1;
        Arrays.sort(data, (a, b) -> {
            if (a[targetCol] == b[targetCol]) {
                return Integer.compare(b[0], a[0]); // 첫 번째 컬럼 내림차순
            }
            return Integer.compare(a[targetCol], b[targetCol]); // targetCol 오름차순
        });
        
        // 2. row_begin부터 row_end까지 S_i 계산 후 XOR 연산 수행
        for (int i = row_begin; i <= row_end; i++) {
            int S_i = 0;
            int[] row = data[i - 1]; // 1-based index -> 0-based index 변환
            
            for (int val : row) {
                S_i += val % i;
            }
            
            answer ^= S_i; // XOR 누적
        }
        
        return answer;
    }
}