import java.util.ArrayList;
import java.util.NavigableMap;
import java.util.TreeMap;

import javafx.util.Pair;

public class F_Tree {
	private TreeMap<Integer, ArrayList<String> > tm;
	
	public F_Tree(){
		tm = new TreeMap<Integer, ArrayList<String> >();
	}
	
	public void add(Integer frequency, String name){
		if (tm.containsKey(frequency)) {
			tm.get(frequency).add(name);
		}
		else{
			ArrayList<String> newArrayList = new ArrayList<String>();
		    newArrayList.add(name);
			tm.put(frequency, newArrayList);
		}
	}
	
	public void remove(Integer frequency, String name){
		if(tm.containsKey(frequency)){
			if(tm.get(frequency).contains(name)){
				tm.get(frequency).remove(name);
			}
		}
	}
	
	public NavigableMap<Integer, ArrayList<String> > getDescendingNavigableMap(){
		return tm.descendingMap();
	}
	public ArrayList<String> getArrayList(){
		ArrayList<String> sortedValues = new ArrayList<String>();
		NavigableMap<Integer, ArrayList<String> > nm = getDescendingNavigableMap();
		for(ArrayList<String> list : nm.values()){
			for(String val : list){
				sortedValues.add(val);
			}
		}
		return sortedValues;
	}
	
	public int getTotalFrequency(){
		int tFrequency = 0;
		NavigableMap<Integer, ArrayList<String> > nm = getDescendingNavigableMap();
		for(Integer val : nm.keySet()){
			tFrequency += val;
		}
		return tFrequency;
	}
	
	public void printArrayList(){
		System.out.println(getArrayList());
	}
	
	public static void main(String[] args) {
		F_Tree tmt = new F_Tree();
		tmt.add(20, "David Bowie");
		tmt.add(50, "Ziggy Stardust");
		tmt.add(2, "Adam Sandler");
		tmt.add(10, "Billie Joe Armstrong");
		tmt.add(10, "Bosley");
		tmt.add(60, "The Doors");
		tmt.printArrayList();
		System.out.println("Frequency: " + tmt.getTotalFrequency());
	}
}
