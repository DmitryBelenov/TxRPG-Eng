package game.world.point;

import game.world.Coordinate;

public record Character(Coordinate coordinate, Type type) implements Point {
    @Override
    public Type type() {
        return this.type;
    }

    @Override
    public Coordinate coordinate() {
        return this.coordinate;
    }
}
