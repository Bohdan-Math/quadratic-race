package race.panel;

import java.awt.*;

import javax.swing.*;

import race.event.StartButtonsAdapter;
import race.logic.Difficulty;

public class PStart extends JPanel {

	private Image buttonEasy = new ImageIcon(getClass().getClassLoader().getResource("pictures/buttonEasy.png"))
			.getImage();

	private Image buttonNormal = new ImageIcon(getClass().getClassLoader().getResource("pictures/buttonNormal.png"))
			.getImage();

	private Image buttonHard = new ImageIcon(getClass().getClassLoader().getResource("pictures/buttonHard.png"))
			.getImage();

	public PStart(JFrame buttonsFrame) {
		setLayout(new GridLayout(2, 1));
		add(new Text("Choose your difficulty"));
		add(new StartButtons(buttonsFrame));
	}

	class StartButtons extends JPanel {

		StartButtons(JFrame buttonsFrame) {

			JButton b1 = new JButton("easy");
			JButton b2 = new JButton("normal");
			JButton b3 = new JButton("hard");

			b1.setIcon(new ImageIcon(buttonEasy));
			b1.setVerticalTextPosition(AbstractButton.BOTTOM);
			b1.setHorizontalTextPosition(AbstractButton.CENTER);

			b2.setIcon(new ImageIcon(buttonNormal));
			b2.setVerticalTextPosition(AbstractButton.BOTTOM);
			b2.setHorizontalTextPosition(AbstractButton.CENTER);

			b3.setIcon(new ImageIcon(buttonHard));
			b3.setVerticalTextPosition(AbstractButton.BOTTOM);
			b3.setHorizontalTextPosition(AbstractButton.CENTER);

			b1.addActionListener(new StartButtonsAdapter(buttonsFrame, Difficulty.easy));
			b2.addActionListener(new StartButtonsAdapter(buttonsFrame, Difficulty.normal));
			b3.addActionListener(new StartButtonsAdapter(buttonsFrame, Difficulty.hard));

			add(b1);
			add(b2);
			add(b3);
		}
	}

}