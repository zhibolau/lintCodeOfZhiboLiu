Follow up for "Search in Rotated Sorted Array":
What if duplicates are allowed?

Would this affect the run-time complexity? How and why?

Write a function to determine if a given target is in the array.


若版本1中有重复 咋办？？？？？？？？


public boolean search(int [] A,int target){
       if(A==null||A.length==0)
         return false;
        
       int low = 0;
       int high = A.length-1;
      
       while(low <= high){
           int mid = (low + high)/2;
           if(target < A[mid]){
			   //target比mid小
			   // 看 mid与high之间关系 3 种
               if(A[mid]<A[high])//right side is sorted 
                 high = mid - 1;//target must in left side
               else if(A[mid]==A[high])//cannot tell right is sorted, move pointer high
			   //mid与high之间有可能有拐点 
                 high--;
               else//left side is sorted A[mid]>A[high]
			   //目标 与 high都比 mid小
                 if(target<A[low])//说明目标不在左边
                    low = mid + 1;
                 else //low<target<MID >HIGH
                    high = mid - 1;
           }else if(target > A[mid]){
               if(A[low]<A[mid])//left side is sorted
                 low = mid + 1;//target must in right side
               else if(A[low]==A[mid])//cannot tell left is sorted, move pointer low
                 low++;
               else//right side is sorted
                 if(target>A[high])
                    high = mid - 1;
                 else
                    low = mid + 1;
           }else
             return true;
       }
       
       return false;
}

