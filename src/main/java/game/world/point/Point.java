package game.world.point;

import game.world.Coordinate;
import game.world.Direction;

public interface Point {

    int BORDER = -1;

    enum Type {
        GROUND(true),
        SAND(true),
        ROAD(true),
        TREE(false),
        ROCK(false),
        HOUSE(false);

        private final boolean isFlat;

        Type(boolean isFlat) {
            this.isFlat = isFlat;
        }

        public boolean isFlat() {
            return this.isFlat;
        }
    }

    Type type();

    Coordinate coordinate();

    default Coordinate nearMeTo(Direction dir, int maxX, int maxY) throws RuntimeException {
        int x = coordinate().x(), y = coordinate().y();
        switch (dir) {
            case WEST -> {
                return new Coordinate(x > 0 ? --x : BORDER, y);
            }
            case EAST -> {
                return new Coordinate(x < maxX - 1 ? ++x : BORDER, y);
            }
            case SOUTH -> {
                return new Coordinate(x, y < maxY - 1 ? ++y : BORDER);
            }
            case NORTH -> {
                return new Coordinate(x, y > 0 ? --y : BORDER);
            }
        }
        throw new RuntimeException("Wrong direction " + dir.name());
    }
}
