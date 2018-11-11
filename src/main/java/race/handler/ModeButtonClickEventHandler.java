package race.handler;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import race.frame.Road;
import race.logic.Mode;

public class ModeButtonClickEventHandler implements EventHandler<ActionEvent> {

    private Mode mode;

    public ModeButtonClickEventHandler(Mode mode) {
        this.mode = mode;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        System.out.println("--->" + mode.getMillisecondsInterval());
//        new Road(Difficulty.modeToDifficulty(mode));
        new Road(mode);
    }
}