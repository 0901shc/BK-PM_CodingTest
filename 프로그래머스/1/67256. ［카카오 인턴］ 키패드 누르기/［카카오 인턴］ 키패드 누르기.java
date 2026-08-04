class Solution {
    public String solution(int[] numbers, String hand) {
        StringBuilder answer = new StringBuilder();
        
        int[][] pos = {
            {3,1},
            {0,0},
            {0,1},
            {0,2},
            {1,0},
            {1,1},
            {1,2},
            {2,0},
            {2,1},
            {2,2}
        };
        
        int[] left = {3,0};
        int[] right = {3,2};
        
        for(int number : numbers){
            if(number == 1 || number ==4 || number ==7) {
                answer.append("L");
                left = pos[number];
            }
            else if (number == 3 || number == 6 || number == 9) {
                answer.append("R");
                right = pos[number];
            }
            else{
                int[] target = pos[number];
                
                int distL = Math.abs(left[0] - target[0]) + Math.abs(left[1] - target[1]);
                int distR = Math.abs(right[0] - target[0]) + Math.abs(right[1] - target[1]);
                
                if (distL < distR){
                    answer.append("L");
                    left = target;
                }else if (distR < distL){
                    answer.append("R");
                    right = target;
                }else{
                    if (hand.equals("right")){
                        answer.append("R");
                        right = target;
                    }else{
                        answer.append("L");
                        left = target;
                    }
                }   
            }
        }
        return answer.toString();
    }
}
