public class Solution {
    /**
     * @param s A string
     * @return Whether the string is a valid palindrome
     */
    public boolean isPalindrome(String s) {
        // Write your code here
        
        if (s.length() == 0) {//s.length() == 0
            return true;// u can ask interviewer if empty string is true or false
        }
        s= s.toUpperCase();
        int low1 = 'A', high1 = 'Z', low2 = '0', high2 = '9';//single quote
        int low = 0;
        int high = s.length() - 1;
        
        while(low < high){

            //若low 或 high 对应character值不在low1 high1 区间 就 改变 low  high
            if( (s.charAt(low) < low1 || s.charAt(low) > high1) &&//注意（）  必须得有！！！！！！！！！！！！！！！！！！！！
                (s.charAt(low) < low2 || s.charAt(low) > high2) ){
                    low++;
                    continue;
            }
            else if( (s.charAt(high) < low1 || s.charAt(high) > high1) &&
                (s.charAt(high) < low2 || s.charAt(high) > high2) ){
                    high--;
                    continue;
                }
               
            else if(s.charAt(low) == s.charAt(high)){
                   low++;
                   high--;
               }
            else{
               return false;}
               
                
        }
        return true;
        
        
    }
}

http://www.cnblogs.com/springfor/p/3884156.html


这道题的几个点，

一就是alphanumeric characters and ignoring cases，字母和数字，忽略大小写。 

二就是考虑空字符串是否为回文，最好在面试时候问下面试官，这里是认为空字符串是回文。

因为忽略大小写，所以就统一为大写。

然后就判断当前检查字符是否符合范围，否则大小指针挪动。

如果发现有大小指针指向的值有不同的，就返回false，否则，继续检查。

最后返回true。


