package kiefer.kata;

import java.util.Random;

/**
 * Created by moose on 4/29/2018.
 */
public class Run {

    public static void main(String[] args) throws Exception {
        int rows = 50;
        int cols = 80;
        Grid grid = setUp(rows, cols);
        Display display = new Display();
        String output = display.gridString(grid);

        while (true) {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            System.out.print(output);
            grid.nextGeneration();
            output = display.gridString(grid);
            Thread.sleep(200);
        }
    }

    private static void resetCursor(int rows){
        for (int i = 0 ; i <= rows ; ++i) {
            System.out.print("\033[1A");
        }
        System.out.print("\r");
    }

    private static Grid setUp(int rows, int cols) {
        Grid grid = new Grid(cols, rows);
        Random ran = new Random();
        int seedRow = 0;
        int seedCol = 0;
        for (int i = 0; i < 20; ++i) {
            seedRow = ran.nextInt(rows);
            seedCol = ran.nextInt(cols);
            if (seedCol > cols/2) {
                seedCol = seedCol - 3;
            }
            if (seedRow > rows / 2) {
                grid.rows()[seedRow - 1][seedCol].isAlive(true);
            } else {
                grid.rows()[seedRow + 1][seedCol].isAlive(true);
            }
            grid.rows()[seedRow][seedCol].isAlive(true);
            grid.rows()[seedRow][seedCol + 1].isAlive(true);
            grid.rows()[seedRow][seedCol + 2].isAlive(true);
        }
        return grid;
    }
}
