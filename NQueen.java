import java.util.ArrayList;
import java.util.List;

public class NQueen {
    public List<List<String>> solveNQueens(int n) {

        List<List<String>> ans = new ArrayList<>();
        boolean col[] = new boolean[n];
        boolean diagonal[] = new boolean[2 * n - 1];
        boolean antiDiagonal[] = new boolean[2 * n - 1];

        boolean[][] maze = new boolean[n][n];
        nqueens(maze, 0, n, ans, col, diagonal, antiDiagonal);
        return ans;
    }

    private void nqueens(boolean[][] maze, int rNo, int n, List<List<String>> ans, boolean[] col, boolean[] diagonal,
            boolean[] antiDiagonal) {
        if (rNo == n) {
            // maze to list of string;
            mazeToList(maze, ans);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (col[i] == false && diagonal[i + rNo] == false && antiDiagonal[(i - rNo) + n - 1] == false) {

                maze[rNo][i] = true;
                col[i] = true;
                diagonal[i + rNo] = true;
                antiDiagonal[(i - rNo) + n - 1] = true;

                nqueens(maze, rNo + 1, n, ans, col, diagonal, antiDiagonal);

                maze[rNo][i] = false;
                col[i] = false;
                diagonal[i + rNo] = false;
                antiDiagonal[(i - rNo) + n - 1] = false;
            }
        }

    }

    private void mazeToList(boolean[][] maze, List<List<String>> ans) {
        List<String> tans = new ArrayList<>();
        for (int i = 0; i < maze.length; i++) {
            String str = "";
            for (int j = 0; j < maze[0].length; j++) {
                if (maze[i][j] == true) {
                    str += "Q";
                } else {
                    str += ".";
                }
            }
            tans.add(str);
        }
        ans.add(tans);
    }

}