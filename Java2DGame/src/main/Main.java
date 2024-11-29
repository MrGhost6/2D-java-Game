package main;

import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {
		
		JFrame window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//make the window close
		window.setResizable(false);								//the user can't resize the window
		window.setTitle("2D test Game");						//game title
		
		GamePannel gamePannel = new GamePannel();
		window.add(gamePannel);
		window.pack();											//causes this window to fit the size and layout of game panel

		window.setLocationRelativeTo(null);						// set the window in the center of the screen
		window.setVisible(true);

	}

}
