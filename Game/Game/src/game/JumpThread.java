package game;

public class JumpThread implements Runnable {

	private Thread myThread;
	private PlayScreen playScreenView;
	private int sleep;
	private int sleepTime;

	public JumpThread(PlayScreen playScreen) {
		myThread = null;
		playScreenView = playScreen;
		sleep = 0;
	}

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

	public void sleep(int time) {
		sleep = 1;
		sleepTime = time;
	}// sleep() sleep,sleepTime ¼³Á¤

	public void run() {
		try {
			playScreenView.jump.setEnabled(false);

			while (playScreenView.lbl.getY() > 220) {
				playScreenView.lbl.setLocation(playScreenView.lbl.getX(), playScreenView.lbl.getY() - 1);
				myThread.sleep(1);

				// playScreenView.lbl.repaint();
			}
			myThread.sleep(1000);
			while (playScreenView.lbl.getY() < 460) {
				playScreenView.lbl.setLocation(playScreenView.lbl.getX(), playScreenView.lbl.getY() + 1);
				myThread.sleep(1);
				// playScreenView.lbl.repaint();
			}
			if (playScreenView.life <= 0) {
				playScreenView.score = 0;
			}

			playScreenView.jump.setEnabled(true);
		} catch (Exception e) {

		}
	}

}
