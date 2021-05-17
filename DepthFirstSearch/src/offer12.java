/**
 * 给定一个m x n 二维字符网格board 和一个字符串单词word 。如果word 存在于网格中，返回 true ；
 * 否则，返回 false 。
 *
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。
 * 同一个单元格内的字母不允许被重复使用。
*/
public class offer12 {

}

class Solution12 {
    public boolean exist(char[][] board, String word) {
        /**
         * 分析：同判断机器人能否达到重点类似，方向有四种，上下左右，但是走过的路程就不能再走了
         *  执行用时：5 ms, 在所有 Java 提交中击败了98.21%的用户
         * 内存消耗：40.3 MB, 在所有 Java 提交中击败了49.97%的用户
         */
        //将单词分解成char类型
        char [] words = word.toCharArray();
        for(int i =0; i < board.length;i++){
            for(int j = 0;j < board[0].length;j++){
                if(dfs(board,words,i,j,0))return true;
            }
        }
        return false;

    }

    /**
     *
     * @param board 原始矩阵，找路径的矩阵
     * @param word  需要寻找的单词
     * @param i     行索引
     * @param j     列索引
     * @param k     单词索引值，第几个
     * @return
     */
    boolean dfs(char [][] board,char [] word,int i,int j ,int k ){
        //跳出递归的条件
        if(i >= board.length ||
                j >= board[0].length ||
                i<0 || j < 0 ||
                board[i][j] != word[k]){
            return false;
        }
        //当k达到了单词的最后一个索引，返回true
        if(k == word.length - 1){return true;}
        //将走过的路径变成'\0'
        board[i][j] = '\0';
        boolean res = dfs(board,word,i+1,j,k+1) || dfs(board,word,i-1,j,k+1)
                || dfs(board,word,i,j+1,k+1) || dfs(board,word,i,j-1,k+1);
        board[i][j] = word[k];
        return res;

    }
}