package hotpursuit.state;

import hotpursuit.Game;
import hotpursuit.constants.Dimensions;
import hotpursuit.constants.Positions;
import hotpursuit.constants.Strings;
import hotpursuit.gfx.Assets;

import java.awt.*;

public class FinishState extends State {

    String totalScores;
    GameState gameState;

    public FinishState(Game game, String totalScores) {
        super(game);
        this.totalScores = totalScores;
    }

    public void tick() {
        if (game.getKeyManager().enter) { // if 'enter' pressed
            gameState = new GameState(Dimensions.WINDOW_WIDTH, Dimensions.WINDOW_HEIGHT, game);
            State.setState(gameState);
        }
    }

    public void render(Graphics graphics) {
        graphics.drawImage(Assets.imgFinish, 0, 0, null);

        graphics.setColor(Color.white);
        graphics.setFont(new Font(Strings.GAME_FONT_NAME, Font.PLAIN, Dimensions.FINISH_SCORE_TEXT_SIZE));
        graphics.drawString(Strings.FINISH_SCORE_TEXT, Positions.FINISH_SCORE_TEXT_POS_X, Positions.FINISH_SCORE_TEXT_POS_Y);

        graphics.setColor(Color.red);
        graphics.setFont(new Font(Strings.GAME_FONT_NAME, Font.PLAIN, Dimensions.FINISH_SCORE_SIZE));
        graphics.drawString(totalScores, Positions.FINISH_SCORE_POS_X, Positions.FINISH_SCORE_POS_Y);

        graphics.setColor(Color.orange);
        graphics.setFont(new Font(Strings.GAME_FONT_NAME, Font.PLAIN, Dimensions.FINISH_RETRY_TEXT_SIZE));
        graphics.drawString(Strings.FINISH_RETRY_TEXT, Positions.FINISH_RETRY_TEXT_POS_X, Positions.FINISH_RETRY_TEXT_POS_Y);

    }

}
