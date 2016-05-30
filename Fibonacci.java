class Solution {
    /**
     * @param n: an integer
     * @return an integer f(n)
     */
    public int fibonacci(int n) {
        // write your code here
        if(n == 1){
            return 0;
        }
        if(n == 2){
            return 1;
        }
        int n1 = 0, n2 = 1, sn = 0;
        for(int i = 0; i<n-2; i++){
            sn = n1+n2;//第三个数 所以i到小于n-2
            n1= n2;//第一个数变成第二个
            n2 =sn;//第二变成第三  以此类推
        }
        return sn;
    }
}





class Solution {
    /**
     * @param n: an integer
     * @return an integer f(n)
     */
    public int fibonacci(int n) {
        // write your code here
        if (n == 1) {
            return 0; 
        }
        if (n == 2) {
            return 1;
        }
        int first = 0;
        int second = 1;
        for (int i = 3; i <= n; i++) {
        	if ((i & 1) == 1) { //说明 i的二进制全可以用1表示 所以为基数 
        		first += second;
        	} else {//i为偶数
        		second += first;
        	}
        }
        return ((n & 1) == 1) ? first : second;
    }
}


递归超时

class Solution {
    /**
     * @param n: an integer
     * @return an integer f(n)
     */
    public int fibonacci(int n) {
        // write your code here
        if(n == 1){
            return 0;
        }
        if(n == 2){
            return 1;
        }
        else{
            return fibonacci(n-1) + fibonacci(n-2);
        }
    }
}





