package game;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

public class PrimaryPanel extends JPanel {

	private JPanel panel0;
	private TitlePanel panel1;
	private PlayPanel panel2;
	
	public PrimaryPanel() {

		panel1 = new TitlePanel();
		panel2 = new PlayPanel();

		panel0 = new JPanel();
		panel0.setVisible(true);
		panel0.setBackground(Color.red);
		panel0.setPreferredSize(new Dimension(1200, 800));
		panel0.setBounds(0, 0, 1200, 800);
		panel0.setLayout(null);

		add(panel1);
		add(panel2);

		panel1.setMain(this);
		panel2.setMain(this);

		panel1.setVisible(true);
		panel2.setVisible(false);

	}

	public TitlePanel getTitlePanel() {

		return panel1;
	}

	public PlayPanel getPlayPanel() {

		return panel2;
	}

}
