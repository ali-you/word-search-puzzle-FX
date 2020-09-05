package P1;

import java.util.Random;

public interface BoardInitializable {
    /**
     * placing a @word in @row starting
     * from cell @col in direction @dir
     * returns false if not possible
     */

    public boolean placeHorizontally(String word, int row, int col, int dir);


    /**
     * placing @word in @col starting
     * from the cell @row in direction @dir
     * returns false if not possible
     */
    public boolean placeVertically(String word, int row, int col, int dir);


    /**
     * placing @word in a diagonal parallel to the
     * main diagonal starting from the cell [ @row , @col ]
     * in direction @dir
     * returns false if not possible
     */
    public boolean placeNonMainDiagonal(String word, int row, int col, int dir);

    /**
     * placing @word in a diagonal crossing the
     * main diagonal starting from the cell [ @row , @col ]
     * in direction @dir
     * returns false if not possible
     */
    public boolean placeMainDiagonal(String word, int row, int col, int dir);


}
