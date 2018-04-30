package kiefer.kata;

/**
 * Created by moose on 4/28/2018.
 */
public class Display {

    public static final String LIVE_CELL = "()";
    public static final String DEAD_CELL = "  ";
    public static final String NEW_LINE = System.getProperty("line.separator");

    public String cellString(Cell cell) {
        if (cell.isAlive()) {
            return LIVE_CELL;
        } else {
            return DEAD_CELL;
        }
    }

    public String rowString(Cell[] row) {
        StringBuilder sb = new StringBuilder();
        for (Cell cell : row) {
            sb.append(cellString(cell));
        }
        return sb.toString();
    }

    public String gridString(Grid grid) {
        StringBuilder sb = new StringBuilder();
        for (Cell[] row : grid.rows()) {
            sb.append(rowString(row));
            sb.append(NEW_LINE);
        }
        return sb.toString();
    }
}
