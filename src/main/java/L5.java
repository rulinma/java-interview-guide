

public class L5 {

    public static void main(String[] args) {
        L5 l5 = new L5();
        String s = "\"whdqcudjpisufnrtsyupwtnnbsvfptrcgvobbjglmpynebblpigaflpbezjvjgbmofejyjssdhbgghgrhzuplbeptpaecfdanhlylgusptlgobkqnulxvnwuzwauewcplnvcwowmbxxnhsdmgxtvbfgnuqdpxennqglgmspbagvmjcmzmbsuacxlqfxjggrwsnbblnnwisvmpwwhomyjylbtedzrptejjsaiqzprnadkjxeqfdpkddmbzokkegtypxaafodjdwirynzurzkjzrkufsokhcdkajwmqvhcbzcnysrbsfxhfvtodqabvbuosxtonbpmgoemcgkudandrioncjigbyizekiakmrfjvezuzddjxqyevyenuebfwugqelxwpirsoyixowcmtgosuggrkdciehktojageynqkazsqxraimeopcsjxcdtzhlbvtlvzytgblwkmbfwmggrkpioeofkrmfdgfwknrbaimhefpzckrzwdvddhdqujffwvtvfyjlimkljrsnnhudyejcrtrwvtsbkxaplchgbikscfcbhovlepdojmqybzhbiionyjxqsmquehkhzdiawfxunguhqhkxqdiiwsbuhosebxrpcstpklukjcsnnzpbylzaoyrmyjatuovmaqiwfdfwyhugbeehdzeozdrvcvghekusiahfxhlzclhbegdnvkzeoafodnqbtanfwixjzirnoaiqamjgkcapeopbzbgtxsjhqurbpbuduqjziznblrhxbydxsmtjdfeepntijqpkuwmqezkhnkwbvwgnkxmkyhlbfuwaslmjzlhocsgtoujabbexvxweigplmlewumcone";
        String result = l5.longestPalindrome(s);
        System.out.println(result);
    }

    public String longestPalindrome(String s) {
        if (s.length() == 1) {
            return s;
        }
        int start = 0;
        int len = s.length();
        int max = 0;
        // 遍历所有可能子串
        for (int i = 0; i < len - 1; i++) {
            for (int j = i; j < len; j++) {
                if ((j + 1 - i > max) && isReverse(s.substring(i, j + 1))) {
                    max = j + 1 - i;
                    start = i;
                }
            }
        }

        return s.substring(start, start + max);
    }

    public boolean isReverse(String s) {
        char[] c = s.toCharArray();
        int low = 0;
        int high = s.length() - 1;
        while (low <= high) {
            if (c[low++] != c[high--]) {
                return false;
            }
        }

        return true;
    }

}
