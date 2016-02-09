思路和Majority NumberII 一样，维护k-1个candidate 在map里面，key为数字值，value为出现次数。
先找到这k-1个candidate后，扫描所有元素，如果该元素存在在map里面，update map；
如果不存在，1： 如果map里面有值为count= 0，那么删除掉这个元素，加入新元素；
2：map里面没有0出现，那么就每个元素的count--

剩下的map里面的值都有可能是majority，所以重新扫描数组，记录下每一个元素出现次数，次数最大的就是majority


    public int majorityNumber(ArrayList<Integer> nums, int k) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int totalCan = 0;
        int i = 0;
		//维护k-1个candidate 在map里面，key为数字值，value为出现次数。
//			先找到这k-1个candidate
        while (totalCan < k && i < nums.size()) {
            int cur = nums.get(i);
            if (map.containsKey(cur)) {
                map.put(cur, map.get(cur) + 1);
            } else {
                map.put(cur, 1);
                totalCan++;
            }
            i++;
        }
		//扫描所有元素，如果该元素存在在map里面，update map；
        while (i < nums.size()) {//这里的i会承接上个while中的i最后的值吗？？？？？应该不是 我的code是新起的名字 j m ？？？？？？？？？？？？？？？？？？？？？
            int cur = nums.get(i);
            if (map.containsKey(cur)) {
                map.put(cur, map.get(cur) + 1);
            } else { // not match any candidate
			//如果map里面有值为count= 0，那么删除掉这个元素，加入新元素；
                if (map.values().contains(0)) {
                    map.put(cur, 1);
                    Integer zeroKey = null;
                    for (Map.Entry entry : map.entrySet()) {
                        if (entry.getValue().equals(0)) {
                            zeroKey = (Integer) entry.getKey();
                            break;
                        }
                    }
                    map.remove(zeroKey);//只要是有zeroKey的都被删除掉！！！！！！！！！！！！！！！！！！！！！
                } else {
					//map里面没有0出现，那么就每个元素的count--
                    for (Map.Entry entry : map.entrySet()) {
                        map.put((Integer) entry.getKey(), (Integer) entry.getValue() - 1);
                    }
                }
            }
            i++;
        }

        Map<Integer, Integer> newMap = new HashMap<Integer, Integer>();
        int maxCount = 0;
        int maxNum = 0;
        for (int j = 0; j < nums.size(); j++) {
            int cur = nums.get(j);
            if (map.containsKey(cur)) {
                newMap.put(cur, newMap.get(cur) == null ? 1 : newMap.get(cur) + 1);
                if (newMap.get(cur) > maxCount) {
                    maxCount = newMap.get(cur);
                    maxNum = cur;
                }
            }
        }
        return maxNum;
    }

	
	
	我的“”“”“”“”“：：：：：：：：：：：：：：：：：：
	
	
	public class Solution {
    /**
     * @param nums: A list of integers
     * @param k: As described
     * @return: The majority number
     */
    public int majorityNumber(ArrayList<Integer> nums, int k) {
        // write your code
        int len = nums.size();
        if(nums == null || len ==0){
            return -1;
        }
        
        int totalCandidates = 0, i = 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();//ForCandidate
        // 找到k-1 个候选人， 不一定遍历了所有元素
        while(totalCandidates < k && i <len){
            int cur = nums.get(i); //准备把当前数放入map中来找到k-1个候选人
            if(map.containsKey(cur)){//包含当前元素就更新他出现的次数
                map.put(cur, map.get(cur) + 1);
            }
            else{
                map.put(cur, 1);
            }
            i++;
        }
        // 遍历所有元素， 有就更新他， 没有： 出现0就删除当前，放入新， 没0就都--
        int j = 0;
        while(j < len){
            int cur = nums.get(j);
            if(map.containsKey(cur)){
                map.put(cur, map.get(cur) + 1);
            }
            else{
                if(map.values().contains(0)){
                    map.put(cur, 1);
                    Integer zeroKey = null;
                    for(Map.Entry entry : map.entrySet()){
                        if(entry.getValue().equals(0)){
                            zeroKey = (Integer) entry.getKey();
                            break;// 出去当前循环来 remove key
                        }
                    }
                    map.remove(zeroKey);
                }
                else{
                    for(Map.Entry entry : map.entrySet()){
                        map.put((Integer) entry.getKey(), (Integer) entry.getValue() - 1);
                    } 
                }
            }
            j++;
        }
        Map<Integer, Integer> newMap = new HashMap<Integer, Integer> ();
        int maxNum = 0;
        int maxCount = 0;
        int m = 0;
        while(m < len){
            int cur = nums.get(m);
            if(map.containsKey(cur)){
                newMap.put(cur, newMap.get(cur) ==null? 1: newMap.get(cur)+1);
                if(newMap.get(cur) > maxCount){
                    maxCount = newMap.get(cur);
                    maxNum = cur;
                }
            }
            m++;
        }
        
        return maxNum;
    }
}
