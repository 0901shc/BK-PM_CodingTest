import java.util.Set;
import java.util.TreeSet;

class Solution {
    public int[] solution(int[] numbers) {
        // TreeSet을 사용하면 중복을 제거하면서 자동으로 오름차순 정렬을 해줍니다.
        Set<Integer> set = new TreeSet<>();
        
        // i는 0부터 끝에서 두 번째까지
        for (int i = 0; i < numbers.length; i++) {
            // j는 i 다음 인덱스부터 끝까지 (중복 연산 방지)
            for (int j = i + 1; j < numbers.length; j++) {
                set.add(numbers[i] + numbers[j]);
            }
        }
        
        // Set을 int 배열로 변환하여 반환
        return set.stream().mapToInt(Integer::intValue).toArray();
    }
}