package game.player;

import game.world.Direction;

public class Player {

    private int x, y;
    private final int maxX, maxY;

    private Direction viewDir;

    public Player(int x, int y, int maxX, int maxY, Direction viewDir) {
        this.x = x;
        this.y = y;
        this.maxX = maxX;
        this.maxY = maxY;
        this.viewDir = viewDir;
    }

    public void step() {
        switch (this.viewDir) {
            case WEST -> {
                if (x > 0) x--; else x = 0;
            }
            case NORTH -> {
                if (y > 0) y--; else y = 0;
            }
            case EAST -> {
                if (x < maxX - 1) x++; else x = maxX - 1;
            }
            case SOUTH -> {
                if (y < maxY - 1) y++; else y = maxY - 1;
            }
        }
    }

    public void turnLeft() {
        switch (this.viewDir) {
            case NORTH -> this.viewDir = Direction.WEST;
            case WEST -> this.viewDir = Direction.SOUTH;
            case SOUTH -> this.viewDir = Direction.EAST;
            case EAST -> this.viewDir = Direction.NORTH;
        }
    }

    public void turnRight() {
        switch (this.viewDir) {
            case NORTH -> this.viewDir = Direction.EAST;
            case EAST -> this.viewDir = Direction.SOUTH;
            case SOUTH -> this.viewDir = Direction.WEST;
            case WEST -> this.viewDir = Direction.NORTH;
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
