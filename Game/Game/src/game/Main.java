
package game;

import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {

		JFrame frame = new JFrame("Game");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		PrimaryPanel primary = new PrimaryPanel();
		frame.getContentPane().add(primary);

		frame.pack();
		frame.setVisible(true);

	}

}
