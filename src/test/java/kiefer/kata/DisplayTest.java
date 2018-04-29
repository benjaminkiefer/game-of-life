package kiefer.kata;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by moose on 4/28/2018.
 */
public class DisplayTest {

    private Display display;

    @Before
    public void setup() {
        display = new Display();
    }

    @Test
    public void singleLiveCellShouldPrintBracketsWithAnX() {
        Cell cell = new Cell(true);
        String expected = "[x]";
        String actual = display.cellString(cell);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void singleDeadCellShouldPrintBracketsWithSpace() {
        Cell cell = new Cell(false);
        String expected = "   ";
        String actual = display.cellString(cell);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void rowOfTwoDeadCellsShouldPrintSideBySideBracketsWithSpace() {
        Grid grid = new Grid(2, 1);
        String expected = "      ";
        String actual = display.rowString(grid.rows()[0]);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void columnsOfThreeDeadCellsShouldPrintOneOnTopOfOtherBracketsWithSpace() {
        Grid grid = new Grid(1, 3);
        String expected = "   \n   \n   \n";
        String actual = display.gridString(grid);
        System.out.print(actual);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void twoColumnsOfThreeDeadCellsShouldPrintSideBySideOneOnTopOfOtherBracketsWithSpace() {
        Grid grid = new Grid(2, 3);
        String expected = "      \n      \n      \n";
        String actual = display.gridString(grid);
        System.out.print(actual);
        Assert.assertEquals(expected, actual);
    }
}
