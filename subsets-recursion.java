class Solution {
    /**
     * @param S: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    public ArrayList<ArrayList<Integer>> subsets(int[] nums) {
        // write your code here
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList <Integer>> ();
        if (nums == null || nums.length ==0){
            return result;
        }
        ArrayList<Integer> tempList = new ArrayList<Integer>();
        Arrays.sort(nums);
        subsetsHelper(result, tempList, nums, 0);
        return result;
    }
    
    public void subsetsHelper(ArrayList<ArrayList <Integer>> result, ArrayList<Integer> tempList, int[] nums, int currentPos){
        int i;
        result.add(new ArrayList<Integer> (tempList));
        
        for (i = currentPos; i < nums.length; i++){
            tempList.add(nums[i]);
            subsetsHelper(result, tempList, nums, i+1);
            tempList.remove(tempList.size() - 1);
        }
    }
}
