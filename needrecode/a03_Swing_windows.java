import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class a03_Swing_windows {

        public static void main(String[] args) {
        String s ="abccccccc";
            // 哈希集合，记录每个字符是否出现过
            // 是为了用于记录每个单个字母的出现位置，方便之后在滑动窗口中右指针右移动到极限后我们需要往右移left指针
            // 移动left指针直到构造的结果依旧符合边界条件，那么使用哈希集合occ这个时候我们做窗口直接跳到满足题意的做窗口
            HashMap<Character, Integer> occ = new HashMap<>();
            int n = s.length();
            int ans = 0;
            for (int left = 0, right = 0; left < n; left++) {
                if (occ.containsKey(s.charAt(left))) {
                    right = Math.max(right, occ.get(s.charAt(left)));
                }
                ans = Math.max(ans, left - right + 1);
                occ.put(s.charAt(left), left + 1);
            }
            System.out.println(ans);
        }
    }