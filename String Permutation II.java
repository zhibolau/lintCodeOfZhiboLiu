public class Solution {
    /**
     * @param str a string
     * @return all permutations
     */
    public List<String> stringPermutation2(String str) {
        List<String> res  = new ArrayList<String>();//List is abstract; cannot be instantiated
        if(str == null || str.length() < 0){//这里不可以有= 要处理 “” 情况 empty string
            return res;
        }
        char[] chars = str.toCharArray();//把字符串转化成字符数组好处理 最后加入res是再转化成字符串
        help(res, chars, 0);
        return res;
    }
    
    public void help(List<String> res, char[] chars, int pos){
        int len = chars.length;
        if(pos == len){
            //说明pos到头儿了 permutation结束了  所以加进res中
            res.add(new String(chars)); //要用new
        }
        Set<Character> hs = new HashSet<Character>();//每叫一次help 就会new一个set hs 所以不会出现添不进去character的时候
        for(int i = pos; i < len; i++){
            char cur = chars[i];
            if(hs.add(cur)){
                //hs中无此元素 就可以加入
                swap(chars, i, pos);
                help(res, chars, pos + 1);//进行pos往后挪一位 swap就能用上了
                swap(chars, i, pos);//维护现场
            }
        }
    }
    
    public void swap(char[] chars, int i, int j){
        char cur = chars[i];
        chars[i] = chars[j];
        chars[j] = cur;
    }
}