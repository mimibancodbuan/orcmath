package holidayCard;

import java.awt.Font;
import java.io.File;

import guiTeacher.GUIApplication;
import guiTeacher.components.StyledComponent;

public class CardGUI extends GUIApplication {

	public static CardGUI card;
	public static Front front;
	public static Inside inside;
	
	public CardGUI(int width, int height) {
		super(width, height);
		setVisible(true);
	}

	@Override
	public void initScreen() {
		try {
			File fontFile = new File("resources/SnowForSanta.ttf");
			Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile);
			Font baseFont=font.deriveFont(36f);
			StyledComponent.setBaseFont(baseFont);
		} catch (Exception e) {
			e.printStackTrace();
		}
		front = new Front(getWidth(), getHeight());
		inside = new Inside(getWidth(), getHeight());
		setScreen(front);
	}

	public static void main(String[] args) {
		card = new CardGUI(800, 500);
		Thread runner = new Thread(card);
		runner.start();
	}

	public void setScreen(Inside inside2) {
		// TODO Auto-generated method stub
		
	}

}