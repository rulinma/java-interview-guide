
public class ReverseStr {

    public static void main(String[] args) {
        ReverseStr reverseStr = new ReverseStr();
        String x = reverseStr.reverseStr("a", 2);
        System.out.println(x);
    }

    public String reverseStr(String s, int k) {
        // 1. len >= 2k 反转前k个
        // 2. len < k 剩余字符全反转
        // 3. len >=k && len < 2k 反转前k个，其余保持
        StringBuilder sb = new StringBuilder();
        int len = s.length();

        int start = 0;
        while ((start + (2 * k - 1)) <= len - 1) {
            String s1 = reverseG2K(s.substring(start, start + (2 * k)), k);
            sb.append(s1);
            start = start + (2 * k);
        }

        // 剩余<k
        if ((start + k > len - 1) && start <= len - 1) {
            String s2 = reverseL2K(s.substring(start), k);
            sb.append(s2);
        } else if (start + k <= len - 1 && start <= len - 1) {
            // 剩余>=k && < 2k
            String s3 = reverseB2K(s.substring(start), k);
            sb.append(s3);
        }

        return sb.toString();

    }

    public String reverseG2K(String org, int k) {
        StringBuilder sb = new StringBuilder();
        int i = k - 1;
        char[] chars = org.toCharArray();
        while (i >= 0) {
            sb.append(chars[i]);
            i--;
        }

        return sb.toString() + org.substring(k);
    }

    public String reverseL2K(String org, int k) {
        if (org.length() < k) {
            k = org.length();
        }
        StringBuilder sb = new StringBuilder();
        int i = k - 1;
        char[] chars = org.toCharArray();
        while (i >= 0) {
            sb.append(chars[i]);
            i--;
        }


        return sb.toString();
    }

    public String reverseB2K(String org, int k) {
        StringBuilder sb = new StringBuilder();
        if (org.length() < k) return org;
        int i = k - 1;
        char[] chars = org.toCharArray();
        while (i >= 0) {
            sb.append(chars[i]);
            i--;
        }

        return sb.toString() + org.substring(k);
    }


}
