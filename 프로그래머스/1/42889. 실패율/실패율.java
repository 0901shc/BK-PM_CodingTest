import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    
    // 스테이지 번호와 실패율을 저장할 클래스
    class Stage implements Comparable<Stage> {
        int id;
        double failureRate;

        public Stage(int id, double failureRate) {
            this.id = id;
            this.failureRate = failureRate;
        }

        @Override
        public int compareTo(Stage other) {
            // 실패율이 같을 경우 스테이지 번호 오름차순
            if (this.failureRate == other.failureRate) {
                return Integer.compare(this.id, other.id);
            }
            // 실패율 기준 내림차순
            return Double.compare(other.failureRate, this.failureRate);
        }
    }

    public int[] solution(int N, int[] stages) {
        // 1. 각 스테이지별 멈춰있는 도전자 수 카운트
        // N+1은 마지막 스테이지까지 클리어한 사용자를 의미하므로 크기를 N+2로 설정
        int[] stageCounts = new int[N + 2];
        for (int stage : stages) {
            stageCounts[stage]++;
        }

        List<Stage> stageList = new ArrayList<>();
        double totalPlayers = stages.length; // 총 도달 플레이어 수 (실수 계산을 위해 double 타입 사용)

        // 2. 실패율 계산
        for (int i = 1; i <= N; i++) {
            if (totalPlayers == 0) {
                // 스테이지에 도달한 유저가 없는 경우 실패율은 0
                stageList.add(new Stage(i, 0.0));
            } else {
                // 실패율 = 멈춰있는 도전자 수 / 도달한 총 플레이어 수
                double rate = stageCounts[i] / totalPlayers;
                stageList.add(new Stage(i, rate));
                
                // 다음 스테이지 도달 인원 갱신 (현재 스테이지에 멈춘 인원 차감)
                totalPlayers -= stageCounts[i];
            }
        }

        // 3. 조건에 맞게 정렬 (Comparable 기준 적용)
        Collections.sort(stageList);

        // 4. 정렬된 리스트에서 스테이지 번호만 추출
        int[] answer = new int[N];
        for (int i = 0; i < N; i++) {
            answer[i] = stageList.get(i).id;
        }

        return answer;
    }
}