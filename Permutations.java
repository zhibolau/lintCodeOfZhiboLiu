dfs 模型

class Solution {
    /**
     * @param nums: A list of integers.
     * @return: A list of permutations.
     */
    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> nums) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> item = new ArrayList<Integer>();
        
        if(nums == null || nums.size() <= 0){
            return res;
        }
        boolean[] visited = new boolean[nums.size()];
        dfs(nums, visited, item, res);
        return res;
    }
    public void dfs(ArrayList<Integer> nums, boolean[] visited, ArrayList<Integer> item, ArrayList<ArrayList<Integer>> res){
        int len = nums.size();
        if(item.size() == len){
            res.add(new ArrayList<Integer>(item));//每次加入的都是新建立的arrayList
            return;
        }
        else{
            for(int i = 0; i < len; i++){
                if(!visited[i]){//别忘记先检查此元素是否被visited过
                    visited[i] = true;
                    item.add(nums.get(i));//注意nums类型 是 int[] 还是arrayList
                    dfs(nums, visited, item, res);
                    visited[i] = false;
                    item.remove(item.size() - 1);// remove的是item的数量减1
                }
                
            }
        }
    }
}

注意在实现中有一个细节，就是在递归函数的前面，我们分别设置了used[i]的标记，表明改元素被使用，
并且把元素加入到当前结果中，而在递归函数之后，我们把该元素从结果中移除，并把标记置为false，这个我们可以称为“保护现场”，
递归函数必须保证在进入和离开函数的时候，变量的状态是一样的，这样才能保证正确性。当然也可以克隆一份结果放入递归中，但是那样会占用大量空间。
所以个人认为这种做法是最高效的，而且这种方法在很多题目（几乎所有NP问题）中一直用到，不熟悉的朋友可以练习一下哈


http://blog.csdn.net/linhuanmars/article/details/21569031

