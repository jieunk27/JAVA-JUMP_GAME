package game;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;


public class PlayScreen extends JPanel {

	protected PlayPanel view;
	private PlayScreen playScreen;
	private JLabel back;
	private JPanel line;
	private BtnListener btnL;
	protected JButton btnS, jump,stop;
	protected ThreadSpread threadSpread;
	protected JumpThread jumpThread;
	protected JLabel lbl;
	protected JLabel list[] = new JLabel[100];
	protected int i = 0;
	private ImageIcon img,img1, img2;
	protected JLabel lifeL;
	protected int life;
	protected int score=0;
	protected JLabel scoreL;
	
	public PlayScreen(PlayPanel view) {
		

		setBounds(20, 100, 800, 600);
		setBackground(Color.white);
		setLayout(null);

		
		life = 3;
		score = 0;

		img1 = new ImageIcon("Game/image/hurdle.png");
		for (i = 0; i < 100; i++) {

			list[i] = new JLabel(img1);
			list[i].setBounds(0, 430, 200,200);
			add(list[i]);
			list[i].setVisible(false);
		}

		img2 = new ImageIcon("Game/image/run.png");
		lbl = new JLabel(img2);
		lbl.setBounds(600, 450, 110, 150);
		add(lbl);

		this.view = view;
		playScreen = this;
		
		btnL = new BtnListener();

		btnS = new JButton("START");
		btnS.setBounds(10, 10, 100, 20);
		btnS.setFont(new Font("Verdana", Font.BOLD, 15));
		btnS.setBackground(Color.DARK_GRAY);
		btnS.setForeground(Color.white);
		btnS.addActionListener(btnL);
		add(btnS);
		
		stop = new JButton("STOP");
		stop.setBounds(10, 30, 100, 20);
		stop.setFont(new Font("Verdana", Font.BOLD, 15));
		stop.setBackground(Color.DARK_GRAY);
		stop.setForeground(Color.white);
		stop.addActionListener(btnL);
		add(stop);

		jump = new JButton("JUMP");
		jump.setBounds(700, 0, 100, 100);
		jump.setFont(new Font("Verdana", Font.BOLD, 15));
		jump.setBackground(Color.DARK_GRAY);
		jump.setForeground(Color.white);
		jump.setHorizontalAlignment(SwingConstants.CENTER);
		jump.addActionListener(btnL);
		add(jump);

		
		lifeL = new JLabel("LIFE : " + life);
		lifeL.setBounds(400, 0,  300, 100);
		lifeL.setFont(new Font("Verdana", Font.BOLD, 30));
		lifeL.setForeground(Color.RED);
		lifeL.setHorizontalAlignment(SwingConstants.CENTER);
		add(lifeL);
	
		scoreL = new JLabel("SCORE : " + score);
		scoreL.setBounds(100,0, 300, 100);
		scoreL.setFont(new Font("Verdana", Font.BOLD, 30));
		scoreL.setForeground(Color.black);
		scoreL.setHorizontalAlignment(SwingConstants.CENTER);
		add(scoreL);
		
		/*img = new ImageIcon("Game/image/background.jpg");
		back=new JLabel(img);
		back.setBounds(0,0, 800, 750);

		add(back);
		*/

	}


	private class BtnListener implements ActionListener {

		public void actionPerformed(ActionEvent event) {
			Object obj = event.getSource();

			if (obj == btnS) {
				view.btnB.setEnabled(false);
				btnS.setEnabled(false);
				threadSpread = new ThreadSpread(playScreen);
				score=0;
				life=3;
				lifeL.setText("LIFE : " + playScreen.life);
				scoreL.setText("SCORE : " + playScreen.score);
				threadSpread.start();


			} else if (obj == jump) {
				jumpThread = new JumpThread(playScreen);
				jumpThread.start();
			}
			else{
				threadSpread.stop();
				life=3;
				score=0;
				lifeL.setText("LIFE : " + playScreen.life);
				scoreL.setText("SCORE : " + playScreen.score);
				i=0;
				for (i = 0; i < 100; i++) {

					list[i].setBounds(0, 430, 200,200);
					list[i].setVisible(false);
				}

				btnS.setEnabled(true);
				view.btnB.setEnabled(true);
			}

		}

	}

}
