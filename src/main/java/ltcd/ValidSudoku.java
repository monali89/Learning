package ltcd;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {

    public static void main(String[] args) {

        char[][] input = {
                {'.','.','.','.','5','.','.','1','.'},
                {'.','4','.','3','.','.','.','.','.'},
                {'.','.','.','.','.','3','.','.','1'},
                {'8','.','.','.','.','.','.','2','.'},
                {'.','.','2','.','7','.','.','.','.'},
                {'.','1','5','.','.','.','.','.','.'},
                {'.','.','.','.','.','2','.','.','.'},
                {'.','2','.','9','.','.','.','.','.'},
                {'.','.','4','.','.','.','.','.','.'}
        };

        System.out.println(isValidSudoku(input));
    }

    static char[][] b;

    public static boolean isValidSudoku(char[][] board) {
        b = board;
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                if(helper(i, j)) continue;
                else return false;
            }
        }
        return true;
    }

    public static boolean helper(int row, int col){ // 0,0

        System.out.println("For " + row + ", " + col);

        Set<Character> setRow = new HashSet<Character>();
        Set<Character> setCol = new HashSet<Character>();

        for(int i=0; i<9; i++){
            //if(i == col) continue;
            if(setRow.contains(b[row][i])) return false;
            if(b[row][i] != '.') setRow.add(b[row][i]);
        }

        for(int i=0; i<9; i++){
            //if(i == col) continue;
            if(setCol.contains(b[i][col])) return false;
            if(b[i][col] != '.') setCol.add(b[i][col]);
        }

        System.out.println(setRow + ", " + setCol);

        return true;
    }
}
