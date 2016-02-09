public class Solution {
    /**
     * @param num: Given the candidate numbers
     * @param target: Given the target number
     * @return: All the combinations that sum to target
     */
    public List<List<Integer>> combinationSum2(int[] num, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        ArrayList<Integer> item = new ArrayList<Integer>();
        int len = num.length;
        if(num == null || len <= 0){
            return res;
        }
        Arrays.sort(num);
        boolean[] visited = new boolean[len];
        help(num, target, 0, item, res, visited);
        return res;
    }
    public void help(int[] num, int target, int start, ArrayList<Integer> item, List<List<Integer>> res, boolean[] visited){
        int len = num.length;
        if(target < 0){
            return;
        }
        else if(target == 0){
            if(!res.contains(item)){
                res.add(new ArrayList<Integer>(item));// 此地得新建一个item  不是直接item放入
            }
            return;
        }
        for(int i = start; i < len; i++){
            if(!visited[i]){
                item.add(num[i]);
                visited[i] = true;// 当前访问要更新 别忘记
                int newTarget = target - num[i];
                help(num, newTarget, i+1, item, res, visited);
                visited[i] =false;// 删除之前要设为false 因为他还有可能跟别人组成target
                item.remove(item.size() - 1);
            }
        }
    }
}


题解：

这道题跟combination sum本质的差别就是当前已经遍历过的元素只能出现一次。

所以需要给每个candidate一个visited域，来标识是否已经visited了。

当回退的时候，记得要把visited一起也回退了。