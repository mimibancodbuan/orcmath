package myStuff;

import guiTeacher.GUIApplication;

public class SimonGameMimi extends GUIApplication{
	
	public static void main(String[] args) {
		SimonGameMimi s = new SimonGameMimi(800,600);
		Thread runner = new Thread(s);
		runner.start();
	}

	public SimonGameMimi(int width, int height) {
		super(width, height);
		setVisible(true);
	}

	@Override
	public void initScreen() {
		SimonScreenMimi screen = new SimonScreenMimi(getWidth(), getHeight());
		setScreen(screen);
	}

}