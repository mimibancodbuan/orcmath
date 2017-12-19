package mimiPackage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class CatalogMaker {
	
	private ArrayList <PVZ> plantList;
	
	public CatalogMaker() {
		
		plantList = new ArrayList<PVZ>();
		plantList.add(new PVZ("sunflower", 50));
		plantList.add(new PVZ("pea shooter", 50));
		plantList.add(new PVZ("potato mine", 100));
	}

	public static void main(String[] args) {
		CatalogMaker maker = new CatalogMaker();
		maker.getUserInput();
		System.out.println(maker.getCSVContent());
		
		maker.getUserInput();
		
	}
	
	public String getCSVContent() {
		String data = "";
		for(PVZ p: plantList) {
			data += p + "\n";
		}
		return data;
	}
	
	public void getUserInput() {
		Scanner in = new Scanner(System.in);
		
		System.out.println("Please enter a new plant to the list");
		String s = in.nextLine();
		
		System.out.println("Please enter a price for the plant");
		String a = in.nextLine();
		
		plantList.add(new PVZ(s, Integer.parseInt(a)));
	}

}
