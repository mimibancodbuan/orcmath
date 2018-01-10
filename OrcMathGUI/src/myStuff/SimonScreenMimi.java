package myStuff;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import guiTeacher.components.Action;
import guiTeacher.components.TextArea;
import guiTeacher.components.TextLabel;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.ClickableScreen;

public class SimonScreenMimi extends ClickableScreen implements Runnable{

	public TextLabel label;
	public ButtonInterfaceMimi[] buttons;
	public ProgressInterfaceMimi progress;
	public ArrayList<MoveInterfaceMimi> sequence;
	private TextArea text;

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
		label.setText("");
	    nextRound();
	}

	private void nextRound() {
		acceptingInput=false;
		roundNumber++;
		sequence.add(randomMove());
		progress.setRound(roundNumber);
		progress.setSequenceSize(sequence.size());
		changeText("Simon's turn");
		label.setText("");
		playSequence();
		changeText("Your Turn");
		acceptingInput=true;
		sequenceIndex=0;
	}

	private void playSequence() {
		for(int i=0; i<sequence.size(); i++) {
			int sleepTime = Math.abs(1500-6*roundNumber);
			try        
			{
			    Thread.sleep(sleepTime);
			} 
			catch(InterruptedException ex) 
			{
			    Thread.currentThread().interrupt();
			}
		}
	}

	private void changeText(String string) {
		Thread blink = new Thread(new Runnable(){

			public void run(){
				label.setText(string);
				try {
					Thread.sleep(1000);
					} catch (InterruptedException e) {
					e.printStackTrace();
					}
			}

		});
		blink.start();
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
	 * Placeholder until partner finishes implementation of MoveInterface
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
		return new ProgressMimi(100, 300, 50, 50); 
	}

	private void addButtons() {
		int numberOfButtons = 4;
		buttons = new ButtonInterfaceMimi[numberOfButtons];
		Color[] colors = {Color.green, Color.red, Color.yellow, Color.blue};
		
		for(int i=0; i<numberOfButtons; i++) {
			final ButtonInterfaceMimi b = getAButton();
			buttons[i] = b;
			b.setColor(colors[i]); 
			b.setX((int) (80+50*Math.cos(i*(Math.PI/2))));
			b.setY((int) (80+50*Math.sin(i*(Math.PI/2))));
		    b.setAction(new Action() {
		    	
				public void act() {
					if(acceptingInput) {
						Thread blink = new Thread(new Runnable() {
							
							@Override
							public void run() {
								b.highlight();
								try {
									Thread.sleep(800);
									}
								catch (InterruptedException e) {
									e.printStackTrace();
									}
									b.dim();
							}
							
						});
						blink.start();
						if( b == sequence.get(sequenceIndex).getButton()) {
							sequenceIndex++;
						}
						else
							progress.gameOver();
					}
					if(sequenceIndex == sequence.size()){ 
					    Thread nextRound = new Thread(SimonScreenMimi.this); 
					    nextRound.start(); 
					}
				}
				
			});
		}
	}

	private ButtonInterfaceMimi getAButton() {
		return new ButtonMimi(80, 80, 50, 50, "", null);
	}

}