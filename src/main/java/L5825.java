import java.util.*;

class L5825 {

    public static void main(String[] args) {
        int[][] mat = new int[][]{{1}, {2}, {3}};

        L5825 solution = new L5825();

        int re = solution.minimizeTheDifference(mat, 100);

        System.out.println(re);
    }

    public int minimizeTheDifference(int[][] mat, int target) {
        List<TreeSet<Integer>> list = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        // 遍历所有累加值
        TreeSet<Integer> t = new TreeSet<Integer>();
        for (int i = 0; i < mat[0].length; i++) {
            t.add(mat[0][i]);
        }
        list.add(t);

        for (int j = 1; j < mat.length; j++) {
            TreeSet<Integer> treeSet = new TreeSet<>();
            TreeSet<Integer> pre = list.get(j - 1);
            for (int m = 0; m < mat[0].length; m++) {
                for (Integer o : pre) {
                    treeSet.add(o + mat[j][m]);
                    if (o + mat[j][m] > target) {
                        break;
                    }
                }
            }
            list.add(treeSet);
        }

        // 所有累加值中获取最小值
        TreeSet<Integer> filter = list.get(mat.length - 1);
        for (Integer x : filter) {
            min = Math.min(Math.abs(x - target), min);
        }

        return min;
    }

//    public int minimizeTheDifference(int[][] mat, int target) {
//        int t = 0;
//        int n = mat.length;
//        int m = mat[0].length;
//        for (int i = 0; i < n; i++) {
//            int mi = Integer.MAX_VALUE;
//            for (int j = 0; j < m; j++) {
//                if (mat[i][j] < mi) {
//                    mi = mat[i][j];
//                }
//            }
//            t += mi;
//        }
//        if (t >= target) {
//            return t - target;
//        }
//
//        int limit = 2 * target - t;
//        Set<Integer> reachAble = new HashSet<>();
//        reachAble.add(0);
//        for (int i = 0; i < n; i++) {
//            Set<Integer> newReachAble = new HashSet<>();
//            for (int j = 0; j < m; j++) {
//                for (int k : reachAble) {
//                    if (k + mat[i][j] <= limit) {
//                        newReachAble.add(k + mat[i][j]);
//                    }
//                }
//            }
//            reachAble = newReachAble;
//        }
//
//        // 整理
//        int res = 99999999;
//        for (int i : reachAble) {
//            if (Math.abs(i - target) < res) {
//                res = Math.abs(i - target);
//            }
//        }
//        return res;
//    }


}