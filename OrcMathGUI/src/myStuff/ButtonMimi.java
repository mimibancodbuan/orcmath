package myStuff;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import guiTeacher.components.Action;
import guiTeacher.components.Button;

public class ButtonMimi extends Button implements ButtonInterfaceMimi {

	private Color original;
	
	public ButtonMimi(int x, int y, int w, int h, String text, Action action) {
		super(x, y, w, h, "", null);
	}

	@Override
	public void setColor(Color color) {
		this.setForeground(color);
		original = color;
		update();
	}

	@Override
	public void dim() {
		this.setForeground(original);
		update();
	}

	@Override
	public void highlight() {
//		this.setColor(original.brighter());
//		update();
		this.setColor(Color.gray);
		update();
	}
	
	public void drawButton(Graphics2D g, boolean hover) {
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		g.drawRoundRect(0, 0, getWidth()-1, getHeight()-1, curveX, curveY);
			g.setColor(getForeground());
			g.fillRoundRect(0, 0, getWidth()-1, getHeight()-1, curveX, curveY);

}

}