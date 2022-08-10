package gens;

import stdlib.*;
import auxi.*;

/**
 * Implementation of the interface IGen
 * 
 * @author Cesar Lozano
 * @version 09/07/2022
 */
public class Gen implements IGen {

    private boolean[][] gen;

    public Gen(int min, int max) {
        int size = Auxi.aleatorio(min, max);

        gen = new boolean[size][size];

        for (int i = 0; i < size(); i++) {
            for (int j = 0; j < size(); j++) {
                // Set for each cell if it is randomly dead or alive
                if ((int) (Math.random() * 3) == 1) {
                    gen[i][j] = false;
                } else {
                    gen[i][j] = true;
                }
            }
        }

    }

    public Gen(int size) {
        gen = new boolean[size][size];
    }

    public Gen(String filename) {

        In sc = new In(filename);

        int size = sc.readInt();

        gen = new boolean[size][size];

        while (sc.hasNextLine()) {
            set(sc.readInt(), sc.readInt(), true);
        }
        sc.close();
    }

    public int size() {
        return gen.length;
    }

    public void set(int x, int y, boolean alive) {
        gen[x][y] = alive;
    }

    public boolean thereIsCell(int x, int y) {
        return x >= 0 && y >= 0 && x < size() && y < size();
    }

    public boolean alive(int x, int y) {
        return thereIsCell(x, y) && gen[x][y];
    }

    public Gen next() {

        Gen newGen = new Gen(size());

        for (int i = 0; i < size(); i++) {
            for (int j = 0; j < size(); j++) {
                if (gen[i][j]) {
                    if (!((aliveAround(i, j) == 2) || aliveAround(i, j) == 3)) {
                        newGen.gen[i][j] = false;
                    } else {
                        newGen.gen[i][j] = true;
                    }

                } else {
                    if (aliveAround(i, j) == 3) {
                        newGen.gen[i][j] = true;
                    }
                }

            }
        }
        return newGen;
    }

    public int aliveAround(int x, int y) {
        int counter = 0;

        if (alive(x - 1, y)) {
            counter++;
        }
        if (alive(x - 1, y - 1)) {
            counter++;
        }
        if (alive(x - 1, y + 1)) {
            counter++;
        }
        if (alive(x, y + 1)) {
            counter++;
        }
        if (alive(x, y - 1)) {
            counter++;
        }
        if (alive(x + 1, y)) {
            counter++;
        }
        if (alive(x + 1, y - 1)) {
            counter++;
        }
        if (alive(x + 1, y + 1)) {
            counter++;
        }
        return counter;

    }

    public boolean equals(Object o) {
        Gen anotherGen = (Gen) o;
        boolean equals = true;
        for (int i = 0; i < size() && equals; i++) {
            for (int j = 0; j < size() && equals; j++) {
                equals = gen[i][j] == anotherGen.gen[i][j];
            }
        }
        return equals;
    }

    public void paint(Draw canvas, double cellSize) {

        canvas.setPenColor(Draw.GREEN);

        for (int i = 0; i < size(); i++) {
            for (int j = 0; j < size(); j++) {
                if (gen[i][j])
                    canvas.filledSquare(i +0.5, j + 0.5,
                            0.42);
            }
        }
    }
}
