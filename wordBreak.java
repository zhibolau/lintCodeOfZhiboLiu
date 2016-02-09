// public class Solution {
//     /**
//      * @param s: A string s
//      * @param dict: A dictionary of words dict
//      */
//     public boolean wordBreak(String s, Set<String> dict) {
//         // write your code here   
//         // int len = s.length(); // string 的长度要有（） 此法可以但是超过时间限制！！！
//         // boolean can[] = new boolean[len + 1];
//         // can[0] = true;
//         // for (int i = 1; i<=len; i ++){
//         //     for (int j = 0; j < i; j++){
//         //         if (can[j] && dict.contains(s.substring(j,i))){
//         //             can[i] = true;
//         //             break;
//         //         }
//         //     }
//         // }
//         // return can[len];
        
//     }
// }
public class Solution {
	//获得dict中最长单词长度
    public int maxLength(Set<String> dict){
        int maxLen = 0;
        for (String word : dict){
            maxLen = Math.max(maxLen, word.length());
        }
        return maxLen;
    }

    public boolean wordBreak(String s, Set<String> dict) {
        int len = s.length();
        if (s == null || len== 0){
            return true;
        }
        int maxLen = maxLength(dict);
        boolean can[] = new boolean[len + 1];
        can[0]= true;
		//是否因为要用到can[0]= true; 所以下边才从1 开始？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？
        for (int i = 1; i <= len; i++){
            //can[i]=false; 不写这个没事 测试了
            for (int j = 1; j<=maxLen && j<=i; j++){//不要忘写int
            //j比maxLen没意义 单词不能比他长
                if (!can[i - j]){//若头字母都是false就不必执行下边
                    continue;
                }
                String word = s.substring(i-j, i);// 头字母是true就截取出word 然后检查
                if (dict.contains(word)){
                    can[i]=true;
                    break;
                }
            }
        }
        return can[len];
}
}