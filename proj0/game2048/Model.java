package game2048;

import java.util.Formatter;
import java.util.Observable;


/** The state of a game of 2048.
 *  @author TODO: YOUR NAME HERE
 */
public class Model extends Observable {
    /** Current contents of the board. */
    private Board board;
    /** Current score. */
    private int score;
    /** Maximum score so far.  Updated when game ends. */
    private int maxScore;
    /** True iff game is ended. */
    private boolean gameOver;

    /* Coordinate System: column C, row R of the board (where row 0,
     * column 0 is the lower-left corner of the board) will correspond
     * to board.tile(c, r).  Be careful! It works like (x, y) coordinates.
     */

    /** Largest piece value. */
    public static final int MAX_PIECE = 2048;

    /** A new 2048 game on a board of size SIZE with no pieces
     *  and score 0. */
    public Model(int size) {
        board = new Board(size);
        score = maxScore = 0;
        gameOver = false;
    }

    /** A new 2048 game where RAWVALUES contain the values of the tiles
     * (0 if null). VALUES is indexed by (row, col) with (0, 0) corresponding
     * to the bottom-left corner. Used for testing purposes. */
    public Model(int[][] rawValues, int score, int maxScore, boolean gameOver) {
        int size = rawValues.length;
        board = new Board(rawValues, score);
        this.score = score;
        this.maxScore = maxScore;
        this.gameOver = gameOver;
    }

    /** Return the current Tile at (COL, ROW), where 0 <= ROW < size(),
     *  0 <= COL < size(). Returns null if there is no tile there.
     *  Used for testing. Should be deprecated and removed.
     *  */
    public Tile tile(int col, int row) {
        return board.tile(col, row);
    }

    /** Return the number of squares on one side of the board.
     *  Used for testing. Should be deprecated and removed. */
    public int size() {
        return board.size();
    }

    /** Return true iff the game is over (there are no moves, or
     *  there is a tile with value 2048 on the board). */
    public boolean gameOver() {
        checkGameOver();
        if (gameOver) {
            maxScore = Math.max(score, maxScore);
        }
        return gameOver;
    }

    /** Return the current score. */
    public int score() {
        return score;
    }

    /** Return the current maximum game score (updated at end of game). */
    public int maxScore() {
        return maxScore;
    }

    /** Clear the board to empty and reset the score. */
    public void clear() {
        score = 0;
        gameOver = false;
        board.clear();
        setChanged();
    }

    /** Add TILE to the board. There must be no Tile currently at the
     *  same position. */
    public void addTile(Tile tile) {
        board.addTile(tile);
        checkGameOver();
        setChanged();
    }

    /** Tilt the board toward SIDE. Return true iff this changes the board.
     *
     * 1. If two Tile objects are adjacent in the direction of motion and have
     *    the same value, they are merged into one Tile of twice the original
     *    value and that new value is added to the score instance variable
     * 2. A tile that is the result of a merge will not merge again on that
     *    tilt. So each move, every tile will only ever be part of at most one
     *    merge (perhaps zero).
     * 3. When three adjacent tiles in the direction of motion have the same
     *    value, then the leading two tiles in the direction of motion merge,
     *    and the trailing tile does not.
     * */
    public boolean tilt(Side side) {
        boolean changed;
        changed = false;

        // TODO: Modify this.board (and perhaps this.score) to account
        // for the tilt to the Side SIDE. If the board changed, set the
        // changed local variable to true.


        //if side is north, leave the viewing perspective (because default is north)
        if (side == Side.NORTH){


        }

        //if side is west, set the viewing perspective to West
        if (side == Side.WEST){

            this.board.setViewingPerspective(Side.WEST);

            //then move board






            //set board back to NORTH viewing perspective after moving board
            this.board.setViewingPerspective(Side.NORTH);
        }


        //if side is east, set the viewing perspective to East
        if (side == Side.EAST){

            this.board.setViewingPerspective(Side.EAST);

            //then move board






            //set board back to NORTH viewing perspective after moving board
            this.board.setViewingPerspective(Side.NORTH);
        }







        checkGameOver();

        if (changed) {
            setChanged();
        }
        return changed;
    }


