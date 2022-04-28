package game.world.utils;

import game.player.Player;
import game.world.Direction;
import game.world.TheWorld;
import game.world.WorldRules;
import game.world.point.Point;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TheWorld world = new TheWorld(new WorldRules(40, 20, WorldRules.RuleType.WORLD));

        Player player = new Player(0, 0, 40, 20, Direction.SOUTH);

        Scanner scanner = new Scanner(System.in);
        String input = "";
        do {
            switch (input.toLowerCase(Locale.ROOT)) {
                case "a" -> player.turnLeft();
                case "d" -> player.turnRight();
                case "w" -> player.step();
            }

            for(Point[] points : world.worldMap()) {
                for(Point point : points) {
                    int x = point.coordinate().x();
                    int y = point.coordinate().y();
                    if(x == player.getX() && y == player.getY()) {
                        System.out.print("@");
                    } else System.out.print("-");
                }
                System.out.print("\n");
            }

            input = scanner.nextLine();
        } while (!input.equalsIgnoreCase("q"));
    }
}
