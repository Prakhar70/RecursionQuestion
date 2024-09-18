public class WordSearch {
    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;
        int[][] dir = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                boolean res = exist(board, word, 0, i, j, dir);
                if (res == true) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean exist(char[][] board, String word, int idx, int i, int j, int[][] dir) {

        if (idx == word.length() - 1) {
            return board[i][j] == word.charAt(idx);
        }
        if (board[i][j] != word.charAt(idx)) {
            return false;
        }

        boolean ans = false;
        board[i][j] = '1';
        int n = board.length;
        int m = board[0].length;
        for (int d = 0; d < dir.length; d++) {
            int r = i + dir[d][0];
            int c = j + dir[d][1];
            if (r >= 0 && c >= 0 && r < n && c < m && board[r][c] != '1') {
                ans = ans || exist(board, word, idx + 1, r, c, dir);
                if (ans) {
                    break;
                }
            }
        }
        board[i][j] = word.charAt(idx);
        return ans;

    }
}