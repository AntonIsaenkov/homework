package exams.exam3;

import java.util.Objects;

public class ExitGameCommand implements Command {

    private GameFunction gameFunction;

    public ExitGameCommand(GameFunction gameFunction) {
        this.gameFunction = Objects.requireNonNull(gameFunction);
    }

    @Override
    public void execute() {
        gameFunction.exitGame();
    }
}
