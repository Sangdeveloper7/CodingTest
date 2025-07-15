package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class 백준_1516 {

    static int N; // 건물의 종류 수
    static int[] buildTime; // 각 건물을 짓는데 걸리는 고유 시간
    static int[] indegree; // 각 건물에 대한 선행 건물의 수(진입차수) 이 값이 0이 되면 해당 건무을 지을 수 있습니다.
    static ArrayDeque<Integer>[] adjList; // 접 리스트. adjList[i]에는 i번 건물이 완성된 후에 지을 수 있는 건물들의 목록이 들어갑니다. (즉, i번 건물을 선행
    // 건물로 가지는 건물들).
    static int[] answer; // 정답 배열
    static ArrayDeque<Integer> queue; // 위상 정렬을 위한 큐

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        buildTime = new int[N+1]; // 변수 초기화
        indegree = new int[N+1];
        adjList = new ArrayDeque[N+1];
        answer = new int[N+1];
        queue = new ArrayDeque<>();

        for(int i = 0; i < N+1; i++)
            adjList[i] = new ArrayDeque<>();


        for(int i = 1; i <= N; i++){// 입력 값 정리
            StringTokenizer st = new StringTokenizer(br.readLine());
            buildTime[i] = Integer.parseInt(st.nextToken());

            while(true){
                int k = Integer.parseInt(st.nextToken());
                if(k == -1)
                    break;
                else{
                    adjList[k].add(i);
                    indegree[i]++;
                }
            }
        }

        for(int i = 1; i <N+1; i++){
            if(indegree[i] == 0) {
                queue.add(i);
                answer[i] = buildTime[i];
            }
        }

        while(!queue.isEmpty()){
            int current = queue.poll();

            for(int next : adjList[current]){
                answer[next] = Math.max(answer[next], answer[current] + buildTime[next]);
                indegree[next]--;

                if(indegree[next] == 0)
                    queue.add(next);
            }
        }

//        for(int i = 0; i < N; i++){
//            if(adjList[i].isEmpty())
//                queue.add(buildTime[i]);
//            else{
//                int pretime = 0;
//                while(!queue.isEmpty()){
//                    for(int before : adjList[i]){
//                        pretime = Math.max(pretime, buildTime[before]);
//                    }
//                }
//                queue.add(pretime + buildTime[i]);
//            }
//        }


        for(int i = 1; i < answer.length; i++){
            int time = answer[i];
            System.out.println(time);
        }

    }
}
