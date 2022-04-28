package game.world;

import game.world.point.GroundPoint;
import game.world.point.Point;
import game.world.point.UndergroundPoint;

import java.util.Objects;

public abstract class World {

    protected Point[][] worldMap;

    public World(WorldRules rules) {
        generateWorld(rules);
    }

    private void generateWorld(WorldRules rules) {
        int width = rules.width();
        int height = rules.height();

        worldMap = new Point[height][width];

        for(int w = 0; w < width; w++) {
            for(int h = 0; h < height; h++) {
                switch (rules.type()) {
                    case WORLD -> worldMap[h][w] = new GroundPoint(new Coordinate(w, h), /* rules depends */ Point.Type.GROUND);
                    case UNDERGROUND -> worldMap[h][w] = new UndergroundPoint(new Coordinate(w, h), /* rules depends */ Point.Type.GROUND);
                }
            }
        }
    }

    /* throws NPE if world wasn't generated */
    public Point[][] worldMap() {
        return Objects.requireNonNull(this.worldMap);
    }
}
