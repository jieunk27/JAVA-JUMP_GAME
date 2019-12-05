package game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class PlayPanel extends JPanel {
	protected ThreadSpread threadSpread;
	private PrimaryPanel pPanel;
	public JButton btnB;
	private BtnListener btnL;
	private PlayPanel playPanel;
	private PlayScreen playScreen;

	public PlayPanel() {
		setBackground(Color.lightGray);
		setPreferredSize(new Dimension(1200, 800));
		setLayout(null);
		
		btnL = new BtnListener();

		btnB = new JButton("BACK");
		btnB.setBounds(1050,650, 150, 50);
		btnB.setForeground(Color.white);
		btnB.setFont(new Font("Verdana", Font.PLAIN, 30));
		btnB.setBackground(Color.black);
		btnB.setHorizontalAlignment(SwingConstants.CENTER);
		btnB.addActionListener(btnL);
		add(btnB); // ScoreBoard 버튼 설정
		
		playScreen = new PlayScreen(this);
		add(playScreen);

	}


	private class BtnListener implements ActionListener {

		public void actionPerformed(ActionEvent event) {

			Object obj = event.getSource();
			if (obj == btnB) {
				threadSpread = new ThreadSpread(playPanel);
				threadSpread.stop();
				pPanel.getTitlePanel().setVisible(true);
				pPanel.getPlayPanel().setVisible(false);
				playScreen.life = 3;
				playScreen.score = 0;
				playScreen.lifeL.setText("LIFE : " + playScreen.life);
				playScreen.scoreL.setText("SCORE : " + playScreen.score);
				playScreen.btnS.setEnabled(true);
			}
		}

	}

	public void setMain(PrimaryPanel primaryPanel) {
		this.pPanel = primaryPanel;

	}

}
