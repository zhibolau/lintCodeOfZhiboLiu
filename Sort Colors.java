class Solution {
    /**
     * @param nums: A list of integer which is 0, 1 or 2 
     * @return: nothing
     */
     public void swapNode(int [] a, int m, int n){
         int temp = a[m];
         a[m] = a[n];
         a[n] = temp;
         
     }
    public void sortColors(int[] nums) {
        // write your code here
        
        if(nums == null || nums.length ==0){
            return;
        }
        
        int len = nums.length;
        
        //0     1   2
        //red white blue 
        
        int notRed =0;
        int notBlue = len - 1;  // 他俩之间就是white
        
        //找到第一个不是red的index
        while(notRed < len && nums[notRed] == 0){
            //若当前是red 就向下找
            notRed ++;
        }
        
        while(notBlue >= 0 && nums[notBlue] == 2){
            notBlue --;
        }
        
        int i = notRed; //开始遍历
        
        while(i <= notBlue){// notBlue 右边的都是blue
            if(nums[i] == 0){
                swapNode(nums, i, notRed);
                notRed++;
                i++;
            }
            else if(nums[i] == 2){
                swapNode(nums, i, notBlue);
                notBlue--;
            }
            else{
                i++;
            }
        }
    }
}

题解：

这道题就是运用指针来解决了，可以说叫3指针吧。

一个指针notred从左开始找，指向第一个不是0（红色）的位置；一个指针notblue从右开始往左找，指向第一个不是2（蓝色）的位置。

然后另一个新的指针i指向notred指向的位置，往后遍历，遍历到notred的位置。

这途中需要判断：

当i指向的位置等于0的时候，说明是红色，把他交换到notred指向的位置，然后notred++，i++。

当i指向的位置等于2的时候，说明是蓝色，把他交换到notblue指向的位置，然后notred--。

当i指向的位置等于1的时候，说明是白色，不需要交换，i++即可。


笔记图 