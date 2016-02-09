public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number 
     *          and the index of the last number
     */
    public ArrayList<Integer> subarraySum(int[] nums) {
        // write your code here
        int len = nums.length;
        int sum = 0;
        ArrayList<Integer> result = new ArrayList<Integer>();//用来记录 index 范围
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();//用来查看是否sum=0了
        map.put(0, -1);// 别忘记 赋初始值
        for(int i = 0; i<len; i++){
            sum += nums[i];// 别忘了赋初始值给sum
            
            if(map.containsKey(sum)){
                result.add(map.get(sum) +1);
                result.add(i);
                return result;
            }
            
            map.put(sum, i);
            
        }
        
        return result;
    }
}


http://www.jiuzhang.com/solutions/subarray-sum/


