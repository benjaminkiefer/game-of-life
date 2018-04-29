package kiefer.kata;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by moose on 4/27/2018.
 */
public class CellTest {

    @Test
    public void cellShouldReturnLifeWhenInitiatedWithLife() {
        Cell cell = new Cell(true);
        assertTrue(cell.isAlive());
    }

    @Test
    public void cellShouldReturnDeadWhenInitiatedWithoutLife() {
        Cell cell = new Cell(false);
        assertFalse(cell.isAlive());
    }

    @Test
    public void cellWithTwoLiveNeighborsShouldStayAlive() {
        Cell cell = new Cell(true);
        cell.addNeighbor(new Cell(true));
        cell.addNeighbor(new Cell(true));

        assertTrue(cell.willLive());
    }

    @Test
    public void cellWithThreeLiveNeighborsShouldStayAlive() {
        Cell cell = new Cell(true);
        cell.addNeighbor(new Cell(true));
        cell.addNeighbor(new Cell(true));
        cell.addNeighbor(new Cell(true));

        assertTrue(cell.willLive());
    }

    @Test
    public void cellWithOneLiveNeighborsShouldDie() {
        Cell cell = new Cell(true);
        cell.addNeighbor(new Cell(true));

        assertTrue(!cell.willLive());
    }

    @Test
    public void cellWithFourLiveNeighborsShouldDie() {
        Cell cell = new Cell(true);
        cell.addNeighbor(new Cell(true));
        cell.addNeighbor(new Cell(true));
        cell.addNeighbor(new Cell(true));
        cell.addNeighbor(new Cell(true));

        assertTrue(!cell.willLive());
    }

    @Test
    public void aDeadCellWithThreeLiveNeighborsShouldLive() {
        Cell cell = new Cell(false);
        cell.addNeighbor(new Cell(true));
        cell.addNeighbor(new Cell(true));
        cell.addNeighbor(new Cell(true));

        assertTrue(cell.willLive());
    }

    @Test
    public void aDeadCellWithTwoLiveNeighborsShouldNotLive() {
        Cell cell = new Cell(false);
        cell.addNeighbor(new Cell(true));
        cell.addNeighbor(new Cell(true));

        assertFalse(cell.willLive());
    }

    @Test
    public void aDeadCellShouldBeAliveOnceSetAlive() {
        Cell cell = new Cell();
        cell.isAlive(true);

        assertTrue(cell.isAlive());
    }

    @Test
    public void aCellShouldContainANeighborAfterAdding() {
        Cell cell = new Cell();
        Cell cell2 = new Cell();
        cell.addNeighbor(cell2);

        assertTrue(cell.getNeighbors().contains(cell2));
    }
}
