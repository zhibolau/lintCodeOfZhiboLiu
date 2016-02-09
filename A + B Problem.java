class Solution {
    /*
     * param a: The first integer
     * param b: The second integer
     * return: The sum of a and b
     */
    public int aplusb(int a, int b) {
        if(b == 0){
            return a;
        }
        int sum = a ^ b; //按位异或
        int carry = (a & b) << 1; // 按位与
        /*
        java中有三种移位运算符

<<      :     左移运算符，num << 1,相当于num乘以2

>>      :     右移运算符，num >> 1,相当于num除以2

>>>    :     无符号右移，忽略符号位，空位都以0补齐

        */
        return aplusb(sum, carry);
    }
};