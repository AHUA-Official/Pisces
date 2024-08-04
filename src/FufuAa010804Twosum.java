import java.util.HashMap;
import java.util.Map;

public class FufuAa010804Twosum {
    public int[] twoSum(int[] nums, int target) {
        // 定义一个字典  遍历数组  每个数组的key是数组下标   val是target-nums[key]
        //遇到数组中的数打到了字典中的val就返回    构建列表返回
        Map<Integer,Integer>    map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target-nums[i])) {
                int[] ints = {i, map.get(target-nums[i])};
                return ints;
            }
            map.put(nums[i],i);
        }
return  null;

    }

    public static void main(String[] args) {
         FufuAa010804Twosum solution = new FufuAa010804Twosum();
        int[] nums = {2,100,55,88, 7, 11, 15};
        int target = 9;
        try {
            int[] result = solution.twoSum(nums, target);
            System.out.println("Index1: " + result[0] + ", Index2: " + result[1]);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

}