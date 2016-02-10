public class Solution {
    /**
     * @param n an integer
     * @return true if this is a happy number or false
     */
    public boolean isHappy(int n) {
        // Write your code here
        HashSet<Integer> hs = new HashSet<Integer>();
        while( n != 1){
            if(hs.contains(n)){//若之前出现过 说明还是会计算回来 不会到1  所以直接false
                return false;
            }
            hs.add(n);
            n = getNextHappy(n);
        }
        return true;// now n == 1 !!!!!!!!!!!!
    }
    
    public int getNextHappy(int n){
        int sum = 0;
        while(n != 0){// n==0 说明没有数需要计算了 
            sum +=(n%10) * (n%10);// 比如19 此步用来获得 9 * 9
            n /=10; //用于获得 1*1
        }
        return sum;
    }
}