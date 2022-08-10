package tests;

/**
 * Responsabilidades:
 * - Probar la clase Gen mediante un GUI sencillo.
 */
import stdlib.*;
import gens.*;

public class GenTest {
  private Gen gen;
  private Draw canvas;
  private static final int CANVAS_SIZE = 750;
  private double cellSize;

  public GenTest() {
    //gen = new Gen(32, 64);
    // gen = new Gen(".\\files\\bg.life");
    gen = carga();
    canvas = new Draw("Life");
    cellSize =  CANVAS_SIZE/gen.size();
    canvas.setCanvasSize(CANVAS_SIZE, CANVAS_SIZE);
    canvas.enableDoubleBuffering();
  }

  static public Gen carga() {

    //Sets a cannon  
    Gen gen = new Gen(64);

    gen.set(0, 5, true);
    gen.set(0, 6, true);
    gen.set(1, 5, true);
    gen.set(1, 6, true);

    gen.set(10, 5, true);
    gen.set(10, 6, true);
    gen.set(10, 7, true);

    gen.set(11, 4, true);
    gen.set(11, 8, true);

    gen.set(12, 3, true);
    gen.set(12, 9, true);
    gen.set(13, 3, true);
    gen.set(13, 9, true);

    gen.set(14, 6, true);
    gen.set(15, 4, true);
    gen.set(15, 8, true);

    gen.set(16, 5, true);
    gen.set(16, 6, true);
    gen.set(16, 7, true);
    gen.set(17, 8, true);

    gen.set(20, 3, true);
    gen.set(20, 4, true);
    gen.set(20, 5, true);
    gen.set(21, 3, true);
    gen.set(21, 4, true);
    gen.set(21, 5, true);
    gen.set(22, 2, true);
    gen.set(22, 6, true);

    gen.set(24, 1, true);
    gen.set(24, 2, true);
    gen.set(24, 6, true);
    gen.set(24, 7, true);

    gen.set(34, 3, true);
    gen.set(34, 4, true);
    gen.set(35, 3, true);
    gen.set(35, 4, true);

    return gen;
  }

  public void animacion() {
    while (true) {
      
      canvas.clear(Draw.BLACK);
      gen = gen.next();
      gen.paint(canvas, cellSize);
      canvas.pause(50);
      canvas.show();
      do {} while (!canvas.isKeyPressed(32));
    }
  }

  public static final void main(String[] args) {
    
    new GenTest().animacion();
  }
}
