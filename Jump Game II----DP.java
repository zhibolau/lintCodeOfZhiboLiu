public class Solution {
    /**
     * @param A: A list of lists of integers
     * @return: An integer
     */
     
    public int jump(int[] A) {
        // write your code here
        int len = A.length;
        
        //DP
        int []steps = new int[len];
        steps[0] = 0;
        for (int i =1; i < len ; i++){
            //steps[i] = Integer.MAX_VALUE; 没有此行也没关系。。。已测试。。。
            for(int j = 0; j<i; j++){
                if (//steps[j] != Integer.MAX_VALUE && 
                    //没有上1行也没关系。已测试。。。
                j + A[j] >= i){
                    steps[i] = steps[j] + 1;
                    break;//不要忘了
                }
            }
        }
        return steps[len - 1];
        
        //GREEDY
        
    }
}

