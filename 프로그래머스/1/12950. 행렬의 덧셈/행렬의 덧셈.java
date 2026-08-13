class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        // 행(row)과 열(column)의 길이를 구함
        int rows = arr1.length;
        int cols = arr1[0].length;
        
        // 결과를 담을 동일한 크기의 2차원 배열 선언
        int[][] answer = new int[rows][cols];
        
        // 이중 for문을 돌면서 같은 위치의 원소들을 더함
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                answer[i][j] = arr1[i][j] + arr2[i][j];
            }
        }
        
        return answer;
    }
}