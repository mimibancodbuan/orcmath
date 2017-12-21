package holidayCard;

import java.awt.Color;

import guiTeacher.GUIApplication;
import guiTeacher.userInterfaces.Screen;
import holidayCard.CardScreen;

public class CardGUI extends GUIApplication {
	
	public static Screen screenA;
	public static Screen screenB;
	public static CardGUI sample;

	public CardGUI(int width, int height) {
		super(width, height);
		setVisible(true);
	}

	@Override
	public void initScreen() {
		CardScreen s = new CardScreen(getWidth(), getHeight());
		setScreen(s);
		
	}

	public static void main(String[] args) {
		CardGUI sample = new CardGUI(800, 550);
		Thread go = new Thread(sample);
		go.start();
	}

}