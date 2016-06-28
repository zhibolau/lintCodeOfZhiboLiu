

在一个有拐点的有序的array中找到目标值
用mid 更新mid


public class Solution {
    /** 
     *@param A : an integer rotated sorted array
     *@param target :  an integer to be searched
     *return : an integer
     */
    public int search(int[] A, int target) {
        // write your code here
        if (A == null || A.length == 0){
            return -1;
        }
        int start = 0, end = A.length - 1, mid, num;
        
        while(start < end - 1){
            mid = start + (end - start)/2;
            num = A[mid];
            if (num == target){
                return mid;
            } 
            else if (num > A[start]){//>可为>=
                // 因为是sorted 无重复 所以有无=都行
                if (target >= A[start] && target < num){
                    // >= 此时target已经不等于num了 所以有可能等于 start
                    end = mid - 1;
                }
                else{
                    start = mid + 1;
                }
            }
            else if (num < A[start])//此if可以加
            {
                if (target <= A[end] && target > num){
                    // >= 同理here
                    start = mid + 1;
                }
                else{
                    end = mid - 1;
                }
            }
        }
        return A[start] == target ? start : A[end] == target ? end : -1;
    }
}

// start  target num  //所有target 在start 跟mid 中间
// num  start target end  2 5  6  7

