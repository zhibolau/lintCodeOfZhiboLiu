public ArrayList<String[]> solveNQueens(int n) {
        ArrayList<String[]> res = new ArrayList<String[]>();
        if(n<=0)
            return res;
            
		/*
			经典的DFS递归回溯解法，大体思路就是对每一行，按每一列挨个去试，试到了就保存结果没试到就回溯。
难点大概就是用1个一维数组存皇后所在的坐标值。对于一个棋盘来说，每个点都有横纵坐标，用横纵坐标可以表示一个点。
而这道题巧就巧在，每一行只能有一个皇后，也就是说，对于一行只能有一个纵坐标值，所以用1维数组能提前帮助解决皇后不能在同一行的问题。
那么用一维数组表示的话，方法是：一维数组的下标表示横坐标（哪一行），而数组的值表示纵坐标（哪一列）。

例如：对于一个4皇后问题，声明一个长度为4的数组（因为行数为4）。
     A[] = [1,0,2,3]表达含义是：
     当前4个皇后所在坐标点为：[[0,1],[1,0],[2,2],[3,3]]（被我标蓝的正好是数组的下标，标粉的正好是数组的值）
     相当于：A[0] = 1, A[1] = 0, A[2] = 2, A[3] = 3 

这样以来，皇后所在的坐标值就能用一维数组表示了。
		*/	
        int [] columnVal = new int[n];
        
        DFS_helper(n,res,0,columnVal);
        return res;
    }
    
    public void DFS_helper(int nQueens, ArrayList<String[]> res, int row, int[] columnVal){
        if(row == nQueens){//row值等于皇后个数值时表示 已经把这么多个皇后放好了 ！！！！！！！
			//这是在把结果打印出来
            String[] unit = new String[nQueens]; //string 数组 用来存储每个合格的皇后string
            for(int i = 0; i < nQueens; i++){//打印的时候也得看每一行的每一列  皇后的棋盘格是正方形  行列数目一样
                StringBuilder s = new StringBuilder();
                for(int j = 0; j < nQueens; j++){
					/*
					因为是按照每一行去搜索的，当行坐标值等于行数时，说明棋盘上所有行都放好皇后了，这时就把有皇后的位置标为Q，没有的地方标为0。
按照上面讲的那个一维数组，我们就可以遍历整个棋盘，当坐标为（row，columnVal[row]）的时候，就说明这是皇后的位置，标Q就行了。
					*/
                    if(j == columnVal[i])
                        s.append("Q");
                    else
                        s.append(".");
                }
                
                unit[i] = s.toString();
            }
            
            res.add(unit);
        }else{
			//对于当前行， 测试他的每一列 若当前行放的黄后可以的话  就看下一行！
            for(int i = 0; i < nQueens; i++){
                columnVal[row] = i;//(row,columnVal[row)==>(row,i)
                
                if(isValid(row,columnVal))
                    DFS_helper(nQueens, res, row+1, columnVal);
            }
        }
    }
    /*
		皇后可以横竖斜同时攻击 
		
		对于一个棋盘来说，每个点都有横纵坐标，用横纵坐标可以表示一个点。
而这道题巧就巧在，每一行只能有一个皇后，也就是说，对于一行只能有一个纵坐标值，所以用1维数组能提前帮助解决皇后不能在同一行的问题。
那么用一维数组表示的话，方法是：一维数组的下标表示横坐标（哪一行），而数组的值表示纵坐标（哪一列）。

		采用int[ ]的好处是，每一次我们只需改变一个数字就相当于改变了棋子的放置位置
		isValid函数，首先int[ ]代表行，
		
		这样就避免了每一行出现重复的Queen （因为你不可能在一个int里面放2个值）
		这样简化了验证 接下来我们只需验证列和对角线
		columnVal[0]表示第0行， columnVal[0]的值是第0行对应的列的值

		因为除了刚加进来的那个皇后，前面都是合法的，我们只需要检查当前行和前面行是否冲突即可。
		检查是否同列很简单，检查对角线就是行的差和列的差的绝对值不要相等就可以
	*/
    public boolean isValid(int row, int [] columnVal){
        for(int i = 0; i < row; i++){
            if(columnVal[row] == columnVal[i]
               ||Math.abs(columnVal[row]-columnVal[i]) == row-i)
               return false;
        }
        return true;
    }
	
	
	
	
	
	
	
	http://blog.csdn.net/linhuanmars/article/details/20667175
http://blog.csdn.net/u011095253/article/details/9158473




class Solution {
    /**
     * Get all distinct N-Queen solutions
     * @param n: The number of queens
     * @return: All distinct solutions
     * For example, A string '...Q' shows a queen on forth position
     */
    ArrayList<ArrayList<String>> solveNQueens(int n) {
        ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
        if(n <= 0){
            return res;
        }
        int[] columnVal = new int[n];
        //columnVal[0] = 1; means row 0, column 1
        dfs(0,n, columnVal, res);
        return res;
    }
    public void dfs(int row, int nQueens, int[] columnVal, ArrayList<ArrayList<String>> res){
        if(nQueens == row){
            //n queens have been placed, so we print em out
            ArrayList<String> unit = new ArrayList<String>();
            //used to place n queens' position
            //对于每一行 每一列都得扫描 打印
            for(int i = 0; i < nQueens; i++){
                //每行都有一个自己的string记录哪个位置放Q（queen） 哪个放 . 表示那个位置不放queen
                StringBuilder s = new StringBuilder();
                for(int j = 0; j < nQueens; j++){
                    if(j == columnVal[i]){
                        s.append("Q");
                    }
                    else{
                        s.append(".");
                    }
                }
                unit.add(s.toString());
            }
            res.add(unit);
        }
        else{
            //此时说明n个皇后没都被放完呢
            //要看当前row的每一列
            for(int i = 0; i < nQueens; i++){
                columnVal[row] = i; //  看遍当前row的所有列
                if(isValid(row, columnVal)){
                    dfs(row + 1, nQueens, columnVal, res);
                }
            }
        }
    }
    
    public boolean isValid(int row, int[] columnVal){
        for(int i = 0; i < row; i++){
            if(columnVal[i] == columnVal[row] || Math.abs(columnVal[i] - columnVal[row]) == row - i){
                return false;
            }
            
        }
        return true;
    }
};




