package kiefer.kata;

/**
 * Created by moose on 4/29/2018.
 */
public class Run {

    public static void main(String[] args) throws Exception {
        int rows = 30;
        int cols = 40;
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
        grid.rows()[1][12].isAlive(true);
        grid.rows()[1][13].isAlive(true);
        grid.rows()[1][14].isAlive(true);
        grid.rows()[2][13].isAlive(true);
        grid.rows()[4][7].isAlive(true);
        grid.rows()[4][8].isAlive(true);
        grid.rows()[4][9].isAlive(true);
        grid.rows()[5][9].isAlive(true);
        grid.rows()[5][10].isAlive(true);
        grid.rows()[5][11].isAlive(true);
        grid.rows()[6][9].isAlive(true);
        return grid;
    }
}
