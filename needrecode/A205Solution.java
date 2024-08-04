import java.util.HashMap;
import java.util.Map;

public class A205Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> querymap = new HashMap<Character, Character>();

        if (s.length() != t.length()) {
            return false;
        }


        /**for (int i = 0; i < s.length(); i++) {
            if (querymap.containsKey(s.charAt(i))) {
                if (querymap.get(s.charAt(i)) != t.charAt(i)) {
                    return false;
                }}


                if (querymap.containsKey(s.charAt(i))) {
                    if (querymap.containsValue(t.charAt(i))) {
                        return false;
                    }

                }**/


                //querymap.put(s.charAt(i), t.charAt(i));



        for (int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);

            // 检查是否已经存在 sChar 到 tChar 的映射
            if (querymap.containsKey(sChar)) {
                // 如果当前字符对应的映射值不等于 tChar，则返回 false
                if (querymap.get(sChar) != tChar) {
                    return false;
                }
            } else {
                // 检查是否已经有其他字符映射到 tChar，如果有则返回 false
                if (querymap.containsValue(tChar)) {
                    return false;
                }
                // 建立 sChar 到 tChar 的映射关系
                querymap.put(sChar, tChar);
            }
        }


        return true;
    }

    public static void main(String[] args) {
        A205Solution solution = new A205Solution();
        String s = "asdfghjkl";
        String t = "qwertyuio";
        System.out.println(solution.isIsomorphic(s,t));
    }
}
