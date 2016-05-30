这道题也是3sum的变体，这里找到的不仅使3sum==target，同时如果没有找到==target的3sum要返回最接近target的值。
于是，这就需要在使用二分查找法时遍历数组的时候，维护一个最接近target值min，这样当完全遍历完数组扔没找到与target相等的3sum时，可以返回维护的这个min值。
这道题比3sum和4sum简单的地方就是不需要判断重复问题，因为题目给我们减轻了去重的压力，have exactly one solution。
即便要求去重，使用之前说过的两个方法：HashSet和挪动指针法，也可以很容易就去重了。
这里要注意，判断closest的方法是采取target-sum的绝对值与min相比，很容易理解，无论这个closest是在target左还是右，离target最近的就是最closest的。


public class Solution {
    /**
     * @param numbers: Give an array numbers of n integer
     * @param target : An integer
     * @return : return the sum of the three integers, the sum closest target.
     */
    public int threeSumClosest(int[] numbers ,int target) {
        // write your code here
        
        int len = numbers.length;
        if(numbers == null || len < 3){
            return -1;
        }
        int val = 0; //当前sum值
        int min = Integer.MAX_VALUE; // 当前剩余需要值
        Arrays.sort(numbers);
        for(int i = 0; i < len-2; i++){//要找个三个数一起加，所以要减2，最后俩数要空着要给start end
            int start = i+1;
            int end = len - 1;
            while(start <  end){
                int sum = numbers[i] + numbers[start] + numbers[end];
                if(Math.abs(target - sum) < min){//遇到closest就要想到abs，因为左右两边都可以接近
                    min = Math.abs(target - sum);//找到min 用val记录当前sum值
                    val = sum;
                }
                if (target == sum){
                    return val;// val在上边的if loop中被更新过了 就是sum的值
                }
                else if(sum > target){
                    end--;
                }
                else{
                    start++;
                }
            }
            
            
        }
        return val;
    }
}



	http://www.cnblogs.com/springfor/p/3860175.html
	
	
	http://blog.welkinlan.com/2014/09/26/2sum-3sum-4sum/   2分法查找
	
	
	