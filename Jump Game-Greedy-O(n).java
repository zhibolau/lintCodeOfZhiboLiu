public class Solution {
    /**
     * @param A: A list of integers
     * @return: The boolean answer
     */
    public boolean canJump(int[] A) {
        // wirte your code here
         int len = A.length;
        // boolean [] can = new boolean[len];
        // can[0] = true;
        // for (int i =1; i <len; i++ ){//i从1 开始是因为 你最开始的位置在1
        //     for(int j = 0; j<i; j++){//从0开始来看第一个元素能走几个位置
        //         if (can[j] && j + A[j] >= i){//若当前是true，就看对应A中能走几个位置
        //         //加上当前位置是否大于等于要到的位置 i
        //             can[i] = true;
        //             break;
        //         }
        //     }
        // }
        // return can[len - 1];
        
        if (A ==null || len ==0){
            return false;
        }
        int range = A[0]; //from the current positon, I can move 2 steps forward
        for (int i = 1; i < len ; i ++){
            if (range >= i && range < i + A[i] ){
                range = i + A[i];
            }
        }
        return range >= len - 1; //刚开始在1， 所以少走1步
    }
}

