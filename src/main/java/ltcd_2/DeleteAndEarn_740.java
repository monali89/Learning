package ltcd_2;

import java.util.*;

public class DeleteAndEarn_740 {

    public int deleteAndEarn(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums);

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            if (!list.contains(num)) list.add(num);
        }

        int[] memo = new int[map.size()];

        memo[0] = list.get(0) * map.get(list.get(0));
        memo[1] = list.get(1) * map.get(list.get(1));

        for (int i = 2; i < map.size(); i++) {
            int curr = list.get(i) * map.get(list.get(i));
            memo[i] = Math.max(curr + memo[i-2], memo[i-1]);
        }

        return memo[nums.length - 1];
    }

    public static void main(String[] args) {

        DeleteAndEarn_740 object = new DeleteAndEarn_740();
        int[] input;

        //input = new int[] {3, 4, 2};
        //System.out.println(object.deleteAndEarn(input));

        input = new int[] {2,2,3,3,3,4};
        System.out.println(object.deleteAndEarn(input));
    }
}
