class Solution {
    /**
     * @param nums: A list of integers.
     * @return: A list of unique permutations.
     */
    public ArrayList<ArrayList<Integer>> permuteUnique(ArrayList<Integer> nums) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> item = new ArrayList<Integer>();
        if( nums == null || nums.size() <= 0){
            return res;
        }
        boolean[] visited = new boolean[nums.size()];
        dfs(nums, visited, item, res);
        return res;
    }
    public void dfs(ArrayList<Integer> nums, boolean[] visited, ArrayList<Integer> item, ArrayList<ArrayList<Integer>> res){
        int numsLen = nums.size();
        int itemLen = item.size();
        if(numsLen == itemLen){
            if(!res.contains(new ArrayList<Integer>(item))){//去重用的 此地new ArrayList<Integer//>(item) 或者 直接放item 都行 已测试
                res.add(new ArrayList<Integer>(item));
                return;
            }
        }
        else{
            for(int i = 0; i < numsLen; i++){
                if(!visited[i]){
                    visited[i] = true;
                    item.add(nums.get(i));
                    dfs(nums, visited, item, res);
                    visited[i] = false;
                    item.remove(item.size() - 1);//此地不能用itemLen 本来item是变化的 //itemLen不变化！！！！！
                }
            }
        }
    }
}



这道题跟Permutaitons没啥大的区别，就是结果去重。

 我之前也有写过去重的两个方法:

 一个是在加入结果的时候用contains判断，一个是在找结果的时候看他是不是跟前一个元素相同。

 这道题还要考虑的是visited情况，前一个元素就算跟当前元素相同，如果visited==true也没关系。但是如果前面元素跟当前元素相同还没被visited，那么就要做去重处理了。
 
 
 
 