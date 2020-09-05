package P1;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;


public class Board implements Creatable, BoardInitializable {


    private char[][] boardMatrix;
    private int wordNum;//number of placed words in the board
    private String category;
    public String[] words;
    private ArrayList<String> arrayList = new ArrayList<>();




    public String[] getWords() {
        return words;
    }

    public char getMatrixIJ(int i, int j){
        return boardMatrix[i][j];
    }

    public char[][] getBoardMatrix() {
        return boardMatrix;
    }

    public void setNull(){
        for (int i = 0; i < boardMatrix.length; i++) {
            for (int j = 0; j < boardMatrix.length; j++) {
                boardMatrix[i][j] = 0;
            }
        }
    }


    /**
     * constructor
     */
    public Board(int wordNum, int rowNum, int colNum, String category) {
        this.wordNum = wordNum;
        boardMatrix = new char[rowNum][colNum];
        this.category = category;
        words = new String[wordNum];
    }

    /**
     * Create all moves for words
     */
    public boolean placeHorizontally(String word, int row, int col, int dir) {
        boolean res = false;
        int check = 0;
        int save = col;
        if (dir == 1) {
            if (col + word.length() - 1 < boardMatrix.length) {
                for (int i = 0; i < word.length(); i++) {
                    if (boardMatrix[row][col] == word.charAt(i) || boardMatrix[row][col] == 0) {
                        col++;
                        check++;
                    } else break;
                }
            }
            if (check == word.length()) {
                col = save;
                for (int j = 0; j < word.length(); j++) {
                    boardMatrix[row][col] = word.charAt(j);
                    col++;
                }
                res = true;
            }
        }

        if (dir == -1) {
            if (col - word.length() + 1 >= 0) {
                for (int i = 0; i < word.length(); i++) {
                    if (boardMatrix[row][col] == word.charAt(i) || boardMatrix[row][col] == 0) {
                        col--;
                        check++;
                    } else break;
                }
            }
            if (check == word.length()) {
                col = save;
                for (int j = 0; j < word.length(); j++) {
                    boardMatrix[row][col] = word.charAt(j);
                    col--;
                }
                res = true;
            }
        }
        return res;
    }

    public boolean placeVertically(String word, int row, int col, int dir) {
        boolean res = false;
        int check = 0;
        int save = row;

        if (dir == 1) {
            if (row + word.length() - 1 < boardMatrix.length) {
                for (int i = 0; i < word.length(); i++) {
                    if (boardMatrix[row][col] == word.charAt(i) || boardMatrix[row][col] == 0) {
                        row++;
                        check++;
                    } else break;
                }
            }
            if (check == word.length()) {
                row = save;
                for (int j = 0; j < word.length(); j++) {
                    boardMatrix[row][col] = word.charAt(j);
                    row++;
                }
                res = true;
            }
        }

        if (dir == -1) {
            if (row - word.length() + 1 >= 0) {
                for (int i = 0; i < word.length(); i++) {
                    if (boardMatrix[row][col] == word.charAt(i) || boardMatrix[row][col] == 0) {
                        row--;
                        check++;
                    } else break;
                }
            }
            if (check == word.length()) {
                row = save;
                for (int j = 0; j < word.length(); j++) {
                    boardMatrix[row][col] = word.charAt(j);
                    row--;
                }
                res = true;
            }
        }
        return res;
    }

    public boolean placeNonMainDiagonal(String word, int row, int col, int dir) {
        boolean res = false;
        int check = 0;
        int saveCol = col;
        int saveRow = row;


        if (dir == 1) {
            if (col - word.length() + 1 >= 0 && row + word.length() - 1 < boardMatrix.length) {
                for (int i = 0; i < word.length(); i++) {
                    if (boardMatrix[row][col] == word.charAt(i) || boardMatrix[row][col] == 0) {
                        col--;
                        row++;
                        check++;
                    } else break;
                }
            }
            if (check == word.length()) {
                row = saveRow;
                col = saveCol;
                for (int j = 0; j < word.length(); j++) {
                    boardMatrix[row][col] = word.charAt(j);
                    col--;
                    row++;
                }
                res = true;
            }
        }

        if (dir == -1) {
            if (col + word.length() - 1 < boardMatrix.length && row - word.length() + 1 >= 0) {
                for (int i = 0; i < word.length(); i++) {
                    if (boardMatrix[row][col] == word.charAt(i) || boardMatrix[row][col] == 0) {
                        col++;
                        row--;
                        check++;
                    } else break;
                }
            }
            if (check == word.length()) {
                row = saveRow;
                col = saveCol;
                for (int j = 0; j < word.length(); j++) {
                    boardMatrix[row][col] = word.charAt(j);
                    col++;
                    row--;
                }
                res = true;
            }
        }
        return res;
    }

