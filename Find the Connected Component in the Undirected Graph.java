/**
 * Definition for Undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     ArrayList<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    /**
     * @param nodes a array of Undirected graph node
     * @return a connected set of a Undirected graph
     */
    public List<List<Integer>> connectedSet(ArrayList<UndirectedGraphNode> nodes) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();// list 是抽象的 不能被new 所以得用arrayList
        if(nodes == null || nodes.size() <= 0){
            return res;
        }
        HashMap<UndirectedGraphNode, Boolean> hm = new HashMap<UndirectedGraphNode, Boolean>();//用来记录node是不是被访问过的 Boolean 得大写B
        for(UndirectedGraphNode node : nodes){
            hm.put(node, false);
        }
        
        for(UndirectedGraphNode node : nodes){
            if(hm.get(node) == false){
                bfs(node, hm, res);
            }
        }
        return res;
    }
    
    public void bfs(UndirectedGraphNode node, HashMap<UndirectedGraphNode, Boolean> hm, List<List<Integer>> res){
        LinkedList<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>(); //用来放邻居的 左边类型是 Queue也行 右边就不行  Queue is abstract; cannot be instantiated
        List<Integer> row = new ArrayList<Integer>();//是来记录当前结果的
        //list 是抽象的 不能被new 所以得用arrayList
        hm.put(node, true);
        queue.offer(node);// queue 的add 叫 offer
        
        while(!queue.isEmpty()){
            UndirectedGraphNode u = queue.poll();
            row.add(u.label); // 注意构造方法 
            for(UndirectedGraphNode nei : u.neighbors){//此时看邻居不能用node了 得用u了
                if(hm.get(nei) == false){
                    //更新nei visited状态
                    hm.put(nei, true);
                    queue.offer(nei);
                }
            }
        }
        Collections.sort(row);//必须得有这句
        res.add(row);
    }
}