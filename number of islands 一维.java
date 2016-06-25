public int numOfIslands(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int count = 0;
        
        if (nums[0] == 1) {
            count++;
        } 
        
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == 1 && nums[i-1] == 1) {
                count++;
            }
        }
        
        return count;
    }
	
	
