import java.util.*;

public class Solution {
    public int solution(int n) {
        int answer = 0;

        while (n > 0) {
            answer += n % 10; // 1의 자리 숫자를 추출하여 누적합
            n /= 10;          // 마지막 자릿수 제거
        }

        return answer;
    }
}