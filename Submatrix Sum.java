Submatrix Sum

30:00
 Start
Given an integer matrix, find a submatrix where the sum of numbers is zero. Your code should return the coordinate of the left-up and right-down number.

Have you met this question in a real interview? Yes
Example
Challenge
Tags
Related Problems
 Notes
Given matrix

[
  [1 ,5 ,7],
  [3 ,7 ,-8],
  [4 ,-8 ,9],
]
return [(1,1), (2,2)]


找到两个点 左上右下组成的小matrix sum为0

不好理解！！！！！！！！！！！！！！！！！！！


Complexity

Time: O(m^2 * n)

Space: O(m*n)

Code

public class Solution {
  public int[][] submatrixSum(int[][] matrix) {
    assert(matrix != null && matrix.length != 0 && matrix[0].length != 0);
    int numRows = matrix.length;
    int numCols = matrix[0].length;
    int[][] sum = new int[numRows + 1][numCols + 1];
    // preprocess to get sum of all submatrix [(0, 0), (i, j)]
    for (int i = 0; i < numRows; i++) {
      for (int j = 0; j < numCols; j++) {
        sum[i + 1][j + 1] = matrix[i][j] + sum[i + 1][j] + sum[i][j + 1] - sum[i][j];
      }
    }

    Map<Integer, Integer> map = new HashMap<>();
    for (int i1 = 0; i1 < numRows; i1++) {
      for (int i2 = i1 + 1; i2 <= numRows; i2++) {//i1 i2 差1 是要下面积算diff
        map.clear();
        map.put(0, 0);//加入map是put 不是add
        for (int j = 1; j <= numCols; j++) {// j从1开始是因为边缘都是0 从第一行开始算与第0行的差 第二行与第0的差 第3 与第0 的差 
		//然后 第二与第一  第三与第一 
		//最后第三与第2 看diff是否出现过  出现就是找到了
          int diff = sum[i2][j] - sum[i1][j];
          if (map.containsKey(diff)) {
            return new int[][]{{i1, map.get(diff)}, {i2 - 1, j - 1}};//左边是i1是因为i1在最外围， i2 j是右下角的点  看图好理解
			//i1 与map中的j组成左上角
			//i2 与j组成当前坐标 由于sum建立的时候是用len+1得来的 所以此时得 - 1 
			//i1不减1是因为 i1从0到2 就是index
          }
          map.put(diff, j);
        }
      }
    }
    return null;
  }
}





