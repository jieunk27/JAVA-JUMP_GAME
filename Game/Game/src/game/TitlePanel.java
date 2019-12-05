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

public class TitlePanel extends JPanel {
	private JPanel back;
	private PlayScreen playScreenView;
	private JButton btn = new JButton();
	private BtnListener btnL;
	private JButton btnPlay = new JButton("PLAY");
	private JLabel title;
	private PrimaryPanel pPanel;

	public TitlePanel() {

		btnL = new BtnListener();

		setBackground(Color.white);
		setPreferredSize(new Dimension(1200, 800));
		setLayout(null);
		
		title=new JLabel("Jump Game");
		title.setBounds(450, 200, 300, 100);
		title.setForeground(Color.black);
		title.setFont(new Font("Verdana", Font.PLAIN,40));
		title.setBackground(Color.white);
		title.setHorizontalAlignment(SwingConstants.CENTER);
		add(title);
		
		btnPlay.setBounds(450, 600, 300, 100);
		btnPlay.setForeground(Color.white);
		btnPlay.setFont(new Font("Verdana", Font.PLAIN, 30));
		btnPlay.setBackground(Color.darkGray);
		btnPlay.setHorizontalAlignment(SwingConstants.CENTER);
		btnPlay.addActionListener(btnL);
		add(btnPlay);

	}

	private class BtnListener implements ActionListener {

		public void actionPerformed(ActionEvent event) {

			Object obj = event.getSource();
			if (obj == btnPlay) {
				pPanel.getTitlePanel().setVisible(false);
				pPanel.getPlayPanel().setVisible(true);
				
			}

		}

	}

	public void setMain(PrimaryPanel primaryPanel) {
		this.pPanel = primaryPanel;

	}

}
