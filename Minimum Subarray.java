public class Solution {
    /**
     * @param nums: a list of integers
     * @return: A integer indicate the sum of minimum subarray
     */
    public int minSubArray(ArrayList<Integer> nums) {
        // write your code
        int len = nums.size();
        if(nums == null || len ==0){
            return -1;
        }
        
        int globalSum = Integer.MAX_VALUE, curSum = 0;
        for(int i = 0; i < len; i++){
			//得到当前的sum
            int localSum =curSum + nums.get(i);
            //curSum 与 globalSum前后顺序没关系
			//更新curSum 要最小的。。。。。。。。。。 注意与0的关系
            curSum = localSum > 0? 0: localSum;
			//更新globalSum 要他最小
            globalSum = localSum < globalSum ? localSum : globalSum;
        }
        
        return globalSum;
        
    }
}

http://hehejun.blogspot.com/2015/01/lintcodeminimum-subarray.html

http://www.jiuzhang.com/solutions/minimum-subarray/



http://blog.csdn.net/l243225530/article/details/41489237

将数组中的第一个数假设为最小子段和minSum，定义一个中间变量tempSum存储计算出的子段和，若tempSum的值小于或者等于零的话，就向后继续加；
若大于零的话，则将当前的元素作为最小子段和赋值给tempSum。
没做完一次最小子段和计算后，将tempSum和minSum进行比较，若tempSum小于minSum，则将tempSum中的值赋值给minSum，作为暂时的最小子段和，最后返回minSum。