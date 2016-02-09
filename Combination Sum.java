public class Solution {
    /**
     * @param candidates: A list of integers
     * @param target:An integer
     * @return: A list of lists of integers
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();//注意泛型类型！！！！
        ArrayList<Integer> item = new ArrayList<Integer>();
        int len = candidates.length;
        if(candidates == null || len <= 0)  {
            return res;
        }
        Arrays.sort(candidates);//别忘了排序
        help(candidates, target, 0, item, res);
        return res;
        
    }
    public void help (int[] candidates, int target, int start, 
    ArrayList<Integer> item, List<List<Integer>> res) {
        int len = candidates.length;
        if(target < 0){
            return;
        }
        else if(target == 0){
            if(!res.contains(item)) {
                res.add(new ArrayList<Integer>(item));
            }
            
            return;
        }
        for(int i = start; i < len; i++){
            item.add(candidates[i]);
            int newTarget = target - candidates[i];
            help(candidates, newTarget, i, item, res);
            item.remove(item.size() - 1);
        }
    
    }
}


还是老问题，用DFS找解决方案，不同点是，这道题： The same repeated number may be chosen from C unlimited number of times.

所以，每次跳进递归不用都往后挪一个，还可以利用当前的元素尝试。

同时，这道题还要判断重复解。用我之前介绍的两个方法：

 1.       if(i>0 && candidates[i] == candidates[i-1])//deal with dupicate
                 continue; 

 2.       if(!res.contains(item)) 
                res.add(new ArrayList<Integer>(item));   

这两个方法解决。 