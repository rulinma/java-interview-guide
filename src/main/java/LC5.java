

public class LC5 {

    public static void main(String[] args) {
        LC5 l5 = new LC5();
        String s = "whdqcudjpisufnrtsyupwtnnbsvfptrcgvobbjglmpynebblpigaflpbezjvjgbmofejyjssdhbgghgrhzuplbeptpaecfdanhlylgusptlgobkqnulxvnwuzwauewcplnvcwowmbxxnhsdmgxtvbfgnuqdpxennqglgmspbagvmjcmzmbsuacxlqfxjggrwsnbblnnwisvmpwwhomyjylbtedzrptejjsaiqzprnadkjxeqfdpkddmbzokkegtypxaafodjdwirynzurzkjzrkufsokhcdkajwmqvhcbzcnysrbsfxhfvtodqabvbuosxtonbpmgoemcgkudandrioncjigbyizekiakmrfjvezuzddjxqyevyenuebfwugqelxwpirsoyixowcmtgosuggrkdciehktojageynqkazsqxraimeopcsjxcdtzhlbvtlvzytgblwkmbfwmggrkpioeofkrmfdgfwknrbaimhefpzckrzwdvddhdqujffwvtvfyjlimkljrsnnhudyejcrtrwvtsbkxaplchgbikscfcbhovlepdojmqybzhbiionyjxqsmquehkhzdiawfxunguhqhkxqdiiwsbuhosebxrpcstpklukjcsnnzpbylzaoyrmyjatuovmaqiwfdfwyhugbeehdzeozdrvcvghekusiahfxhlzclhbegdnvkzeoafodnqbtanfwixjzirnoaiqamjgkcapeopbzbgtxsjhqurbpbuduqjziznblrhxbydxsmtjdfeepntijqpkuwmqezkhnkwbvwgnkxmkyhlbfuwaslmjzlhocsgtoujabbexvxweigplmlewumcone";
        String result = l5.longestPalindrome(s);
        System.out.println(result);
    }

    public String longestPalindrome(String s) {
        if (s.length() == 1) {
            return s;
        }
        char[] cs = s.toCharArray();
        int start = 0;
        int len = s.length();
        int max = 0;
        // 遍历所有可能子串
        for (int i = 0; i < len - 1; i++) {
            for (int j = i; j < len; j++) {
                if ((j + 1 - i > max) && isReverse(cs, i, j)) {
                    max = j + 1 - i;
                    start = i;
                }
            }
        }

        return s.substring(start, start + max);
    }

    public boolean isReverse(char[] c, int low, int high) {
        while (low <= high) {
            if (c[low++] != c[high--]) {
                return false;
            }
        }

        return true;
    }

}
