public class Three {
    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        if (len == 0) return 0;
        if (len == 1) return 1;

        char[] chars = s.toCharArray();
        // 滑动窗口
        int count = 1;
        int result = 1;
        // 1. left=0; right=1;
        int left = 0;
        int right = 1;
        while (right < len && left < len) {
            // 合规
            int index = checkValid(chars[right], chars, left, right - 1);
            System.out.println(index);
            if (index == -1) {
                right++;
                count++;
                result = Math.max(result, count);
            } else {
                // 不合规
                // 获取最远距离，并count-distance, left = left + distance
                left = left + index + 1;
                count = count - index - 1;
            }

        }

        return result;
    }

    public int checkValid(char c, char[] chars, int left, int right) {
        int count = -1;
        while (left <= right) {
            if (chars[left++] == c) {
                return count + 1;
            }
            count++;
        }

        return -1;
    }

    public static void main(String[] args) {
        Three three = new Three();
        int len = three.lengthOfLongestSubstring("abcabcbb");
        System.out.println(len);
    }
}
