package race.mvc.controller.race;

import javafx.animation.AnimationTimer;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import race.bus.EventPublisher;
import race.mvc.model.race.RaceModel;
import race.mvc.model.race.player.PlayerModel;
import race.mvc.model.race.road.RoadModel;
import race.mvc.view.race.RaceView;
import race.mvc.view.race.player.PlayerView;
import race.mvc.view.race.road.RoadView;

public class RaceController {

    private RaceView raceView;
    private RaceModel raceModel;

    private boolean moveForward;
    private boolean moveBack;
    private boolean moveLeft;
    private boolean moveRight;

    private EventPublisher eventPublisher;

    public RaceController(EventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;
        raceView = new RaceView();
        raceModel = new RaceModel();
    }

    public Scene initializeScene() {
        RoadModel roadModel = raceModel.getRoadModel();
        RoadView roadView = raceView.getRoadView();

        PlayerModel playerModel = raceModel.getPlayerModel();
        PlayerView playerView = raceView.getPlayerView();

        Scene scene = new Scene(raceView);

        new AnimationTimer() {

            @Override
            public void handle(long now) {

                if (moveForward) {
                    roadModel.d2S(0.3);
                }
                if (!moveForward) {
                    roadModel.d2S(-0.3);
                }
                if (moveBack) {
                    roadModel.d2S(-0.5);
                }
                roadView.move(roadModel.dS());


                if (moveLeft || moveRight) {
                    if (moveLeft) {
                        playerModel.dx(-7);
                    }
                    if (moveRight) {
                        playerModel.dx(7);
                    }
                } else {
                    playerModel.dx(0);
                }
                playerView.move(playerModel.dx());
            }
        }.start();


        scene.addEventHandler(KeyEvent.KEY_PRESSED, keyEvent -> {
            KeyCode keyCode = keyEvent.getCode();

            if (keyCode.equals(KeyCode.W)) {
                moveForward = true;
            }
            if (keyCode.equals(KeyCode.S)) {
                moveBack = true;
            }
            if (keyCode.equals(KeyCode.A)) {
                moveLeft = true;
                moveRight = false;
            }
            if (keyCode.equals(KeyCode.D)) {
                moveRight = true;
                moveLeft = false;
            }
        });

        scene.addEventHandler(KeyEvent.KEY_RELEASED, keyEvent -> {
            KeyCode keyCode = keyEvent.getCode();
            if (keyCode.equals(KeyCode.W)) {
                moveForward = false;
            }
            if (keyCode.equals(KeyCode.S)) {
                moveBack = false;
            }
            if (keyCode.equals(KeyCode.A)) {
                moveLeft = false;
            }
            if (keyCode.equals(KeyCode.D)) {
                moveRight = false;
            }
        });

        return scene;
    }
}