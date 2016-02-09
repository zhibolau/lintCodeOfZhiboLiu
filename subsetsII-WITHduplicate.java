class Solution {
    /**
     * @param S: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    public ArrayList<ArrayList<Integer>> subsetsWithDup(ArrayList<Integer> S) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList <Integer>> ();
        if (S == null || S.size() ==0){
            return result;
        }
        ArrayList<Integer> tempList = new ArrayList<Integer>();
        Collections.sort(S);
        subsetsHelper(result, tempList, S, 0);
        return result;
    }
    
    public void subsetsHelper(ArrayList<ArrayList <Integer>> result, ArrayList<Integer> tempList, ArrayList<Integer> nums, int currentPos){
        int i;
        result.add(new ArrayList<Integer> (tempList));
        
        
        for (i = currentPos; i < nums.size(); i++){
            if (i != currentPos && nums.get(i) == nums.get(i-1)){
            continue;
        }
            tempList.add(nums.get(i));
            subsetsHelper(result, tempList, nums, i+1);
            tempList.remove(tempList.size() - 1);
        }
    }
}

