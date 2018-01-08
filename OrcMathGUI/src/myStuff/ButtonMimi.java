package myStuff;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import guiTeacher.components.Action;
import guiTeacher.components.Button;

public class ButtonMimi extends Button implements ButtonInterfaceMimi {

private Color original;
private boolean hover;

	public ButtonMimi(int x, int y, int w, int h, String text, Color color, Action action) {
		super(x, y, w, h, text, color, action);
	}

	public ButtonMimi(int x, int y, int w, int h, String text, Action action) {
		super(x, y, w, h, "", null);
		update();
	}

	@Override
	public void setColor(Color color) {
		this.setColor(color);
		color = original;
		this.hover = false;
	}

	@Override
	public void highlight() {
		setColor(original.brighter());
	}

	@Override
	public void dim() {
		setColor(original.darker());
	}
	
	public void drawButton(Graphics2D g, boolean hover) {
		g.drawRect(20,50,100,100);
		if(hover == true) {
			highlight();
		}
		else
			dim();
	}

}
