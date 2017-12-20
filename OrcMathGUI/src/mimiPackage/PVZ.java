package mimiPackage;

import java.awt.Color;
import java.awt.Graphics2D;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import guiTeacher.components.AnimatedComponent;
import guiTeacher.components.Component;

public class PVZ extends AnimatedComponent {

	private String plantname;
	private int price;
	private String zombietype;

	public PVZ(String plantname, int price) {
		super(40, 40, 125, 140);
		this.plantname = plantname;
		this.price = price;

		addSequence("resources/MimiSpriteSheet.png", 100, 0, 0, 125, 140, 6);
		Thread animation = new Thread(this);
		animation.start();
		update();
	}

	public static void main(String args[]) {

		Scanner in = new Scanner(System.in);

		System.out.println("Please enter input.");
		String s = in.nextLine();

		testSaveContent(s);
	}

	@Override
	public void update(Graphics2D g) {
		g.setColor(Color.black);
		super.update(g);
	}

	public String toString() {
		return plantname + ", $" + price;
	}

	public static void testSaveContent(String fileContent) {

		try{    

			FileWriter fw=new FileWriter("file.txt");    

			fw.write(fileContent);    

			fw.close();    

			System.out.println("Success! File \""+"text"+"\" saved!");

		}catch(IOException e){

			System.out.println("An IOException was thrown. \nCheck to see that the directory where you tried to save the file actually exists.");

		}



	}

}
