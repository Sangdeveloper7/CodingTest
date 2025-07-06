import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;

public class 백준_최소힙_Heap {


    public static void main(String[] args) throws IOException{
        PriorityQueue<Integer> q = new PriorityQueue<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();


        for(int i = 0; i < N; i++){
            int number = Integer.parseInt(br.readLine());
            if(number == 0){
                if(!q.isEmpty()){
                    int k = q.poll();
                    sb.append(k).append("\n");
                }else{
                    sb.append(0).append("\n");
                }
            }else{
                q.add(number);
            }
        }
        System.out.println(sb);

    }
}