    public boolean placeMainDiagonal(String word, int row, int col, int dir) {
        boolean res = false;
        int check = 0;
        int saveCol = col;
        int saveRow = row;
        if (dir == 1) {
            if (col + word.length() - 1 < boardMatrix.length && row + word.length() - 1 < boardMatrix.length) {
                for (int i = 0; i < word.length(); i++) {
                    if (boardMatrix[row][col] == word.charAt(i) || boardMatrix[row][col] == 0) {
                        col++;
                        row++;
                        check++;
                    } else break;
                }
            }
            if (check == word.length()) {
                row = saveRow;
                col = saveCol;
                for (int j = 0; j < word.length(); j++) {
                    boardMatrix[row][col] = word.charAt(j);
                    col++;
                    row++;
                }
                res = true;
            }
        }

        if (dir == -1) {
            if (col - word.length() + 1 >= 0 && row - word.length() + 1 >= 0) {
                for (int i = 0; i < word.length(); i++) {
                    if (boardMatrix[row][col] == word.charAt(i) || boardMatrix[row][col] == 0) {
                        col--;
                        row--;
                        check++;
                    } else break;
                }
            }
            if (check == word.length()) {
                row = saveRow;
                col = saveCol;
                for (int j = 0; j < word.length(); j++) {
                    boardMatrix[row][col] = word.charAt(j);
                    col--;
                    row--;
                }
                res = true;
            }
        }
        return res;
    }

    public ArrayList<String> getArrayList() {
        return arrayList;
    }


    public class UnRepRandom {
        private ArrayList<Integer> al = new ArrayList<Integer>();

        public int nextInt(int size) {
            Random generator = new Random();
            boolean flag;
            int temp;
            do {
                temp = generator.nextInt(size);
                flag = true;
                for (int i = 0; i < al.size(); i++) {
                    if (temp == al.get(i)) {
                        flag = false;
                    }
                }
                if (flag) {
                    al.add(temp);
                }
            } while (!flag);

            return temp;

        }
    }


    /**
     * Initializes the board and places @wordNum words in the board randomly
     */

    public void create() {
        //use the placing functions to complete this function
        BufferedReader bufferedReader = null;
        ArrayList<String> arrayList = new ArrayList<>();
        String word = "";
        try {
            bufferedReader = new BufferedReader(new FileReader(category + ".txt"));
            while ((word = bufferedReader.readLine()) != null) {
                arrayList.add(word);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        UnRepRandom unRepRandom = new UnRepRandom();
        for (int i = 0; i < wordNum; i++) {
            words[i] = arrayList.get(unRepRandom.nextInt(arrayList.size()));
        }
        int counter = 0;
        Random functionRand = new Random();
        while (counter < wordNum) {
            int row = new Random().nextInt(boardMatrix.length);
            int col = new Random().nextInt(boardMatrix.length);
            int dir = new Random().nextInt(2);

            dir = dir == 0 ? dir - 1 : dir;

            switch (functionRand.nextInt(4)) {
                case 0:
                    if (placeHorizontally(words[counter], row, col, dir)) {
                        counter++;
                    }
                    break;
                case 1:
                    if (placeVertically(words[counter], row, col, dir)) {
                        counter++;
                    }
                    break;
                case 2:
                    if (placeNonMainDiagonal(words[counter], row, col, dir)) {
                        counter++;
                    }
                    break;
                case 3:
                    if (placeMainDiagonal(words[counter], row, col, dir)) {
                        counter++;
                    }
                    break;
            }

        }


//        char[] fill = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
//        for (int i = 0; i < boardMatrix.length; i++) {
//            for (int j = 0; j < boardMatrix.length; j++) {
//                if (boardMatrix[i][j] == 0)
//                    boardMatrix[i][j] = fill[functionRand.nextInt(fill.length)];
//            }
//        }

    }
}
