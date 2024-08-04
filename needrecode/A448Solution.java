import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class A448Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer>  answerlist  = new ArrayList<Integer>();
        Set<Integer>    finbyset = new HashSet<Integer>();
        for (int n :  nums){
            finbyset.add(Integer.valueOf(n));
        }
        for ( int i=1;i<=nums.length;i++){
            if (finbyset.contains(i)){

            }else {
                answerlist.add(i);
            }

        }

            return  answerlist;
    }

    public static void main(String[] args) {
        A448Solution solution = new A448Solution();
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        List<Integer> disappearedNumbers = solution.findDisappearedNumbers(nums);
        System.out.println(disappearedNumbers); // 输出 [5, 6]
    }
}
