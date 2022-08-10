package gens;
/**
 *   This class represents a generation of the Conway's Game of Life in a 
 *   squared restricted world. 
 *   It is basically a boolean square matrix when the cells are 
 *   alive or dead depending on whether the elements are true or false, respectively.
 *
 *   Responsabilities:
 *   - Knowing which cells are dead and alive.
 *   - Set if a cell is dead or alive.
 *   - Create the next generation.
 */
import stdlib.*;
  
public interface IGen {
  /**
  * Creates a generation without alive cells in a square world of 
  * size * size dimensions
  *
  * public Gen(int size);
  */
 /**
  * Creates a generation with random cells in a square world 
  * of random size in range [min, max].
  *
  * public Gen (int min, int max);
  */
 /**
  * Creates a generation from a file with name "filename" from package files.
  * IMPORTANT:
  *   - The first line of the file is the size of the world
  *   - The rest of the lines are the cells that are alive in the beginning
  * 
  * public Gen (String filename);
  */
  /**
   * 
   * @return size of the square gen matrix
   */
  public int size ();
  /**
   * Sets if the cell of (x, y) is dead of alive
   * 
   * @param x
   * @param y
   * @param alive
   */
  public void set (int x, int y, boolean alive);
  /**
   * 
   * @param x
   * @param y
   * @return if the cell of (x, y) exists
   */
  public boolean thereIsCell(int x, int y);
  /**
   * 
   * @param x
   * @param y
   * @return if the cell of (x,y) is alive
   */
  public boolean alive(int x, int y);
  /**
   * 
   * @return next generation according to
   * the rules of the game.
   */
  public Gen next ();
  /**
   *  (x-1, y+1)  (x, y+1)   (x+1, y+1)      
   *   (x-1, y)    (x, y)     (x+1, y)
   *  (x-1, y-1)  (x1, y-1)  (x+1, y-1)
   * 
   * 
   * @param coordX
   * @param coordY
   * @return number of cells alive around the cell (x, y)
   */
  public int aliveAround(int x, int y);
  /**
   * 
   * @param o
   * @return if two generations are equal each other
   */
  public boolean equals (Object o);
  /**
   * Paints this generation in the canvas
   * 
   * @param canvas
   * @param cellSize
   */
  public void paint(Draw canvas, double cellSize);

}
