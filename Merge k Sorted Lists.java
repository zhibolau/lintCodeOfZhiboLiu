/**
 * Definition for ListNode.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int val) {
 *         this.val = val;
 *         this.next = null;
 *     }
 * }
 */ 
public class Solution {
    /**
     * @param lists: a list of ListNode
     * @return: The head of one sorted list.
     */
     private Comparator<ListNode> ListNodeComparator = new Comparator<ListNode>(){
         public int compare(ListNode left, ListNode right){
             //为了给加入到Q中的node排序
            if(left == null){
                return 1;//？？？？？？？？？
            } 
            if(right == null){
                return -1;
            } 
            else{
                return left.val - right.val;
            }
         }
     }; 
    
    public ListNode mergeKLists(List<ListNode> lists) { 
        int len = lists.size();
        if(lists == null || len==0){
            return null;
        }
        Queue<ListNode> Q = new PriorityQueue<ListNode>(len, ListNodeComparator);
        
        for(int i =0; i<len; i++){
            //若lists当中元素不是null 就放入heap中
            if(lists.get(i) != null){
                Q.add(lists.get(i));
                //加入的是头结点！！！！！！！！！！！！！！！！
            }
        }
        
        //新建结点 记录新的头结点
        ListNode newHead = new ListNode(0);
        ListNode tail = newHead;//用来遍历所有元素
        
        while(!Q.isEmpty()){
            ListNode head= Q.poll();
            tail.next = head;
            tail = head;// 用来连接当前list中的下一个结点
            if(head.next != null){
                Q.add(head.next);//add的是当前list的第二个结点， 因为头结点已经加入了
            }
        }
        return newHead.next;
        
    }
}

http://www.jiuzhang.com/solutions/merge-k-sorted-lists/

看笔记图


这个简单！！！！！！！！！！   http://www.cnblogs.com/springfor/p/3869217.html