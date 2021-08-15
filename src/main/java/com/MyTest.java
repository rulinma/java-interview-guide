package com;

import java.util.ArrayList;
import java.util.List;

public class MyTest {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        int[] result = rearrangeArray(nums);
        for (int x : result) {
            System.out.println(x);
        }
    }

    public static int[] rearrangeArray(int[] nums) {
        List<Integer> result = new ArrayList();
        List<Integer> availNums = new ArrayList();
        for (int x : nums) {
            availNums.add(x);
        }

        if (nums.length < 3) {
            return nums;
        }
        List<List<Integer>> total = new ArrayList<>();
        backtrace(availNums, result, nums.length, total);

        int[] r = new int[nums.length];
        int i = 0;
        if (total.size() > 0) {
            for (Integer x : total.get(0)) {
                r[i++] = x;
            }
        }
        return r;

    }

    public static void backtrace(List<Integer> availNums, List<Integer> result, int size, List<List<Integer>> total) {
        if (total.size() > 0) return;
        if (result.size() == size) {
            // get
            List<Integer> xx = new ArrayList<>();
            xx.addAll(result);
            total.add(xx);
            return;
        }

        for (Integer i : availNums) {
            if (result.size() < 2) {
                result.add(i);
            } else {
                //
                int currentSize = result.size();
                if (result.get(currentSize - 1).equals((result.get(currentSize - 2) + i) / 2)) {
                    // 相等则继续
                    continue;
                }
                result.add(i);
            }

            List<Integer> availNumsRemove = remove(availNums, result);
            backtrace(availNumsRemove, result, size, total);
            result.remove(i);
        }
    }

    private static List<Integer> remove(List<Integer> availNums, List<Integer> result) {
        // availNums - result
        List<Integer> r = new ArrayList<>();
        for (Integer i : availNums) {
            if (!result.contains(i)) {
                r.add(i);
            }
        }
        return r;
    }


}
