public class Solution {
    /**
     * @param nums: A list of integers
     * @return an integer
     */
    public int longestConsecutive(int[] num) {
        // write you code here
        int len = num.length;
        if(num == null || len <= 0){
            return 0;
        }
        
        HashSet<Integer> hs= new HashSet<Integer>();
        for( int i = 0; i< len; i++){
            hs.add(num[i]);
        }
        int max = 0;
        
        for(int i = 0; i<len; i++){
            if(hs.contains(num[i])){
                int count = 1;
                hs.remove(num[i]);
        
        int low = num[i]-1;
        while(hs.contains(low)){
            hs.remove(low);
            low--;
            count++;
        }
        int high = num[i]+1;
        while(hs.contains(high)){
            hs.remove(high);
            high++;
            count++;
        }
        max = Math.max(max, count);
            }
    }
    return max;
    }
}

题解：

这道题利用HashSet的唯一性解决，能使时间复杂度达到O(n)。首先先把所有num值放入HashSet，然后遍历整个数组，
如果HashSet中存在该值，就先向下找到边界，找的同时把找到的值一个一个从set中删去，然后再向上找边界，
同样要把找到的值都从set中删掉。所以每个元素最多会被遍历两边，时间复杂度为O(n)。


public int longestConsecutive(int[] num) {  
        if(num == null||num.length == 0)
            return 0;
        
        HashSet<Integer> hs = new HashSet<Integer>();  
        
        for (int i = 0 ;i<num.length; i++)   
            hs.add(num[i]);  
         
        int max = 0;  
        for(int i=0; i<num.length; i++){  
            if(hs.contains(num[i])){
                int count = 1;  
                hs.remove(num[i]);
                
                int low = num[i] - 1; 
                while(hs.contains(low)){  
                    hs.remove(low);  
                    low--;  
                    count++;  
                }
                
                int high = num[i] + 1;  
                while(hs.contains(high)){  
                    hs.remove(high);  
                    high++;  
                    count++;  
                }  
                max = Math.max(max, count);  
            }  
        }  
        return max;  
    }



    


