import java.util.HashMap;
import java.util.Map;

public class Txx {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap();

        int index = 0;
        for (int i : nums) {
            if (map.get(i) != null) {
                if (index - map.get(i) <= k) {
                    return true;
                }
            }
            map.put(i, index++);
        }

        return false;
    }


    public static void main(String[] args) {
        Txx txx = new Txx();
        boolean s = txx.containsNearbyDuplicate(new int[]{1, 2, 3, 1, 2, 3}, 2);
        System.out.println(s);
    }
}
