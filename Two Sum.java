public class Solution {
    /*
     * @param numbers : An array of Integer
     * @param target : target = numbers[index1] + numbers[index2]
     * @return : [index1 + 1, index2 + 1] (index1 < index2)
     */
    public int[] twoSum(int[] numbers, int target) {
        // write your code here
        int len = numbers.length;
        int[] res = new int[2];
        if(numbers == null || len < 2){
            return null;
        }
        
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i< len; i++){
            if(map.containsKey(numbers[i])){
                int index = map.get(numbers[i]);
                res[0] = index + 1;
                res[1] = i +1;
            }
            else{
                //因为是找2个数， 所以看target减去的前一个数后余下的值是否在array中
                map.put(target - numbers[i] , i);
            }
        }
        return res;
    }
}

http://blog.welkinlan.com/2014/09/26/2sum-3sum-4sum/



http://www.cnblogs.com/springfor/p/3859618.html


