package holidayCard;

import java.util.List;

import guiTeacher.components.*;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;

public class Front extends FullFunctionScreen {

	private TextBox greeting;
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
		
		greeting = new TextBox(400, 300, 200, 30, "Happy Holidays!");
		viewObjects.add(greeting);
	}
	

}