
public class Solution {
    public ArrayList<ArrayList<Integer>> kSumII(int A[], int k, int target) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        helper(result, new ArrayList<Integer>(), A, k, target, 0, 0);
        return result;
    }
    
    public void helper(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> preResult,
                int A[], int k, int target, int count, int start) {
        if (count == k && target == 0) {
            result.add(preResult);
            return;
        }
        if (count > k || target < 0) {//count >= k 也行
            return;
        }

        for (int i = start; i < A.length; i++) {
            if (target - A[i] >= 0) {
				//newResult 已经把preResult之前的结果放进去了
                ArrayList<Integer> newResult = new ArrayList<Integer>(preResult);
                newResult.add(A[i]);//把当前数加进去 因为target能容下当前数字
                helper(result, newResult, A, k, target-A[i], count+1, i+1);
            } else {
                break;
            }
        }
    }
}
    