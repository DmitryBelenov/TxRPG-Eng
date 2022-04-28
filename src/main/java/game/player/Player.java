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
            case NORTH -> {
                if (x > 0) x -= 1; else x = 0;
            }
            case WEST -> {
                if (y > 0) y -= 1; else y = 0;
            }
            case SOUTH -> {
                if (x < maxX -1) x += 1; else x = maxX - 1;
            }
            case EAST -> {
                if (y < maxY - 1) y += 1; else y = maxY - 1;
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
}
