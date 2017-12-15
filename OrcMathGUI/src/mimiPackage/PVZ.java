package mimiPackage;

import java.awt.Color;
import java.awt.Graphics2D;

import guiTeacher.components.AnimatedComponent;
import guiTeacher.components.Component;

public class PVZ extends AnimatedComponent {
	
	private String plantname;
	private int price;
	private String zombietype;

	public PVZ(String plantname, int price) {
		super(40, 40, 125, 140);
		addSequence("resources/MimiSpriteSheet.png", 100, 0, 0, 125, 140, 6);
		Thread animation = new Thread(this);
		animation.start();
		update();
	}

	@Override
	public void update(Graphics2D g) {
		g.setColor(Color.black);
		super.update(g);
	}

	public String toString() {
		return plantname + ", $" + price;
	}
	
}
