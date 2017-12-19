package mimiPackage;

import java.util.List;

import guiTeacher.components.TextField;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;

public class CatalogScreen extends FullFunctionScreen {
	
	private TextField descriptionBox;
	private TextField name;
	private TextField price;

	public CatalogScreen(int width, int height) {
		super(width, height);
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		descriptionBox = new TextField(40, 40, 200, 30, "insert text", "description");
		viewObjects.add(descriptionBox);
		name = new TextField(40, 90, 200, 30, "insert name", "name");
		viewObjects.add(name);
		price = new TextField(40, 140, 200, 30, "insert price", "price");
		viewObjects.add(price);
		
	}

}
