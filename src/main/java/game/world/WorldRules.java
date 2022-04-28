package game.world;

public record WorldRules(int width, int height, RuleType type) {

    public enum RuleType {
        WORLD, UNDERGROUND
    }
}
