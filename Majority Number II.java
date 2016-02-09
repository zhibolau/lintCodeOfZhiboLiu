public class Solution {
    /**
     * @param nums: A list of integers
     * @return: The majority number that occurs more than 1/3
     */
    public int majorityNumber(ArrayList<Integer> nums) {
        // write your code
        
        if(nums.size() ==0 || nums == null){
            return -1;
        }
        //不能直接全等于0 要想那样 得先声明变量名字
        int candidate1 = 0, candidate2 = 0, count1 = 0, count2 = 0;
        //找到两个candidate
        for(int i =0; i < nums.size(); i++){
            if(candidate1 == nums.get(i)){
                count1 ++;
            }
            else if(candidate2 == nums.get(i)){
                count2 ++;
            }
            //若count1为0， 那么当前数就是count1的candidate1
            else if(count1 ==0){
                candidate1 = nums.get(i);
                count1 =1;
            }
            else if(count2 ==0){
                candidate2 = nums.get(i);
                count2 =1;
            }
            else{
                count1--;
                count2--;
            }
        }
        // 现在不知两个候选人 谁出现次数多 所以再遍历一次
        count1=count2 = 0;
        for(int j = 0; j<nums.size(); j++){
            if(nums.get(j) == candidate1){
                count1++;
            }
            else if(nums.get(j) == candidate2){
                count2++;
            }
        }
        
        return count1>count2 ? candidate1: candidate2;
    }
}


思路：
1. 选择两个candidate

2.scan数组，如果和两个candidate相等，则相应的candidate count+1；如果不相等，两个candidate 的counter都减1（前提是counter都大于0）；如果某一个counter已经等于0，那么替换candidate为当前数

3. 我们最后得到两个candidate，但是不知道谁更majority，因为一个例子就是1,1,1,1,3,3,3,2,2,2,5,5,5,最后candidate1=1， counter=1，candidate2=5，counter2=3，原因就是candidate1在之前被错误的抵消了很多。所以要再扫一遍。


http://m.blog.csdn.net/blog/nicaishibiantai/43635069



