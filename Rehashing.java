/**
 * Definition for ListNode
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    /**
     * @param hashTable: A list of The first node of linked list
     * @return: A list of The first node of linked list which have twice size
     */
    public ListNode[] rehashing(ListNode[] hashTable) {
        // write your code here
        if (hashTable.length <= 0) {
            return hashTable;
        }
        int newcapacity = 2 * hashTable.length;
        ListNode[] newTable = new ListNode[newcapacity];
        for (int i = 0; i < hashTable.length; i++) {
            //是null就什么也不做 进行下一个
            while (hashTable[i] != null) {
                //用给出的公式算新的index
                int newindex
                 = (hashTable[i].val % newcapacity + newcapacity) % newcapacity;
                 //若新index对应的newTable的值是null， 就把那个值放进去
                if (newTable[newindex] == null) {
                    newTable[newindex] = new ListNode(hashTable[i].val);
                   // newTable[newindex].next = null;
                } 
                //处理新表中要去的那个元素位置已经有元素在了 让新来的元素在当前元素后边就行
                else {
                    ListNode dummy = newTable[newindex];
                    while (dummy.next != null) {
                        dummy = dummy.next;
                    }
                    dummy.next = new ListNode(hashTable[i].val);
                }
                hashTable[i] = hashTable[i].next;
            }
        }
        return newTable;
    }
}




/**
 * Definition for ListNode
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    /**
     * @param hashTable: A list of The first node of linked list
     * @return: A list of The first node of linked list which have twice size
     */    
    public ListNode[] rehashing(ListNode[] hashTable) {
        // write your code here
        int len = hashTable.length;
        if(len <= 0){
            return hashTable;
        }
        
        int newCapacity = len * 2;
        
        ListNode[] result = new ListNode[newCapacity];
        
        for(int i = 0; i < len; i++){
            while(hashTable[i] != null){
                int newIndex = (hashTable[i].val % newCapacity + newCapacity) % newCapacity;
                if(result[newIndex] == null){
                    result[newIndex] = new ListNode(hashTable[i].val);
                }
                else{
                    //此时看的是result中对应的index是否有元素存在 不是原hashTable
                    ListNode dummy = result[newIndex];//此时要是newIndex不是i
                    while(dummy.next != null){
                        dummy = dummy.next;
                    }
                    dummy.next = new ListNode(hashTable[i].val);
                }
                hashTable[i] = hashTable[i].next;
            }
        }
        return result;
    }
}
