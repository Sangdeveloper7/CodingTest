package 백준;

import java.io.*;
import java.util.*;

public class 백준_칵테일 {

    static class Node {
        int to;
        int p;
        int q;

        Node(int to, int p, int q) {
            this.to = to;
            this.p = p;
            this.q = q;
        }
    }

    static ArrayList<Node>[] graph;
    static long[] amount;
    static boolean[] visited;
    static long lcm = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        graph = new ArrayList[n];
        amount = new long[n];
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());

            graph[a].add(new Node(b, p, q));
            graph[b].add(new Node(a, q, p));

            if(p == q){
                lcm *= 1;
            }else{
                long gcd = gcd(p, q);
                lcm = lcm * (p * q / gcd) / gcd(lcm, (p * q / gcd));
            }
        }

        amount[0] = lcm;
        dfs(0);

        long mgcd = amount[0];
        for (int i = 1; i < n; i++) {
            mgcd = gcd(mgcd, amount[i]);
        }

        for (int i = 0; i < n; i++) {
            System.out.print(amount[i] / mgcd + " ");
        }
    }

    static void dfs(int current) {
        visited[current] = true;

        for (Node node : graph[current]) {
            int next = node.to;
            if (!visited[next]) {
                amount[next] = amount[current] * node.q / node.p;
                dfs(next);
            }
        }
    }

    static long gcd(long a, long b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}