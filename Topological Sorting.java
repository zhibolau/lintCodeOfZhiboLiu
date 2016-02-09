public class Solution {
    /**
     * @param graph: A list of Directed graph node
     * @return: Any topological order for the given graph.
     */    
    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        // write your code here
        ArrayList<DirectedGraphNode> result = new ArrayList<DirectedGraphNode>();
        HashMap<DirectedGraphNode, Integer> map = new HashMap();
        //建立map 放入每个node value为次neighbour的parent数 看笔记就懂了
        for (DirectedGraphNode node : graph) {
            for (DirectedGraphNode neighbor : node.neighbors) {
                if (map.containsKey(neighbor)) {
                    map.put(neighbor, map.get(neighbor) + 1);
                } else {
                    map.put(neighbor, 1); 
                }
            }
        }
        Queue<DirectedGraphNode> q = new LinkedList<DirectedGraphNode>();
        for (DirectedGraphNode node : graph) {
            if (!map.containsKey(node)) {// 若此条件成立 证明map中无他 
                                        //那他就是头节点
                q.offer(node);
                result.add(node);
            }
        }
        while (!q.isEmpty()) {
            DirectedGraphNode node = q.poll();
            for (DirectedGraphNode n : node.neighbors) {
                map.put(n, map.get(n) - 1);//用一个邻居 就得把次数减1
                if (map.get(n) == 0) {//＝＝0时是 此节点无parent了 或者parent被poll了
                    // 那就得把当前节点放入 res 和 q中
                    result.add(n);
                    q.offer(n);
                }
            }
        }
        return result;
    }
}




/**
 * Definition for Directed graph.
 * class DirectedGraphNode {
 *     int label;
 *     ArrayList<DirectedGraphNode> neighbors;
 *     DirectedGraphNode(int x) { label = x; neighbors = new ArrayList<DirectedGraphNode>(); }
 * };
 */
public class Solution {
    /**
     * @param graph: A list of Directed graph node
     * @return: Any topological order for the given graph.
     */    
    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        // write your code here
        ArrayList<DirectedGraphNode> res = new ArrayList<DirectedGraphNode>();
        if (graph == null){
            return res;
        }
        HashMap<DirectedGraphNode , Integer> hm = new HashMap<DirectedGraphNode , Integer>();
        for(DirectedGraphNode node: graph){
            //看当前node 邻居的parent数
            for(DirectedGraphNode nei: node.neighbors){
                    if(hm.containsKey(nei)){
                    hm.put(nei, hm.get(nei) + 1);//放的是nei 不是node这里 注意！！！！！
                }
                else{
                    hm.put(nei, 1);
                }
            }
        }
        //Queue is abstract; cannot be instantiated
        Queue<DirectedGraphNode> q = new LinkedList<DirectedGraphNode>();//queue is already list, //泛型不用再arrayList了
        for(DirectedGraphNode nei: graph){
            if(!hm.containsKey(nei)){
                q.offer(nei);//插入 linkedlist用offer
                res.add(nei);
            }
        }
        
        while(!q.isEmpty()){
            DirectedGraphNode n = q.poll();
            for(DirectedGraphNode nei: n.neighbors){
                hm.put(nei, hm.get(nei) - 1);
                if(hm.get(nei) == 0){
                    res.add(nei);
                    q.offer(nei);
                }
            }
            
        }
        return res;
    }
}



http://blog.csdn.net/nicaishibiantai/article/details/43230615


