public class Solution {
    /**
     * @param nums: a list of integers
     * @return: find a  majority number
     */
    public int majorityNumber(ArrayList<Integer> nums) {
        // write your code
        if(nums == null || nums.size() ==0){
            return 0;
        }
        
        int count = 0, candidate = -1;
        for(int i =0; i<nums.size(); i++){
            if(count == 0){
                candidate = nums.get(i);
                count ++;
            }
            else if(candidate == nums.get(i)){
                count ++;
            }
            else{
				//现在的数 与 candidate 不一样 所以当前数要加1 相当于 candidate出现次数减1
                //找不到已经有的数了 有可能现在这个数就是最多出现数
                count--;
            }
        }
        return candidate;
    }
}