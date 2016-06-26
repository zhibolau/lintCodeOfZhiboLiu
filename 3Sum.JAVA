//use hashset to avoid repeated arrays saves more codes


public class Solution {
    /**
     * @param numbers : Give an array numbers of n integer
     * @return : Find all unique triplets in the array which gives the sum of zero.
     */
    public ArrayList<ArrayList<Integer>> threeSum(int[] numbers) {
        // write your code here
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        HashSet<ArrayList<Integer>> hs = new HashSet<ArrayList<Integer>>();
        if(numbers == null || numbers.length <= 2){
            return res;
        }
        int len = numbers.length;
        Arrays.sort(numbers);
        
        for(int i = 0; i < len - 2; i++){
            
            int left = i + 1;
            int right = len - 1;
            
            while(left < right){
                int sum = numbers[i] + numbers[left] + numbers[right];
                
                if(sum == 0){
                    ArrayList<Integer> temp = new ArrayList<Integer>();
                    temp.add(numbers[i]);
                    temp.add(numbers[left]);
                    temp.add(numbers[right]);
                    if(!hs.contains(temp)){
                        res.add(temp);
                        hs.add(temp);
                    }
                    
                    left++;
                    right--;
					
                }
                else if(sum > 0){
                    right--;
                }
                else{
                    left++;
                }
            }
        }
        
        return res;
        
        
    }
}
























public class Solution {
    /**
     * @param numbers : Give an array numbers of n integer
     * @return : Find all unique triplets in the array which gives the sum of zero.
     */
    public ArrayList<ArrayList<Integer>> threeSum(int[] numbers) {
        // write your code here
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        int len = numbers.length;
        if(numbers == null || len < 3){
            return res;
        }
        
        Arrays.sort(numbers);
        for(int i = 0; i<len - 2; i++){// -2是因为要有start 跟 end 要3个index  要给start跟end留下两个位置
            if(i == 0 || numbers[i] > numbers[i-1]){//后边的数要比前边大 要是一样大就不进入此loop 用来消除duplicate
			//若遇numbers[i] == numbers[i-1]) 就跳过 直接i++ 因为若上次已经成立 不要重复的 所以跳过！@！@@@@@@@@@！！！！！！！！！！！！！
			//i==0 确保要进入一次此循环 万一给的是-1 -1 2呢
                int negate = -numbers[i];
                
                int start = i + 1;
                int end = len - 1;
                
                while(start < end){
                    if(numbers[start] + numbers[end] == negate){
                        ArrayList<Integer> temp = new ArrayList<Integer>();//用来记录当前循环得到的符合条件的3个数
                        temp.add(numbers[i]);//加入的是数 不是index
                        temp.add(numbers[start]);
                        temp.add(numbers[end]);
                        
                        res.add(temp);
                        start++;
                        end--;
                        //用来remove start 跟end的重复数字
						//因为上边start已经++了 所以要看当前数与之前数是否一样 一样就再++ end同理！！！！！！！！！！！！！
                        while(start < end && numbers[start] == numbers[start - 1]){
                            start ++;
                        }
                        while(start < end && numbers[end] == numbers[end + 1]){
                            end --;
                        }
                    }
                    //比negate数大 证明需要再小一点的数 所以end-- 因为已经排序了
                    else if(numbers[start] + numbers[end] > negate){
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

http://blog.welkinlan.com/2014/09/26/2sum-3sum-4sum/


http://www.cnblogs.com/springfor/p/3859670.html  另一种方法
