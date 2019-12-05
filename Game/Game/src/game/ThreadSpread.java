package game;

import java.util.Random;

import javax.swing.JOptionPane;

public class ThreadSpread implements Runnable {

	private Thread myThread;
	private PlayScreen playScreenView;
	private PlayPanel playPanel;
	private int random;
	private int sleep;
	private int sleepTime;
	private int max = 800;
	public int flag = 0;
	private Random obj = new Random();
	private int speed;

	public ThreadSpread(PlayScreen playScreen) {
		myThread = null;
		playScreenView = playScreen;
		sleep = 0;
	}

	public ThreadSpread(PlayPanel playpanel) {
		myThread = null;
		playPanel= playpanel;
		sleep = 0;
	}
	
	public void sleep(int time) {
		sleep = 1;
		sleepTime = time;
	}// sleep() sleep,sleepTime ¼³Á¤

	public void start() {
		
		if (myThread == null) {
			myThread = new Thread(this);
		}
	
		myThread.start();
		
	}
	public void stop() {
		if (myThread != null) {
			myThread.stop();
		}
	}

	public void run() {
		try {
			
			for (int i = 0; i < 100; i++) {
				speed = obj.nextInt(3) + 3;
				while (playScreenView.list[i].getX() < max) {
					playScreenView.list[i].setVisible(true);
					playScreenView.list[i].setLocation(playScreenView.list[i].getX() + speed,
							playScreenView.list[i].getY());
					if ((playScreenView.lbl.getX() < playScreenView.list[i].getX() + 120
							&& playScreenView.lbl.getX() > playScreenView.list[i].getX())
							|| (playScreenView.lbl.getX() + 110 > playScreenView.list[i].getX()
									&& playScreenView.lbl.getX() + 110 < playScreenView.list[i].getX() + 120)) {
						if ((playScreenView.lbl.getY() + 150) > playScreenView.list[i].getY()) {
							flag = 1;

						}
						else
						{
							flag=2;
						}
					}

					myThread.sleep(10);

				}
				
				
				if (flag == 1) {

					playScreenView.lbl.setLocation(600, 450);
					playScreenView.life--;
					// JOptionPane.showMessageDialog(playScreenView, "LIFE DECREASE",
					// "Notice",JOptionPane.WARNING_MESSAGE);
					playScreenView.lifeL.setText("LIFE : " + playScreenView.life);
					
					if (playScreenView.life <= 0) {
						JOptionPane.showMessageDialog(playScreenView, "You got " + playScreenView.score + "points!","", JOptionPane.PLAIN_MESSAGE);
						playScreenView.score =0;
						playScreenView.life=3;
						playScreenView.btnS.setEnabled(true);
					   playScreenView.view.btnB.setEnabled(true);
					    stop();
					    
					}
					flag=0;
					
				} else if(flag==2){
					playScreenView.score += 50;
					playScreenView.scoreL.setText("SCORE : " + playScreenView.score);
				}
			}
		} catch (Exception e) {

		}

	}

}
