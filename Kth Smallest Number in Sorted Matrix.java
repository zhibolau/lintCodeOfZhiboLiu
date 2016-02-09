public class Solution {
    /**
     * @param matrix: a matrix of integers
     * @param k: an integer
     * @return: the kth smallest number in the matrix
     * MLE
     */
    private class Node {
        int value;
        int x;
        int y;
        public Node(int value, int x, int y) {//把当前node值放在x y位置
            this.value = value;
            this.x = x;
            this.y = y;
        }
    }
    private class NodeComparator implements Comparator<Node> {
        public int compare(Node a, Node b) {
            return a.value - b.value;
        }
    }
    public int kthSmallest(int[][] matrix, int k) {
        // write your code here
        if (matrix.length < matrix[0].length) {
			//??????????为啥呢 第一横排元素个数比整个matrix的元素个数多 就一横排 一横排地找
			//			是不是更有可能在出现在个数多的地方  反正所有元素都得找一遍 
            return hSearch(matrix, k);
        } else {
            return vSearch(matrix, k);
        }
    }
    private int hSearch(int[][] matrix, int k) {
        Queue<Node> heap = new PriorityQueue<Node>(k, new NodeComparator());//得new出comparator
		//建造一个容量为k的以NodeComparator排列node顺序的queue queue为抽象类 所以不能实例化 所以new PQ
        for (int i = 0; i < Math.min(matrix.length, k); ++i) {//matrix的长度为row的个数！！！  横排看 row个数
			//横排可能没有k个元素 
            heap.offer(new Node(matrix[i][0], i, 0));//横排是 i,0 左边  要注意！！！
        }
        int rst = matrix[0][0];
        while (!heap.isEmpty() && k-- != 0) {
            Node n = heap.poll();
            rst = n.value;
            int x = n.x;
            int y = n.y;
            if (y + 1 < matrix[0].length) {//y+1为下一个数的纵坐标在同一行得小于长度
                heap.offer(new Node(matrix[x][y + 1], x, y + 1));
            }
            
        }
        return rst;
    }
    private int vSearch(int[][] matrix, int k) {
        Queue<Node> heap = new PriorityQueue<Node>(k, new NodeComparator());
        for (int i = 0; i < Math.min(matrix[0].length, k); ++i) {//matrix[0]的长度为column个数！！！
            heap.offer(new Node(matrix[0][i], 0, i));
        }
        int rst = matrix[0][0];
        while (!heap.isEmpty() && k-- != 0) {
            Node n = heap.poll();
            rst = n.value;
            int x = n.x;
            int y = n.y;
            if (x + 1 < matrix.length) {
                heap.offer(new Node(matrix[x + 1][y], x + 1, y));
            }
        }
        return rst;
    }
}