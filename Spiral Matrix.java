Spiral Matrix

30:00
 Start
Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

Have you met this question in a real interview? Yes
Example
Given the following matrix:

[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
You should return [1,2,3,6,9,8,7,4,5].

把matrix return 走一圈的元素顺序             ！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！

public ArrayList<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(matrix == null || matrix.length == 0)
            return result;
 
        int m = matrix.length;//matrix里面有几个数组
        int n = matrix[0].length;//每个数组里有几个数字
 
        int x=0; 
        int y=0;
 
        while(m>0 && n>0){
 
            //if one row/column left, no circle can be formed
            if(m==1){//只有一个数组的matrix
                for(int i=0; i<n; i++){
                    result.add(matrix[x][y++]);// 用xy走坐标 而不是i
                }
                break;
            }else if(n==1){
                for(int i=0; i<m; i++){
                    result.add(matrix[x++][y]);
                }
                break;
            }
 
            //below, process a circle
 
            //top - move right
            for(int i=0;i<n-1;i++)
                result.add(matrix[x][y++]);//画图移动易懂
 
            //right - move down
            for(int i=0;i<m-1;i++)
                result.add(matrix[x++][y]);
 
            //bottom - move left
            for(int i=0;i<n-1;i++)
                result.add(matrix[x][y--]);
 
            //left - move up
            for(int i=0;i<m-1;i++)
                result.add(matrix[x--][y]);
 
            x++;//要注意更新x
            y++;
            m=m-2;
            n=n-2;
        }
 
        return result;
    }
	
	

