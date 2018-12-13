package race.bus.view.mode;

import race.mvc.model.mode.ModeModel;

public class EasyModeModelSetter extends AbstractModeModelSetter {

    public EasyModeModelSetter(ModeModel modeModel) {
        super(modeModel);
    }

    @Override
    public void handle(Enum event) {
        System.out.println(event);
        this.modeModel.setEasyMode();
    }
}
