package kiefer.kata;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by moose on 4/27/2018.
 */
public class GridTest {

    @Test
    public void a1x1GridShouldHaveOneCell() {
        Grid grid = new Grid(1,1);
        Cell[][] rows = grid.rows();

        assertEquals(1, rows.length);
        assertEquals(1, rows[0].length);
    }

    @Test
    public void allCellsInANewGridShouldBeDead() {
        Grid grid = new Grid(2,2);
        assertEquals(0, aliveCount(grid));
    }

    @Test
    public void a2x2GridWithOneLiveCellShouldBeEmptyAfterOneGeneration() {
        Grid grid = new Grid(2, 2);
        grid.rows()[0][0].isAlive(true);
        grid.nextGeneration();

        assertEquals(0, aliveCount(grid));
    }

    @Test
    public void aCellShouldNotBeItsOwnNeigbor() {
        Grid grid = new Grid(2, 2);
        for (Cell[] row : grid.rows()) {
            for (Cell cell : row) {
                assertFalse(cell.getNeighbors().contains(cell));
            }
        }
    }

    @Test
    public void aCellInA2x2GridShouldHaveThreeNeighbors() {
        Grid grid = new Grid(2, 2);
        Cell cell = grid.rows()[0][0];
        Cell[] expected = new Cell[]{
                grid.rows()[0][1],
                grid.rows()[1][0],
                grid.rows()[1][1]
        };
        for (Cell expectedCell : expected){
            assertTrue(cell.getNeighbors().contains(expectedCell));
        }
    }

    @Test
    public void centerCellInA3x3GridShouldHave8Neighbors() {
        Grid grid = new Grid(3, 3);
        Cell center = grid.rows()[1][1];
        List<Cell> expected = new ArrayList<>();
        for (int i = 0; i < grid.rows().length; ++i) {
            Cell[] row = grid.rows()[i];
            for (int it = 0; it < row.length; it++) {
                if (!(i == 1 && it == 1)) {
                    expected.add(row[it]);
                }
            }
        }
        assertEquals(8, expected.size());
        for (Cell expectedCell : expected){
            assertTrue(center.getNeighbors().contains(expectedCell));
        }
    }

    @Test
    public void a2x2GridWithThreeLiveCellShouldBeFullAfterOneGeneration() {
        Grid grid = new Grid(2, 2);
        makeAllLive(grid);
        grid.rows()[0][0].isAlive(false);
        grid.nextGeneration();

        assertEquals(4, aliveCount(grid));
    }

    @Test
    public void a3x3GridWithTopRowLiveShouldResultInCenterLiveAfterOneGeneration() {
        Grid grid = new Grid(3, 3);
        for (Cell cell : grid.rows()[0]) {
           cell.isAlive(true);
        }
        grid.nextGeneration();

        assertTrue(grid.rows()[1][1].isAlive());
    }

    @Test
    public void a3x3GridWithTopRowLiveShouldResultInAllDeadAfterTwoGenerations() {
        Grid grid = new Grid(3, 3);
        for (Cell cell : grid.rows()[0]) {
            cell.isAlive(true);
        }
        grid.nextGeneration();
        grid.nextGeneration();

        assertEquals(0, aliveCount(grid));
    }

    @Test
    public void aFull3x3GridShouldResultInOnlyCornersLiveAfterOneGeneration() {
        Grid grid = new Grid(3, 3);
        makeAllLive(grid);
        grid.nextGeneration();

        assertEquals(4, aliveCount(grid));
        assertTrue(grid.rows()[0][0].isAlive());
        assertTrue(grid.rows()[2][2].isAlive());
        assertTrue(grid.rows()[2][0].isAlive());
        assertTrue(grid.rows()[0][2].isAlive());
    }

    @Test
    public void aFull3x3GridShouldBeEmptyAfterTwoGenerations() {
        Grid grid = new Grid(3, 3);
        makeAllLive(grid);
        grid.nextGeneration();
        grid.nextGeneration();

        assertEquals(0, aliveCount(grid));
    }

    private void makeAllLive(Grid grid) {
        for (Cell[] row : grid.rows()) {
            for (Cell cell : row) {
                cell.isAlive(true);
            }
        }
    }

    private int aliveCount(Grid grid) {
        int alive = 0;
        for (Cell[] row : grid.rows()) {
            for (Cell cell : row) {
                alive += cell.isAlive() ? 1 : 0;
            }
        }
        return alive;
    }
}
