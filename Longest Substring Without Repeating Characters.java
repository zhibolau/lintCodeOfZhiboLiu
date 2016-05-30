public class Solution {
    /**
     * @param s: a string
     * @return: an integer 
     */
    public int lengthOfLongestSubstring(String s) {
        // write your code here
        if (s == null || s.length() == 0) {
            return 0;
        }
        Map<Character, Integer> map = new HashMap<Character, Integer>();// 类型不能是char  得是 Character
        int last = -1;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
				//之前出现过c了 last之前为-1 所以只要是不同的字符就在当前index上加1就可以了
				//可是若出现了重复的字符 就不能继续加1了 所以得更新last
				//此时last为上次c出现的index 
				//下边在用i减去last就得到两个相同字符中间出现的不同字符数了 再与max作比较！！！！
                last = Math.max(last, map.get(c));
            }
            map.put(c, i);
            max = Math.max(max, i - last);// i - last means 当前i字符出现了几次 也就是不同的字符目前为止有几个了 
        }
        return max;
    }
}