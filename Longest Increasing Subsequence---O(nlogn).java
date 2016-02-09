public class Solution {
    /**
     * @param nums: The integer array
     * @return: The length of LIS (longest increasing subsequence)
     */
    public int longestIncreasingSubsequence(int[] nums) {
        // write your code here
        int len = nums.length;
        // int []f = new int[len]; // 用来记录num中每个元素组成LIS的长度
        // int max = 0;
        // for (int i = 0; i < len; i++){
        //     f[i] = 1; // 假设当前的为LIS的开始
        //     for(int j = 0; j < i; j++){
        //         // 看到当前为止 能否组成LIS
        //         //nums[j] 总在nums[i]之前
        //         if(nums[j] <= nums[i]){// 等于i 也可以算是个起点
        //         //i前边有一个数必当前i小了
        //         // i前边有一个数，那个数为0到j之间的
        //         // 那么我们就得更新记录LIS的array了
        //             if (f[i] < f[j] + 1){
        //                 //因为当前又有一个元素符合LIS了 所以f[j]才加的那个1
        //                 f[i] = f[j] + 1;
        //             }
        //             else{
        //                 f[i] = f[i];
        //             }
        //         } 
        //     }
        //     if (f[i] > max){
        //         max = f[i];
        //     }
        // }
        // return max;
        
        int ret = 0; // LIS的长度
        int lis[] = new int[len]; //记录组成LIS的每个元素
        for (int i : nums){// 对于nums中每个元素 此时i不是index
            if(ret ==0 || lis[ret - 1]<= i) lis[ret++] = i;
            else{/*
                若下一个数比当前数小的话，那就要找到第一个比当前数大的那个数的index
若下一个数a比当前数b小，那么下一个数a变成当前数，  b就被抛弃 没有用了
            
            */
                int index = getFirstBig(i, lis, ret);
                lis[index] = i;
            }
        }
        return ret;
    }
    public int getFirstBig(int i, int[] lis, int right){
        int left = 0;
        while(left < right - 1){ // 莫忘此句！！！！！！！！！
        int mid = left + (right - left)/2;
        if (lis[mid] == i) return mid;
        else if (lis[mid] > i) right = mid;
        else left = mid +1;
        }
        return lis[left] > i? left : right; // 用来抛弃5， 让4放在5原来的位置
    }
}

O(nLogn)