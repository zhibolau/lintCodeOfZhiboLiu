把string 变成 integer

String to Integer II

Implement function atoi to convert a string to an integer.

If no valid conversion could be performed, a zero value is returned.

If the correct value is out of the range of representable values, INT_MAX (2147483647) or INT_MIN (-2147483648) is returned.


"10" => 10
"-1" => -1
"123123123123123" => 2147483647
"1.0" => 1


 越界问题？

 正负号问题？

 空格问题？

 精度问题？


public class Solution {
    /**
     * @param str: A string
     * @return An integer
     */
    public int atoi(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        str = str.trim();//str中可能有空格 所以要去掉  trim会把 “ abc cda ”变成“abc cda”
        int sign = 1;
        int cur = 0;
        if (str.charAt(0) == '+') {//此时因为trim过所以要看第0个位置 最开始的位置
			//若用cur放在0 会出现 +-111  这样的情况 会return-111  实际上这种数字是违法的 应该返回0！！！！！！！！！！！！！！
            cur++;//因为符号没用 不是数字 所以++ 看下一个位置是啥
        }
        if (str.charAt(0) == '-') {//看是不是负数的str
            cur++;
            sign = -1;
        }
        long rst = 0;	
        while (cur < str.length()) {
            char c = str.charAt(cur);
			//注意Character.isDigit(c)用法
            if (Character.isDigit(c)) {//isDigit会看当前char是不是数字的‘5’ 会返回true ‘c'返回false
                int digit = (int)(c - '0');//因为 10 会先遇见1 所以下次遇见0的时候要把res=1 *10 变成10 再加 0那个数字 走个例子
                rst = rst * 10 + (long)(digit);
                if (sign * rst >= Integer.MAX_VALUE) {
                    return Integer.MAX_VALUE;
                }
                if (sign * rst <= Integer.MIN_VALUE) {
                    return Integer.MIN_VALUE;
                }
                cur++;//别忘记
            } else {//不是digit了 就直接return了
                return (int)(sign * rst);
            }
        }
        return (int)(sign * rst);
    }
}



这种情况呢  “11111+” ？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？
是return 0 还是 11111 