package game.world.utils;

import game.world.Coordinate;
import game.world.Direction;
import game.world.TheWorld;
import game.world.WorldRules;
import game.world.point.Point;

public class Main {
    public static void main(String[] args) {
        TheWorld world = new TheWorld(new WorldRules(20, 50, WorldRules.RuleType.WORLD));

        for(Point[] p : world.worldMap()) {
            for(Point p2 : p) {
                Coordinate c = p2.nearMeTo(Direction.WEST, 20, 50);
                System.out.print("[" + p2.coordinate().x() + ":" + p2.coordinate().y() + "]");
            }
            System.out.print("\n");
        }
    }
}
