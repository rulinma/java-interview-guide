package com.test;

import java.lang.StringBuilder;

public class Test {

//    删除链表的倒数第N个节点
//    给定一个链表。删除链表的倒数第n个节点，
//    保证给定的n有效

    public static boolean isSym(String s) {
        if (s == null) {
            return true;
        }

        // filter s 为仅有字母和数字
        char[] ca = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char c : ca) {
            if (Character.isLetterOrDigit(c)) {
                sb.append(c);
            }
        }

        if (sb.toString() == null || sb.toString().length() <= 1) {
            return true;
        }
        ca = sb.toString().toLowerCase().toCharArray();
        int left = 0;
        int right = ca.length - 1;
        while (left <= right) {
            if (ca[left] != ca[right]) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

    public static String delNChar(String s) {
        StringBuilder sb = new StringBuilder();
        if (s.length() < 3) {
            return s;
        }
        char[] charArray = s.toCharArray();
        char current = charArray[0];
        sb.append(current);
        int count = 1;
        for (int i = 1; i < charArray.length; i++) {
            if (charArray[i] == current) {
                count++;
            } else if (charArray[i] != current) {
                count = 1;
                current = charArray[i];
            }

            if (count < 3) {
                sb.append(current);
            }
        }

        return sb.toString();
    }

    public static boolean isPrefixString(String s, String[] words) {
        // 1 比较当前s的left，end值是否匹配words
        int len = s.length();
        int left = 0;
        int right = 0;
        for (String x : words) {
            right = right + x.length();
            if (right == len && s.substring(left, right).equals(x)) {
                return true;
            }
            if (right > len || !s.substring(left, right).equals(x)) {
                return false;
            }
            left = right;
        }

        return true;
    }


    public static void main(String[] args) {

        System.out.println(isSym("A man, a plan, a canal: Panama"));

        String s = delNChar("aaabcde");
        System.out.println(s);

        String[] a = new String[]{"c", "cc"};
        boolean r = isPrefixString("cccccc", a);
        System.out.println(r);

        int m = 2;
        // 1. [1,2,3] len=3 n=2 正数3-2=1
        // 2. [1,2,3,4] len=4 n=2 正数4-2=2
        // N-n+1 个正数
        Node node3 = new Node(3, null);
        Node node2 = new Node(2, node3);
        Node node1 = new Node(1, node2);

        // 注意n=N等边界
        // n可以设置为正向第几个
        int len = 0;
        Node node = node1;
        while (node != null) {
            node = node.next;
            len++;
        }
        System.out.println("len :" + len);
        int n = len - m;

        Node result = converse(node1, n);
        while (result != null) {
            System.out.println("result: " + result);
            result = result.next;
        }

        System.out.println("end");
    }

    public static Node converse(Node node, int n) {
        if (n == 0) {
            return node.next;
        }
        // n->index(从0开始)

        // 删除第n个节点
        Node result = null;
        // 其他
        Node head = new Node(-1, null);
        head.next = node;
        Node pre = null;
        int i = 0;
        while (i < n) {
            pre = node;
            node = node.next;
            i++;
        }
        Node delNode = node;
        if (delNode != null) {
            pre.next = delNode.next;
        } else if (delNode == null) {
            pre.next = null;
        }
        result = head.next;

        return result;
    }

}

class Node {
    protected int value;
    protected Node next;

    public Node(int value, Node next) {
        this.value = value;
        this.next = next;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                ", next=" + next +
                '}';
    }
}
