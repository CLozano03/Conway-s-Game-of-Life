package gens;
/**
 * Responsibilities:
 *
 * - You have the responsibilities of a MVC model: keep the
 * Main application data.
 * - Keep the story of all generations so far
 * (In the form of a linked chain).
 * - Advance and go back in history.
 * - Understand if the last generation is the end of the game because the
     next will be identical.
 */
public interface ILifeHistory 
{
// private node <gen> History = null;// Attribute for implementation.
  
 /**
  * Add a new generation to history.
  *
  * public Lifehistory (Igen Gen)
  */
  public void evolve ();
 /**
  * "Involve", eliminating the current generation
  * and returning to the previous one.
  */
  public void undo ();
 /**
  * The current generation
  */
  public Gen current ();
  /**
  * The previous generation
  */
  public Gen former ();
 /**
  * Number of generations in the history
  */
  public int generations ();
  /**
   * 
   * @return if game of life has ended (if current generation equals some of two previous)
   */
  public boolean endOfGame ();
}
