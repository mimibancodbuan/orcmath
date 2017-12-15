package mimiPackage;

import java.util.ArrayList;
import java.util.Collections;

public class CatalogMaker {
	
	private ArrayList <PVZ> plantList;
	
	public CatalogMaker() {
		
		plantList = new ArrayList<PVZ>();
		plantList.add("sunflower", 50);
		plantList.add(PVZ);
		plantList.add(PVZ);
		Collections.sort(plantList);
	}

	public static void main(String[] args) {
		CatalogMaker maker = new CatalogMaker();
		System.out.println(maker.getCSVContent());
	}
	
	public String getCSVContent() {
		String data = "";
		for(PVZ p: plantList) {
			data += data + p + "\n";
		}
		return data;
	}

}
