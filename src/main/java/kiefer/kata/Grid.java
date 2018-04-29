package kiefer.kata;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by moose on 4/27/2018.
 */
public class Grid {


    private Cell[][] cells;

    public Grid(int columns, int rows) {
        cells = new Cell[rows][columns];
        populate();
    }

    public Cell[][] rows() {
        return this.cells;
    }

    public void nextGeneration() {
        List<Boolean> answers = new ArrayList<>();
        for (Cell[] row : cells) {
            for (Cell cell : row) {
                answers.add(cell.willLive());
            }
        }
        Iterator<Boolean> answerIterator = answers.iterator();
        for (Cell[] row : cells) {
            for (Cell cell : row) {
                cell.isAlive(answerIterator.next());
            }
        }
    }

    protected void populate() {
        for (int i = 0; i < cells.length; ++i) {
            Cell[] row = cells[i];
            for (int it = 0; it < row.length; ++it) {
                row[it] = new Cell();
                addNeighbors(row[it], i, it);
            }
        }
    }

    protected void addNeighbors(Cell cell, int row, int col) {
        if (row > 0) {
            Cell north = cells[row - 1][col];
            cell.addNeighbor(north);
            north.addNeighbor(cell);
            if (col < cells[0].length - 1) {
                Cell northEast = cells[row - 1][col + 1];
                cell.addNeighbor(northEast);
                northEast.addNeighbor(cell);
            }
            if (col > 0) {
                Cell northWest = cells[row - 1][col - 1];
                cell.addNeighbor(northWest);
                northWest.addNeighbor(cell);
            }
        }
        if (col > 0) {
            Cell west = cells[row][col - 1];
            cell.addNeighbor(west);
            west.addNeighbor(cell);
        }
    }
}
