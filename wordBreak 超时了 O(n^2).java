public class Solution {
    /**
     * @param s: A string s
     * @param dict: A dictionary of words dict
     */
    public boolean wordBreak(String s, Set<String> dict) {
        // write your code here   
        int len = s.length(); // string 的长度要有（） 此法可以但是超过时间限制！！！
        boolean can[] = new boolean[len + 1];
        can[0] = true;
        for (int i = 1; i<=len; i ++){
            for (int j = 0; j < i; j++){
                if (can[j] && dict.contains(s.substring(j,i))){
                    can[i] = true;
                    break;
                }
            }
        }
        return can[len];
    }
}
