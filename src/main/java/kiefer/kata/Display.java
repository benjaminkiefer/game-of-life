package kiefer.kata;

/**
 * Created by moose on 4/28/2018.
 */
public class Display {

    public String cellString(Cell cell) {
        if (cell.isAlive()) {
            return "[x]";
        } else {
            return "   ";
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
            sb.append("\n");
        }
        return sb.toString();
    }
}
