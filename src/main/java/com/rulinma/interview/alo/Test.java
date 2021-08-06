package com.rulinma.interview.alo;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class Test {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        List<List<Integer>> result = permute(nums);
        System.out.println(result);
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> tracker = new ArrayList();

        backTrace(nums, tracker, result);

        return result;
    }

    public static void backTrace(int[] nums, List<Integer> tracker,    List<List<Integer>> result) {
        // 1. 满足条件则添加
        if (tracker.size() == nums.length) {
            // tracker 复制
            List<Integer> t = new ArrayList<>();
            t.addAll(tracker);
            result.add(t);
            System.out.println("add result" + tracker.get(0) + tracker.get(1) + tracker.get(2));
            return;
        }

        // 2. 进行递归及回溯
        for (int i = 0; i < nums.length; i++) {
            if (tracker.contains(nums[i])) {
                continue;
            }
            // System.out.println(tracker.size());
            tracker.add(nums[i]);
            backTrace(nums, tracker, result);
            //
            if (tracker != null && tracker.size() >= 1) {
                tracker.remove(tracker.size() - 1);
            }
        }

    }
}
