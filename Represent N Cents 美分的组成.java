 Represent N Cents 美分的组成
 
 
 Given an infinite number of quarters (25 cents), dimes (10 cents), nickels (5 cents) and pennies (1 cent), 
 write code to calculate the number of ways of representing n cents.

 

这道题给定一个钱数，让我们求用quarter，dime，nickle和penny来表示的方法总和，很明显还是要用递归来做。比如我们有50美分，那么

makeChange(50) =

　　makeChange(50 using 0 quarter) +

　　makeChange(50 using 1 quarter) +

　　makeChange(50 using 2 quarters)

 

而其中第一个makeChange(50 using 0 quarter)又可以拆分为：

makeChange(50 using 0 quarter) =

　　makeChange(50 using 0 quarter， 0 dimes) + 

　　makeChange(50 using 0 quarter， 1 dimes) + 

　　makeChange(50 using 0 quarter， 2 dimes) + 

　　makeChange(50 using 0 quarter， 3 dimes) + 

　　makeChange(50 using 0 quarter， 4 dimes) + 

　　makeChange(50 using 0 quarter， 5 dimes)

 

而这里面的每项又可以继续往下拆成nickle和penny，整体是一个树形结构，计算顺序是从最底层开始，
也就是给定的钱数都是由penny组成的情况慢慢往回递归，加一个nickle，加两个nickle，再到加dime和quarter，参见代码如下：



/**  
  * numberOfWays(25, 3) = numberOfWays(25-1, 0) + numberOfWays(25-5, 1)  
  * + numberOfWays (25-10, 2) + numberOfWays (25-25, 3)  
  *   
  * numberOfWays(25-1, 0) = 1  
  * numberOfWays(25-5, 1) = numberOfWays(20, 1) = numberOfWays(20-1, 0)   
  * + numberOfWays(20-5, 1)   
  * ......   
  * @author zsunm  
  *  
  */  
 public class Coin {  
        
      private static final int[] COINS = {1, 5, 10, 25};  
        
      public static int numberOfWays(int n){  
           if (n == 0) return 0;  
           return numberOfWays(n, 3);  
      }  
        
      /**  
       * The number of ways to represent n cents by using the coins  
       * up to the specified coinIndex of the COINS array  
       * Example 1: numberOfWays(10, 2) means the number of ways  
       * to represent 10 cents using 1 cent, 5 cents, and 10 cents,   
       * because COINTS[2] = 10  
       *   
       * Example 2: numberOfWays(25, 3) means the number of ways  
       * to represent 25 cents using 1 cent, 5 cents, 10 cents, and 25 cents   
       * because COINTS[3] = 25  
       *   
       * @param n cents  
       * @param coinIndex the coin index of COINS array that can be used up to  
       * @return  
       */  
      private static int numberOfWays(int n, int coinIndex) {  
           if (n < 0){  
                return 0;  
           }  
           if (n == 0){  
                return 1;  
           }  
           int result = 0;  
           for (int i=0; i<=coinIndex; i++){  
                result += numberOfWays(n-COINS[i], i);  
           }  
           return result;  
      }
	  
	  
	  
	  
	  

class Solution {
public:
    int makeChange(int n) {
        vector<int> denoms = {25, 10, 5, 1};
        return makeChange(n, denoms, 0);
    }
    int makeChange(int amount, vector<int> denoms, int idx) {
        if (idx >= denoms.size() - 1) return 1;
        int val = denoms[idx], res = 0;
        for (int i = 0; i * val <= amount; ++i) {
            int rem = amount - i * val;
            res += makeChange(rem, denoms, idx + 1);
        }
        return res;
    }
};



class Solution {
public:
    int makeChange(int n) {
        vector<int> denoms = {25, 10, 5, 1};
        vector<vector<int> > m(n + 1, vector<int>(denoms.size()));
        return makeChange(n, denoms, 0, m);
    }
    int makeChange(int amount, vector<int> denoms, int idx, vector<vector<int> > &m) {
        if (m[amount][idx] > 0) return m[amount][idx];
        if (idx >= denoms.size() - 1) return 1;
        int val = denoms[idx], res = 0;
        for (int i = 0; i * val <= amount; ++i) {
            int rem = amount - i * val;
            res += makeChange(rem, denoms, idx + 1, m);
        }
        m[amount][idx] = res;
        return res;
    }
};


 