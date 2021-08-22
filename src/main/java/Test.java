import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Test {

    private static int count = 0;

    public static void main(String[] args) {
        // 返回二叉树的节点数
        // dfs
//        Node node = new Node();
//        traverse(node);
//        System.out.println(count);

        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        node1.setLeft(node2);
        node1.setRight(node3);
        node2.setLeft(node4);

        int c = bfs(node1);
        System.out.println(c);
    }

//    public static void traverse(Node node) {
//        if (node == null) {
//            return;
//        }
//        traverse(node.getLeft());
//        System.out.println(node.val);
//        count++;
//        traverse(node.getRight());
//    }

    public static int bfs(Node node) {
        int count = 0;
        if (node == null) {
            return 0;
        }
        //
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        while (q.size() > 0) {
//            List<Node> list = new ArrayList();
//            for (int i = 0; i < q.size(); i++)
            {
                Node n = q.poll();
                if (n.getLeft() != null) {
                    q.add(n.getLeft());
                }
                if (n.getRight() != null) {
                    q.add(n.getRight());
                }
            }
            count++;
        }

        return count;
    }

}

class Node {
    protected Integer val;
    private Node left;
    private Node right;
//    private int count;

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public int demo(Node node) {
        int count = 0;
        if (node == null) {
            return 0;
        }
        //
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        count++;

        while (q.size() > 0) {
            for (int i = 0; i < q.size(); i++) {
                Node n = q.poll();
                count++;
                if (n.getLeft() != null) {
                    q.add(n.getLeft());
                }
                if (n.getRight() != null) {
                    q.add(n.getRight());
                }
            }
        }

        return count;
    }

    public Node(Integer val, Node left, Node right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public Node(Integer val) {
        this.val = val;
    }

    //
//    public void traverse(Node node) {
//        if (node == null) {
//            return;
//        }
//        traverse(node.getLeft(), count);
//        System.out.println(node.val);
//        count++;
//        traverse(node.getRight(), count);
//    }

    @Override
    public String toString() {
        return "Node{" +
                "left=" + left +
                ", right=" + right +
                '}';
    }
}