class Solution {
    /**
     * @param x: An integer
     * @return: The sqrt of x
     */
    public int sqrt(int x) {
        // find the last number which square of it <= x
        long start =1, end =x;//注意类型
        while(start + 1 < end){
            long mid = start +(end - start)/2;//注意类型
            if(mid * mid <= x){
                start = mid;
            }
            else{
                end = mid;
            }
        }
        
        if(end *end <=x){
            return (int) end;
        }
        return (int) start;
    }
}

http://www.jiuzhang.com/solutions/sqrtx/

