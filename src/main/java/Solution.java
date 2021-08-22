import java.util.*;

class Solution {

    public static void main(String[] args) {
        String[] nums = new String[]{"01", "10"};

        Solution solution = new Solution();
        String result = solution.findDifferentBinaryString(nums);

        System.out.println(result);
    }

    public String findDifferentBinaryString(String[] nums) {
        String result = null;
        Set<String> set = new HashSet<String>();
        Collections.addAll(set, nums);
        // generate num 判断是否在nums中
        // 全排列
        String s = "";

        List<String> results = new ArrayList<>();
        backtrace(s, nums.length, set, results);
        for (String x : results) {
            if (!set.contains(x)) {
                return x;
            }
        }

        return result;
    }

    public void backtrace(String result, int n, Set<String> set, List<String> results) {
        if (result.length() == n) {
            results.add(result);
            return;
        }

        String[] s = new String[]{"0", "1"};
        for (String x : s) {
            result = result + x;
            backtrace(result, n, set, results);
            result = result.substring(0, result.length() - 1);
        }
    }

}