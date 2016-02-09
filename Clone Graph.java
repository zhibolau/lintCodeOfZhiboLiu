/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     ArrayList<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    /**
     * @param node: A undirected graph node
     * @return: A undirected graph node
     */
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        // write your code here
        if  (node == null) {
            return node;
        }
        HashMap<UndirectedGraphNode, UndirectedGraphNode> hm = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        UndirectedGraphNode head = new UndirectedGraphNode(node.label);
        hm.put(node, head);
        dfs(hm, node);
        return head;
    }
    public void dfs(HashMap<UndirectedGraphNode, UndirectedGraphNode> hm, UndirectedGraphNode node){
        if(node == null) return;
        for(UndirectedGraphNode nei : node.neighbors){
            if(!hm.containsKey(nei)){
                UndirectedGraphNode newNei = new UndirectedGraphNode(nei.label);
                hm.put(nei, newNei);
                dfs(hm, nei);
            }
            hm.get(node).neighbors.add(hm.get(nei));
        }
    }
}


http://www.cnblogs.com/springfor/p/3874591.html



不太懂啊！！！！！！！！！！！


