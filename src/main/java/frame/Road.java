package frame;

import logic.Difficulty;
import panel.PRoad;

public class Road extends BaseFrame {

	public Road(Difficulty difficulty) {

		PRoad road = new PRoad(difficulty, this);

		int sizeX = road.getRoad().getWidth(null);
		int sizeY = road.getRoad().getHeight(null);
		setSize(sizeX, sizeY);

		add(road);
		// pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}
}