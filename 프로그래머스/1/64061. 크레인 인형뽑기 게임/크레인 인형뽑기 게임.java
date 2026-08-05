import java.util.Stack;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        // 바구니 역할을 할 스택 선언
        Stack<Integer> basket = new Stack<>();
        
        // 크레인의 작동 위치를 하나씩 순회
        for (int move : moves) {
            int col = move - 1; // 배열은 0부터 시작하므로 1을 빼줌
            
            // 맨 위에서부터 아래로 내려가며 인형을 찾음
            for (int row = 0; row < board.length; row++) {
                if (board[row][col] != 0) { // 비어있지 않고 인형이 있다면
                    int doll = board[row][col]; // 인형을 집음
                    board[row][col] = 0; // 집어올린 자리는 빈칸(0)으로 만듦
                    
                    // 바구니에 동일한 인형이 연속해서 쌓이는지 확인
                    if (!basket.isEmpty() && basket.peek() == doll) {
                        basket.pop(); // 같은 인형이 있으면 터트림
                        answer += 2;  // 터진 인형의 개수 증가 (2개가 사라짐)
                    } else {
                        basket.push(doll); // 다르면 바구니에 넣음
                    }
                    
                    break; // 인형을 하나 뽑았으므로 크레인 작동 종료 후 다음 move로 넘어감
                }
            }
        }
        
        return answer;
    }
}