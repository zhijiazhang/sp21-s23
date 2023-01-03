package game2048;

/** Describes a source of input commands.
 *  @author Zhijia Zhang
 */
interface InputSource {

    /** Returns one command string. */
    String getKey();

    /** Returns a candidate Tile whose row and column is in the range
     *  0 .. SIZE-1.  */
    Tile getNewTile(int size);

}

