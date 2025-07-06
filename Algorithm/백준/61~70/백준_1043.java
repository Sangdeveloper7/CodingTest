package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 백준_1043 {
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new int[N+1];

        for(int i = 0; i < N+1; i++)
            arr[i] = i;

        st = new StringTokenizer(br.readLine());

        int know_count = Integer.parseInt(st.nextToken());

        if(know_count == 0) // 아무도 모를 경우
            System.out.println(M);
        else{ // 아는 사람이 있을 경우
            int[] know_arr = new int[know_count];
            for(int i = 0; i < know_count; i++){
                know_arr[i] = Integer.parseInt(st.nextToken());
            }

            for(int i = 1; i < know_count; i++){
                union(know_arr[0], know_arr[i]);
            }

            ArrayList<Integer>[] adjList = new ArrayList[M];

            for(int i =0; i <M; i++)
                adjList[i] = new ArrayList<>();

            for(int i = 0; i < M; i++){ // 모든 파티의 구성원을 받는다.
                st = new StringTokenizer(br.readLine());
                int arr_count = Integer.parseInt(st.nextToken());
                for(int j = 0; j < arr_count; j++){
                    adjList[i].add(Integer.parseInt(st.nextToken()));
                }
            }

            for(int i = 0; i < M; i++){
                if(adjList[i].size() > 1){
                    int first_person = adjList[i].get(0);
                    for(int j = 1; j < adjList[i].size(); j++){
                        union(first_person, adjList[i].get(j));
                    }
                }
            }

            int truth_node = find(know_arr[0]);
            int count = 0;

            for(int i = 0; i < M; i++){
                boolean check = true;
                for(int j : adjList[i]){
                    if(find(j) == truth_node){
                        check = false;
                        break;
                    }
                }
                if(check)
                    count++;
            }
            System.out.println(count);
        }
    }

    public static int find(int a){
        if(arr[a] == a)
            return a;
        else
            return arr[a] = find(arr[a]);
    }

    public static void union(int a, int b){
        int a_root = find(a);
        int b_root = find(b);

        if(a_root != b_root){
            if(a_root < b_root)
                arr[b_root] = a_root;
            else
                arr[a_root] = b_root;
        }
    }
}
