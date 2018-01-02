package holidayCard;

import java.awt.Color;
import java.util.List;

import guiTeacher.components.*;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;

public class Front extends FullFunctionScreen {

	private TextArea greeting;
	private Button open;
	
	public Front(int width, int height) {
		super(width, height);
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		
		viewObjects.add(new Graphic(0, 0, getWidth(),getHeight(),"resources/bg.png"));
		Button open = new Button((getWidth()-100)/2,getHeight()-40,100,30,"Open",new Action() {
			
			@Override
			public void act() {
				CardGUI.card.setScreen(CardGUI.inside);
			}
		});
		
		viewObjects.add(open);
		
		greeting = new TextArea(400, 100, 400, 400, "Happy Holidays!");
		greeting.setCustomTextColor(Color.green);
		greeting.update();
		viewObjects.add(greeting);
	}
	

}