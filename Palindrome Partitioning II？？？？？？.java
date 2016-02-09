Given a string s, partition s such that every substring of the partition is a palindrome.

Return the minimum cuts needed for a palindrome partitioning of s.

For example, given s = "aab",
Return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut.

 

 

题解：

 这道题需要用动态规划做，如果用I的DFS的方法做会TLE。

 

 首先设置dp变量 cuts[len+1]。cuts[i]表示从第i位置到第len位置（包含，即[i, len])的切割数（第len位置为空）。

 初始时，是len-i。比如给的例子aab，cuts[0]=3，就是最坏情况每一个字符都得切割：a|a|b|' '。cuts[1] = 2, 即从i=1位置开始，a|b|' '。

 cuts[2] = 1 b|' '。cuts[3]=0,即第len位置，为空字符，不需要切割。

 

 上面的这个cuts数组是用来帮助算最小cuts的。

 

 还需要一个dp二维数组matrixs[i][j]表示字符串[i,j]从第i个位置（包含）到第j个位置（包含） 是否是回文。

 如何判断字符串[i,j]是不是回文？

 1. matrixs[i+1][j-1]是回文且 s.charAt(i) == s.charAt(j)。

 2. i==j（i，j是用一个字符）

 3. j=i+1（i，j相邻）且s.charAt(i) == s.charAt(j)

 

 当字符串[i,j]是回文后，说明从第i个位置到字符串第len位置的最小cut数可以被更新了，

 那么就是从j+1位置开始到第len位置的最小cut数加上[i,j]|[j+1,len - 1]中间的这一cut。

 即，Math.min(cuts[i], cuts[j+1]+1) 

 最后返回cuts[0]-1。把多余加的那个对于第len位置的切割去掉，即为最终结果。

 

 代码如下：

复制代码
 1     public int minCut(String s) {  
 2         int min = 0;  
 3         int len = s.length();  
 4         boolean[][] matrix = new boolean[len][len];  //用来记录从i到j是不是回文的
 5         int cuts[] = new int[len+1];  //用来记录当前可以有几个cut cut之后不一定都是回文
 6           
 7         if (s == null || s.length() == 0)  
 8             return min;  
 9          
10         for (int i=0; i<len; ++i){  
11             cuts[i] = len - i;  //cut nums from i to len [i,len]
12         }  
13           
14         for (int i=len-1; i>=0; --i){  
15             for (int j=i; j<len; ++j){  
					//if之后用来判断cut之后是不是回文的
16                 if (s.charAt(i) == s.charAt(j) && ((j-i<2)  // j-i<2 是给base case 准备的 早晚得到这里或者i j相邻 或者他俩相等
17                         || matrix[i+1][j-1]))  
18                 {  
19                     matrix[i][j] = true;  
20                     cuts[i] = Math.min(cuts[i], cuts[j+1]+1);  
21                 }  
22             }  
23         }  
24         min = cuts[0]-1;  
25         return min;  
26     }
复制代码
 Reference：http://blog.csdn.net/ljphhj/article/details/22573983
 
 
 
 牛逼讲解：  http://blog.csdn.net/yutianzuijin/article/details/16850031
 
 