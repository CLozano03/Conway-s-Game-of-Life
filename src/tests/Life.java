package tests;

import stdlib.*;
import gens.*;
import java.awt.Font;


public class Life {

    static final int CANVAS_SIZE = 700;
    static final int TIME_REFRESH = 100; //Miliseconds



    static IGen gen;
    static IGen genMenu;
    static Draw canvas;
    static ILifeHistory history;
    static double cellSize;

    public static void main(String[] args){
        //Setup variables
        gen = new Gen(100,100);/* GenTest.carga(); */
        canvas = new Draw("Life by Cesar Lozano");
        history = new LifeHistory(gen);
        cellSize = CANVAS_SIZE / gen.size();

        canvasInit();
        play();
    }


    /**
     * Method created to initialize the canvas
     */
    private static void canvasInit() {
        canvas.enableDoubleBuffering();
        canvas.setCanvasSize(CANVAS_SIZE, (int)(CANVAS_SIZE  ));
        canvas.setXscale(0, gen.size());
        canvas.setYscale(gen.size(), -10);
        /**
         * (0,0)           (Csize, 0)
         * 
         * 
         * 
         * 
         * 
         * (0,Csize)       (Csize, Csize)
         */
        

        canvas.clear(Draw.BLACK);
        gen.paint(canvas,cellSize);
        setInstructions();
        canvas.show();
    }

    public static void play() {

        while (true) {
            if (canvas.isKeyPressed(69)) {// Press E
                forwards(true);
                canvas.pause(TIME_REFRESH);
            }
            if (canvas.isKeyPressed(82)) {// Press L
                while (!canvas.isKeyPressed(80) && !history.endOfGame()) {// Press P
                    forwards(true);
                    canvas.pause(TIME_REFRESH);
                }
            }
            // Undo
            if (canvas.isKeyPressed(85)) {// Press U
                try {
                    forwards(false);
                } catch (Exception e) {
                }
                canvas.pause(TIME_REFRESH);
            }
        }
    }

    private static void forwards(boolean up) {
        canvas.clear(Draw.BLACK);
        
        if(up){
            history.evolve();
            gen = history.current();
        } else {
            gen = history.former();
            history.undo();
        } 
        gen.paint(canvas, cellSize);
        setInstructions();
        canvas.show();

    }

    private static void setInstructions() {

        Life.canvas.setFont(new Font("FuenteTitulo", Font.BOLD, 20));
        int instructionsY = -5;
        int alignX = 20;

        canvas.setPenColor(Draw.BLACK);
        canvas.filledRectangle(gen.size()/2, instructionsY, gen.size()/2,5);
        canvas.setPenColor(Draw.WHITE);
        canvas.textLeft(gen.size() - alignX - 4, instructionsY, "Generation: " + history.generations());
        canvas.textLeft(3*alignX , instructionsY, "R: Loop");
        canvas.textLeft(2* alignX,  instructionsY, "E: Forwards");
        canvas.textLeft(alignX,  instructionsY, "U: Undo");
        canvas.textLeft(2, instructionsY, "P: Pause");
    }
}
