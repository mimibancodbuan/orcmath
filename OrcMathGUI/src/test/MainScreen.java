package test;

import guiTeacher.GUIApplication;

public class MainScreen extends GUIApplication{
	public MainScreen(int width, int height) {
		super(width, height);
		setVisible(true);
	}

	@Override
	public void initScreen() {
		GameScreen s= new GameScreen(getWidth(), getHeight());
		setScreen(s);

	}

	public static void main(String[] args) {
		MainScreen test1 = new MainScreen(700,550);
		Thread runner = new Thread(test1);
		runner.start();


	}
}
