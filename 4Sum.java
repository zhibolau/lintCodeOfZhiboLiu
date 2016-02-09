public class Solution {
    /**
     * @param numbers : Give an array numbersbers of n integer
     * @param target : you need to find four elements that's sum of target
     * @return : Find all unique quadruplets in the array which gives the sum of
     *           zero.
     */
    public ArrayList<ArrayList<Integer>> fourSum(int[] numbers, int target) {
        /* your code */
        HashSet<ArrayList<Integer>> hs = new HashSet<ArrayList<Integer>>();//不应在此建temp，不能把所有结果都加在一个里面
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        int len = numbers.length;
        if(numbers == null || len < 4){
            return res;
        }
        Arrays.sort(numbers);//别忘了此步！！！！！！！！！！
        for(int i=0; i<len-3; i++){
            for(int j = i+1; j<len-2; j++){
                int start = j + 1;
                int end = len - 1;
                while(start < end){
                    int sum = numbers[i] + numbers[j] +numbers[start] +numbers[end];
                    if(sum == target){
                        ArrayList<Integer> temp = new ArrayList<Integer>();
                        temp.add(numbers[i]);
                        temp.add(numbers[j]);
                        temp.add(numbers[start]);
                        temp.add(numbers[end]);
                        
                        if(!hs.contains(temp)){
                            hs.add(temp);//别忘了这步，用于以后检查用！！！
                            res.add(temp);
                        }
                        //别忘了更新start end
                        start++;
                        end--;
                    }
                    else if(sum > target){
                        end--;
                    }
                    else{
                        start++;
                    }
                }
                
                
                
            }
        }
        return res;
        
    }
}
4 sum跟3 sum是一样的思路，只不过需要多考虑一个加数，这样时间复杂度变为O(n3)。
http://www.cnblogs.com/springfor/p/3860076.html

