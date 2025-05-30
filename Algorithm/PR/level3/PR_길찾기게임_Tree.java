package PR.level3;

import java.util.*;

public class PR_길찾기게임_Tree {

    private static class Node{
        int x, y, index;
        Node left, right;
        public Node(int x, int y, int index) {
            this.x = x;
            this.y = y;
            this.index = index;
        }
    }

    private static HashSet<Integer> checkVisted = new HashSet<>();

    public static int[][] solution(int[][] nodeinfo) {
        int[][] answer = {};

        ArrayList<Node> all = new ArrayList<>();

        int i = 0;
        for(int[] node : nodeinfo) {
            all.add(new Node(node[0], node[1], i+1));
        }

        Collections.sort(all, (a, b) -> {
            if (a.y == b.y) return a.x - b.x;
            return b.y - a.y;
        });

        Node root = all.get(0);

        for(int j = 1; j < all.size(); j++) {
            insert(root, all.get(j));
        }

        List<Integer> preorder = new ArrayList<>();
        List<Integer> postorder = new ArrayList<>();

        return new int[][]{
                preorder.stream().mapToInt(k->k).toArray(),
                postorder.stream().mapToInt((k->k)).toArray()
        };
    }

    private static void insert(Node parent, Node child){
        if(child.x < parent.x){
            if(parent.left == null)
                parent.left = child;
            else
                insert(parent.left, child);
        }else{
            if(parent.right == null)
                parent.right = child;
            else
                insert(parent.right, child);
        }
    }

    private static void preorder(Node node, ArrayList<Integer> list){
        if(node == null)
            return;
        list.add(node.index);
        preorder(node.left, list);
        preorder(node.right, list);
    }

    private static void postorder(Node node, ArrayList<Integer> list){
        if(node == null)
            return;
        preorder(node.left, list);
        preorder(node.right, list);
        list.add(node.index);
    }


    public static void main(String[] args) {
        int[][] nodeinfo = {
                {5, 3}, {11, 5}, {13, 3}, {3, 5}, {6, 1}, {1, 3}, {8, 6}, {7, 2}, {2, 2}
        };

        int[][] result = solution(nodeinfo);

        for(int[] arr : result) {
            System.out.println(Arrays.toString(arr));
        }
    }
}
