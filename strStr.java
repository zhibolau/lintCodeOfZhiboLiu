class Solution {
    /**
     * Returns a index to the first occurrence of target in source,
     * or -1  if target is not part of source.
     * @param source string to be scanned.
     * @param target string containing the sequence of characters to match.
     */
    public int strStr(String source, String target) {
        //write your code here
        if (source == null || target == null){
            return -1;
        }
        int sLength = source.length();
        int tLength = target.length();
        if (sLength < tLength) {
            return -1;
        }
        if (tLength == 0){
            return 0;
        }
        int i;
        for (i=0 ; i <=sLength - tLength ; i ++){
            if (source.charAt(i) == target.charAt(0)){
                int j;
                for (j=0; j<tLength; j++){
                    if (source.charAt(i+j) != target.charAt(j)){
						//从新的起点i再找
                        break;
                    }
                }
				//一直到tLen的时候还都一样就是找到target了
                if (j == target.length()) {
                return i;
                }
            }
            
        }
        return -1;
    }
}
