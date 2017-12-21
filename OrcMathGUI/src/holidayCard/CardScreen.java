package holidayCard;

import java.io.File;
import java.util.List;

import javax.swing.JFrame;

import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.TextArea;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;

public class CardScreen extends FullFunctionScreen {
	
	private TextArea greeting;
	private Button switchButton;
	
	public CardScreen(int width, int height) {
		super(width, height);
	}

	public void initAllObjects(List<Visible> viewObjects) {
		greeting = new TextArea(400, 300, 200, 30, "Happy Holidays!");
		viewObjects.add(greeting);

		switchButton = new Button(1000, 700, 200, 30, "switch", new Action() {
			
			@Override
			public void act() {
				CardGUI.sample.setScreen(CardGUI.screenA);
			}
		});
		viewObjects.add(switchButton);
	}

	protected void switchClick() {
		
	}

//	//@Override
	public JFrame getWindow() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
