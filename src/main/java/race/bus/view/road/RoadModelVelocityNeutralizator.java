package race.bus.view.road;

import race.mvc.model.race.road.RoadModel;

public class RoadModelVelocityNeutralizator extends AbstractRoadModelVelocityChanger {

    private static final double NEUTRAL_dV = -5;

    public RoadModelVelocityNeutralizator(RoadModel roadModel) {
        super(roadModel);
    }

    @Override
    double dV() {
        return NEUTRAL_dV;
    }
}
