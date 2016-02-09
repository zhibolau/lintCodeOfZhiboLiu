Comparator
http://www.tutorialspoint.com/java/java_using_comparator.htm

PriorityQueue 
http://www.tutorialspoint.com/java/util/java_util_priorityqueue.htm


     // 用来创建arrays当中 每个array的每个元素用的
     class Element{
         public int row, col, val;
         Element (int row, int col, int val){
            this.row= row;
            this.col= col;
            this.val= val; 
         }
         
     }
public class Solution {
    /**
     * @param arrays k sorted integer arrays
     * @return a sorted array
     */
     
     
    
        // Write your code here
        private Comparator<Element> ElementComparator = new Comparator<Element>(){
            public int compare(Element left, Element right){
                return left.val - right.val;
            }
        };//not forget ;
        
        public List<Integer> mergekSortedArrays(int[][] arrays) {    
            if(arrays == null){
                return new ArrayList<Integer>(new Integer(0));
                //此时new出来的是ArrayList 不是List， List是abstract的 不可以被new出来
            }
            int totalSize = 0;
            int len = arrays.length;
            Queue<Element> Q = new PriorityQueue<Element>(len, ElementComparator);
            
            for(int i = 0; i<len; i++){
                //若是子array 有元素
                if(arrays[i].length > 0){
                    //把每个array手元素放入Q中
                    Element elem = new Element(i,0, arrays[i][0]);
                    Q.add(elem);// 会根据ElementComparator往里面jia
                    //也就是说add后是排过序的
                    totalSize += arrays[i].length;
                }
            }
                
                List<Integer> result = new ArrayList<Integer> (new Integer(totalSize));
                int index =0;
                
                while(!Q.isEmpty()){
                    Element elem = Q.poll();
					// 指定下标添加（添加后下标后的元素向后挪一位）：list.add(index,e);
                    result.add(index++, elem.val);
                    //把每个array中的未加入过Q的元素加进去 自己会按照ElementComparator往里面加
                    if(elem.col + 1 < arrays[elem.row].length){
                        //col用来遍历array中的元素， 跟array.length比较 是否到头儿了
                        // row用来找到每个array的
                        elem.col += 1;
                        elem.val = arrays[elem.row][elem.col];
                        Q.add(elem);
                    }
                }
                return result;
            }
}
		
		
		http://blog.csdn.net/friendan/article/details/17529683
		
		
		http://www.jiuzhang.com/solutions/merge-k-sorted-arrays/
		
		
		