
这道题利用的是HashSet的唯一性来帮助check。

先按每行check，如果是'.'说明还没填字，是合法的，往下走，如果没在set中存过就加一下，
如果便利过程中出现了在set中存在的key值，说明有重复的数字在一行，不合法，return false。

再按照这个方法check列。

最后按照这个方法check小方块。

注意小方块的ij取法。对于当前这块板子来说，总共有9个小方格，按0~8从左到右依次编号。

按编号求'/'就是求得当前小方格的第一行横坐标，因为每个小方格有3行，所以循环3次。

按编号求'%'就是求得当前小方格的第一列纵坐标，因为每个小方格有3列，所以循环3次。 

对9个小方格依次走一边，就完成了检查小方格的工作。


public boolean isValidSudoku(char[][] board) {
    HashSet<Character> set = new HashSet<Character>();
    // Check for each row
    for (int i = 0; i < 9; i++) {
        for (int j = 0; j < 9; j++) {
            if (board[i][j] == '.')
                continue;
            if (set.contains(board[i][j]))//不是containsKey
                return false;
            set.add(board[i][j]);
        }
        set.clear();//这行看完了 就看下一行 不用留着上一行的数字了 所以清除掉   注意其位置！！！   行 列  与 sub-grid不一样 ！！！
    }

    // Check for each column
    for (int j = 0; j < 9; j++) {
        for (int i = 0; i < 9; i++) {
            if (board[i][j] == '.')
                continue;
            if (set.contains(board[i][j]))
                return false;
            set.add(board[i][j]);
        }
        set.clear();
    }

    // Check for each sub-grid
	//横着数每个sub-grid 每行数 每数完3行 再回第一行数第二个sub-grid 的三行
    for (int k = 0; k < 9; k++) {//横着数9个格子
        for (int i = k/3*3; i < k/3*3+3; i++) {//k = 0 1 2 i = 0 1 2
											  // k = 3 4 5 i = 3 4 5 
											 //  k = 6 7 8 i = 6 7 8
            for (int j = (k%3)*3; j < (k%3)*3+3; j++) {
				// k = 0 3 6 j = 0 1 2
				// k = 1 4 7 j = 3 4 5
				// k = 2 5 8 j = 6 7 8 
                if (board[i][j] == '.')
                    continue;
                if (set.contains(board[i][j]))
                    return false;
                set.add(board[i][j]);
            }
        }
        set.clear();//在这里是因为 每个sub-grid都完事 再清除！！！！！
    }
    
    return true;
}