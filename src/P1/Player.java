package P1;


import javafx.scene.text.Text;


public class Player extends Text  implements Capable {

    char[][] matrix;
    String[] words;
    String words1;
    double point = 0;
    int ending  = 0;

    /**
     * constructor
     */

    public Player() {
    }

    /**
     * Create all moves for salve
     */

    public void solve(Board board, int row, int col, int row2, int col2) {
        matrix = board.getBoardMatrix();
        words = board.getWords();
        search(row, col, row2, col2);
    }

    public boolean search(int srow, int scol, int erow, int ecol) {
        StringBuilder temp = new StringBuilder();

        if (srow == erow && scol < ecol) {
            for (int i = scol; i <= ecol; i++) {
                temp.append(matrix[srow][i]);
            }

        }
        if (srow == erow && scol > ecol) {
            temp = new StringBuilder();
            for (int i = scol; i >= ecol; i--) {
                temp.append(matrix[srow][i]);
            }

        }
        if (srow < erow && scol == ecol) {
            temp = new StringBuilder();
            for (int i = srow; i <= erow; i++) {
                temp.append(matrix[i][scol]);
            }

        }
        if (srow > erow && scol == ecol) {
            temp = new StringBuilder();
            for (int i = srow; i >= erow; i--) {
                temp.append(matrix[i][scol]);
            }

        }
        if (srow > erow && scol > ecol) {
            for (int i = srow, j = scol; i >= erow && j >= ecol; i--, j--) {
                temp.append(matrix[i][j]);

            }
        }
        if (srow > erow && scol < ecol) {
            for (int i = srow, j = scol; i >= erow && j <= ecol; i--, j++) {
                temp.append(matrix[i][j]);

            }
        }
        if (srow < erow && scol < ecol) {
            for (int i = srow, j = scol; i <= erow && j <= ecol; i++, j++) {
                temp.append(matrix[i][j]);

            }
        }
        if (srow < erow && scol > ecol) {
            for (int i = srow, j = scol; i <= erow && j >= ecol; i++, j--) {
                temp.append(matrix[i][j]);
            }
        }
        int check = 0;
        String temp1 = temp.toString() + "1";
        for (int i = 0; i < words.length; i++) {
            if (temp.toString().equals(words[i])) {
                words[i] = temp + "1";
                words1 = temp.toString();
                point++;
                ending++;
                check = 1;
                break;
            }
            if (temp1.equals(words[i])) {
                words1 = "It Was Found";
                check = 1;
                break;
            }
        }
        if (check == 1) {
            return true;
        } else {
            words1 = "Wrong Answer";
            point = point - 0.5;
            return false;
        }

    }
}


