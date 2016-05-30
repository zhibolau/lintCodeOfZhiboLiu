public class Solution {
    /**
     * @param str: a string
     * @return: a boolean
     */
    public boolean isUnique(String str) {
        // write your code here
        if(str ==null || str.length() <2){
            return true;
        }
        boolean[] b = new boolean[256];
        for(int i=0;i<256;i++){
            b[i] = false;
        }
        
        for(int i=0;i<str.length();i++){
            if(b[str.charAt(i)]){
                return false;
            }
            b[str.charAt(i)] = true;
        }
        return true;
    }
}

考察ascII码


看看str中是不是都是不同的字符！！