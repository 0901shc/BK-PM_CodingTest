class Solution {
    public int solution(int n) {
        // 1. 10진법 숫자를 3진법 문자열로 변환
        String ternary = toTernary(n);
        
        // 2. 3진법 문자열을 앞뒤로 뒤집기
        String reversedTernary = new StringBuilder(ternary).reverse().toString();
        
        // 3. 뒤집힌 3진법 문자열을 다시 10진법으로 변환
        int answer = toDecimal(reversedTernary);
        
        return answer;
    }
    
    /**
     * 10진법 정수를 3진법 문자열로 변환하는 함수
     */
    private String toTernary(int n) {
        StringBuilder sb = new StringBuilder();
        
        while (n > 0) {
            // 나머지를 구해서 앞(0번째 인덱스)에 계속 끼워 넣습니다.
            // (나머지를 역순으로 읽어야 하므로 앞에 추가)
            sb.insert(0, n % 3);
            n /= 3;
        }
        
        return sb.toString();
    }
    
    /**
     * 3진법 문자열을 10진법 정수로 변환하는 함수
     */
    private int toDecimal(String ternary) {
        int decimal = 0;
        int power = 1; // 3^0 = 1 부터 시작
        
        // 문자열의 맨 뒤(오른쪽 끝, 1의 자리)부터 계산
        for (int i = ternary.length() - 1; i >= 0; i--) {
            // 문자를 숫자로 변환 ('0'을 빼줌)
            int digit = ternary.charAt(i) - '0';
            
            // 해당 자리의 숫자와 3의 거듭제곱 값을 곱해서 더함
            decimal += digit * power;
            
            // 다음 자리로 갈 때마다 자릿값을 3배씩 증가시킴 (3^0 -> 3^1 -> 3^2 ...)
            power *= 3;
        }
        
        return decimal;
    }
}