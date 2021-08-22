import java.util.Arrays;

public class Test2 {

    public static void main(String[] args) {

//        输入一个整数数组 A 和一个目标 target ，返回A中任意一个和为 target 的两个元素的组合。例如
//        A = [1, 3, 1, 2, 2, 3], target = 4，那么返回：[1, 3] 或者 [3, 1] 或者 [2, 2]
//        要求时间复杂度小于O(N^2)，空间复杂度O(1)。

        // 1. sort
        // 2. [1, 1, 2, 2, 3]
        int target = 4;
        int[] x = new int[]{1, 3, 1, 2, 2, 3};
        Arrays.sort(x);

        int[] result = new int[]{};
        int left = 0;
        int right = x.length - 1;

        while (left <= right) {
            if (x[left] + x[right] == target) {
                result = new int[]{x[left], x[right]};
                break;
            } else if (x[left] + x[right] > target) {
                right--;
            } else if (x[left] + x[right] < target) {
                left++;
            }
        }

        for (int m:result) {
            System.out.println(m);
        }

    }

//    public static int[] search(int[] x, int target) {
//
//    }


}
