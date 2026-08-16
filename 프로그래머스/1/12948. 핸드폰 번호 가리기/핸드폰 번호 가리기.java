class Solution {
    public String solution(String phone_number){
        // 1. 문자열을 문자 배열로 변환
        char[] ch = phone_number.toCharArray();
        
        // 2. 뒤의 4자리를 제외한 나머지 문자들을 '*'로 변경
        for (int i = 0; i<ch.length -4; i++) {
            ch[i] = '*';
        }
        
        return new String(ch);
    }
}
