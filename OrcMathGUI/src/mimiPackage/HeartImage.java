package mimiPackage;

import java.awt.Color;
import java.awt.Graphics2D;

import guiTeacher.components.Component;

public class HeartImage extends Component {

	public HeartImage() {
		super(40, 40, 100, 100);
	}

	@Override
	public void update(Graphics2D g) {
		g.setColor(Color.black);
		g.drawRect(0, 0, getWidth(), getHeight());
	}

}
