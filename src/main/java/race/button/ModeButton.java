package race.button;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import race.logic.Mode;

import static race.picture.PictureReader.readPictureAsInputStream;

public class ModeButton extends Button {

    public ModeButton(Mode mode) {
        setText(mode.name());
        setGraphic(new ImageView(new Image(readPictureAsInputStream(mode.getPathToImage()))));
    }
}
