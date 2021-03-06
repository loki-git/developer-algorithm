package com.loki.developeralgorithm.algorithm;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author xujs
 * @Desc 两数之和：给定一个整数数组和一个目标值，找出数组中和为目标值的两个数。
 * 可以假设每个输入只对应一种答案，且同样的元素不能被重复利用
 * 示例：整数数组nums = [2, 7, 11, 15], 目标值target = 9
 * 因为nums[0] + nums[1] = 2 + 7 = 9，所以返回[0, 1]
 */
public class TwoSumMain {

    public static void main(String[] args) {
        int[] nums = {5, 7, 11, 8};
        int target = 12;

        int[] result1 = twoSum1(nums, target);
        Arrays.stream(result1).forEach(x -> System.out.println(x));

        int[] result2 = twoSum2(nums, target);
        Arrays.stream(result2).forEach(x -> System.out.println(x));

        int[] result3 = twoNum3(nums, target);
        Arrays.stream(result3).forEach(x -> System.out.println(x));
    }

    /**
     * 方法1：暴力法。遍历每个元素e，并查找是否存在一个值和target - e相等的目标元素。
     * 复杂度分析：
     * 时间复杂度：O(n^2)，对于每个元素，我们试图通过遍历数组的其余部分来寻找它所对应的目标元素，这将耗费O(n)的时间。因此时间复杂度为 O(n^2)。
     * 空间复杂度：O(1)。
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum1(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                System.out.println("i:" + i + ",j:" + j);
                if (nums[j] == target - nums[i]) {
                    return new int[]{i, j};
                }
            }
        }

        throw new IllegalArgumentException("No two sum solution");
    }

    /**
     * 方法2：两边哈希表
     * 为了对运行时间复杂度进行优化，我们需要一种更有效的方法来检查数组中是否存在目标元素。如果存在，我们需要找出他的索引。保持数组中的每个元素与其索引
     * 相互对应的最好方法是什么？哈希表。
     * 通过以空间换取速度的方式，我们可以将查找时间从O(n) 降低到 O(1)。哈希表正是为此目的而构建的，它支持以近似 恒定的时间进行快速查找。我用“近似”来描述，
     * 是因为一旦出现冲突，查找用时可能会退化到 O(n)。但只要你仔细地挑选哈希函数，在哈希表中进行查找的用时应当被摊销为 O(1)。
     * 一个简单的实现使用了两次迭代。在第一次迭代中，我们将每个元素的值和它的索引添加到表中。然后，在第二次迭代中，
     * 我们将检查每个元素所对应的目标元素（target - nums[i]target−nums[i]）是否存在于表中。注意，该目标元素不能是 nums[i]nums[i] 本身！
     *
     * 复杂度分析：
     * 时间复杂度：O(n)，我们把包含有 n 个元素的列表遍历两次。由于哈希表将查找时间缩短到 O(1) ，所以时间复杂度为 O(n)。
     * 空间复杂度：O(n)，所需的额外空间取决于哈希表中存储的元素数量，该表中存储了 n 个元素。
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[]{i, map.get(complement)};
            }
        }

        throw new IllegalArgumentException("No two sum solution");
    }

    /**
     * 方法3：一遍哈希表
     * 事实证明，我们可以一次完成。在进行迭代并将元素插入到表中的同时，我们还会回过头来检查表中是否已经存在当前元素所对应的目标元素。
     * 如果它存在，那我们已经找到了对应解，并立即将其返回。
     *
     * 复杂度分析：
     * 时间复杂度：O(n)，我们只遍历了包含有 n 个元素的列表一次。在表中进行的每次查找只花费 O(1) 的时间。
     * 空间复杂度：O(n)，所需的额外空间取决于哈希表中存储的元素数量，该表最多需要存储 n 个元素。
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoNum3(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }

        throw new IllegalArgumentException("No two num solution");
    }

}
