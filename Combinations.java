public class Solution {
    /**
     * @param n: Given the range of numbers
     * @param k: Given the numbers of combinations
     * @return: All the combinations of k numbers out of 1..n
     */
    public List<List<Integer>> combine(int n, int k) {
		// write your code here
		List<List<Integer>> rst = new ArrayList<List<Integer>>();//ArrayList<List<Integer>>()  注意外面是arrayList 里面是list
        if (n == 0 || k == 0) {
            return rst;
        }
        List<Integer> items = new ArrayList<Integer>();
        helper(rst, items, n, k, 1);
        return rst;
    }
    public void helper(List<List<Integer>> rst, List<Integer> items,
                        int n, int k, int start) {
        if (k == 0) {
            rst.add(new ArrayList<Integer>(items)); // 要重新new items！！！！
        } else {
            for (int i = start; i <= n; i++) {
                items.add(i);
                helper(rst, items, n, k - 1, i + 1);
                items.remove(items.size() - 1);
            }
        }
    }
}
