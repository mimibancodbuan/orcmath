package myStuff;

import java.util.ArrayList;
import java.util.List;

import guiTeacher.components.TextLabel;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.ClickableScreen;

public class SimonScreenMimi extends ClickableScreen implements Runnable{

	public TextLabel label;
	public ButtonInterfaceMimi[] buttons;
	public ProgressInterfaceMimi progress;
	public ArrayList<MoveInterfaceMimi> sequence;

	public int roundNumber;
	public boolean acceptingInput;
	public int sequenceIndex;
	public int lastSelectedButton;

	public SimonScreenMimi(int width, int height) {
		super(width, height);
		Thread app = new Thread(this);
		app.start();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		addButtons();
		for(ButtonInterfaceMimi b: buttons){ 
			viewObjects.add(b); 
		}
		progress = getProgress();
		label = new TextLabel(130,230,300,40,"Let's play Simon!");
		sequence = new ArrayList<MoveInterfaceMimi>();
		//add 2 moves to start
		lastSelectedButton = -1;
		sequence.add(randomMove());
		sequence.add(randomMove());
		roundNumber = 0;
		viewObjects.add(progress);
		viewObjects.add(label);
	}

	private MoveInterfaceMimi randomMove() {
		int bIndex = (int)(Math.random()*buttons.length);
		while(bIndex == lastSelectedButton) {
			bIndex = (int)(Math.random()*buttons.length);
		}
		return getMove(bIndex);
	}

	/**
	 * Placeholder until partnew finishes implementation of MoveInterface
	 * @param bIndex
	 * @return
	 */
	private MoveInterfaceMimi getMove(int bIndex) {
		return null;
	}

	/**
	 * Placeholder until partner finishes implementation of ProgressInterface
	 * @return
	 */
	private ProgressInterfaceMimi getProgress() {
		return null;
	}

	private void addButtons() {
		int numberOfButtons = 4;
		ButtonInterfaceMimi[] buttons = new ButtonInterfaceMimi[];
	}

}
