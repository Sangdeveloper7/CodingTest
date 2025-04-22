import org.w3c.dom.Node;

import java.util.HashSet;

public class PR_평행 {
    private static class Node {
        int x;
        int y;
        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static int solution(int[][] dots) {
        int x1_in = 0;
        int y1_in = 0;
        int x2_in = 0;
        int y2_in = 0;

        HashSet<Double> set = new HashSet<>();
        int count = 0;

        for(int i = 0; i < dots.length; i++) {
            Node n = new Node(dots[i][0], dots[i][1]);
            for(int j = i+1; j < dots.length; j++) {
                Node n2 = new Node(dots[j][0], dots[j][1]);
                double incline = (double) (n.y - n2.y) / (n.x - n2.x);
                set.add(incline);
                count++;
            }
        }
        if(set.size() == count) {
           return 0;
        }
        return 1;
    }

    public static void main(String[] args) {
        int[][] dots = {{1, 4}, {2, 1}, {3, 2}, {4, 7}};
    }
}