    /**
     * Check and move each column
     * @param column to be moved
     * @return True if a square was moved
     */
    public boolean moveColumn(int column){

        boolean movedSomething = false;

        /*
        Everything is in north view perspective

        Check from top down

        top
        [ a ] <- this will never move
        [ b ] <- check starting here
        [ c ] <- then check here
        [ d ] <- then check here
        down

         */


        //level a
        Tile a = this.board.tile(column, 3);


        //level b

        /*
        First check: If the tile is null, skip it (aka we only care if it's not null)

        Second check: if the space above [ a ] is empty , move it up and set moved something to true

        Third Check: if the space above [ a ] is not empty , check if the values are the same. If they are the same,
                     move it up and set moved something to true. If they are not same, don't move anything


         */

        Tile b = this.board.tile(column, 2);

        if ( b != null){


            if (a == null || a.value() == b.value() ){

                this.board.move(column, 3, b);

                movedSomething = true;
            }
        }




        return movedSomething;

    }











    /** Checks if the game is over and sets the gameOver variable
     *  appropriately.
     */
    private void checkGameOver() {
        gameOver = checkGameOver(board);
    }

    /** Determine whether game is over. */
    private static boolean checkGameOver(Board b) {
        return maxTileExists(b) || !atLeastOneMoveExists(b);
    }

    /** Returns true if at least one space on the Board is empty.
     *  Empty spaces are stored as null.
     * */
    public static boolean emptySpaceExists(Board b) {

        //board is 4x4 , rows and columns start at index 0
        //iterate over all rows anbd columns
        //check if the tile is null (meaning it doesn't exist at the particular row,column)
        //if it null then its empty, so retyrn true
        //if we exist the loop and that means no null tiles, so no empty spaces

        for (int i = 0; i < 4; i++){

            for (int j = 0; j < 4; j++){

                Tile tile = b.tile(i,j);

                if (tile == null){

                    return true;
                }
            }
        }

        return false;
    }

    /**
     * Returns true if any tile is equal to the maximum valid value.
     * Maximum valid value is given by MAX_PIECE. Note that
     * given a Tile object t, we get its value with t.value().
     */
    public static boolean maxTileExists(Board b) {

        //iterate over entire board, check if any of tbe tile values are 2048 (MAX_PIECE), return true if there is

        for (int i = 0; i < 4; i++){

            for (int j = 0; j < 4; j++){

                Tile tile = b.tile(i,j);

                //needs this conditional to catch if the tile is null (because it will throw a NullPointerException
                if (tile == null){
                    continue;
                }

                if (tile.value() == MAX_PIECE){

                    return true;
                }
            }
        }

        return false;
    }

    /**
     * Returns true if there are any valid moves on the board.
     * There are two ways that there can be valid moves:
     * 1. There is at least one empty space on the board.
     * 2. There are two adjacent tiles with the same value.
     */
    public static boolean atLeastOneMoveExists(Board b) {

        //base case if there's a empty space then there's a move, so return true
        if (Model.emptySpaceExists(b)){
            return true;
        }

        //iterate through board and check adjacent neighbors
        int up = 0;
        int down = 0;
        int left = 0;
        int right = 0;

        for (int i = 0; i < 4; i++){

            for (int j = 0; j < 4; j++) {
                //gets the value of the current tile
               int tileValue = b.tile(i, j).value();
                //gets values of adjacent tiles
                if (i - 1 >= 0){
                    up = b.tile(j, i-1).value();
                }
                if (i + 1 < 4){
                    down = b.tile(j, i+1).value();
                }
                if (j - 1 >= 0){
                    left = b.tile(j-1, i).value();
                }
                if (j + 1 < 4){
                    up = b.tile(j+1, i).value();
                }
                //if any of the values of adjacent tiles are equal to the values of current tile, there's a valid move
                if (tileValue == up || tileValue == down || tileValue == left || tileValue == right) {
                    return true;
                }
                //else reset values of neighbors back to 0
                up = 0;
                down = 0;
                left = 0;
                right = 0;
            }
        }
        return false;
    }


    @Override
     /** Returns the model as a string, used for debugging. */
    public String toString() {
        Formatter out = new Formatter();
        out.format("%n[%n");
        for (int row = size() - 1; row >= 0; row -= 1) {
            for (int col = 0; col < size(); col += 1) {
                if (tile(col, row) == null) {
                    out.format("|    ");
                } else {
                    out.format("|%4d", tile(col, row).value());
                }
            }
            out.format("|%n");
        }
        String over = gameOver() ? "over" : "not over";
        out.format("] %d (max: %d) (game is %s) %n", score(), maxScore(), over);
        return out.toString();
    }

    @Override
    /** Returns whether two models are equal. */
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        } else if (getClass() != o.getClass()) {
            return false;
        } else {
            return toString().equals(o.toString());
        }
    }

    @Override
    /** Returns hash code of Model’s string. */
    public int hashCode() {
        return toString().hashCode();
    }
}
