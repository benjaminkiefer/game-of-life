package kiefer.kata;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by moose on 4/27/2018.
 */
public class Cell {

    private boolean isAlive = false;
    private List<Cell> neighbors = new ArrayList<>();
    private Random ran = new Random();

    public Cell(boolean isAlive) {
        this.isAlive = isAlive;
    }

    public Cell() {
        this(false);
    }

    public boolean isAlive() {
        return this.isAlive;
    }

    public void isAlive(boolean alive) {
        this.isAlive = alive;
    }

    public boolean remainsAlive() {
        int aliveNeighbors = aliveNeighborCount();
        return aliveNeighbors > 1 && aliveNeighbors < 4;
    }

    public boolean spontaneousGeneration() {
        int aliveNeighbors = aliveNeighborCount();
        boolean lifeFindsAWay = false;
        if (aliveNeighborCount() > 0){
            lifeFindsAWay = (ran.nextInt(1000) == 1);
        }
        return aliveNeighbors == 3 || lifeFindsAWay;
    }

    public void addNeighbor(Cell neighbor) {
        this.neighbors.add(neighbor);
    }

    public List<Cell> getNeighbors() {
        return this.neighbors;
    }

    public boolean willLive() {
        if (isAlive()) {
            return remainsAlive();
        } else {
            return spontaneousGeneration();
        }
    }

    protected int aliveNeighborCount() {
        int aliveNeighbors = 0;
        for (Cell neighbors : neighbors) {
            aliveNeighbors += neighbors.isAlive() ? 1 : 0;
        }
        return aliveNeighbors;
    }

    protected void setRandom(Random ran) {
        this.ran = ran;
    }
}
