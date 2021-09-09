package hotpursuit;

import hotpursuit.constants.Dimensions;
import hotpursuit.constants.Strings;

public class Launcher {
    public static void main(String[] args) {
        Game game = new Game(Strings.GAME_NAME.concat(" ").concat(Strings.GAME_VERSION), Dimensions.WINDOW_WIDTH, Dimensions.WINDOW_HEIGHT);
        game.start();
    }
}
