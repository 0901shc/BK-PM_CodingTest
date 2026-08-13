import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt(); // 가로 길이
        int b = sc.nextInt(); // 세로 길이
        
        // 세로 길이(b)만큼 줄바꿈 반복
        for (int i = 0; i < b; i++) {
            // 가로 길이(a)만큼 별(*) 출력
            for (int j = 0; j < a; j++) {
                System.out.print("*");
            }
            // 한 줄의 별 출력이 끝나면 줄바꿈
            System.out.println();
        }
    }
}