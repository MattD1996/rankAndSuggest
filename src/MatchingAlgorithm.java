import java.util.ArrayList;
import java.util.NavigableMap;
import java.util.SortedMap;
import java.util.TreeMap;

public class MatchingAlgorithm {

	public MatchingAlgorithm(F_Tree user, ArrayList<String> variety, int totalFrequency) {
		int matchFrequency = 0;
		System.out.println("The keyset size is: " + user.getDescendingNavigableMap().keySet().size());
		System.out.println(user.getDescendingNavigableMap().keySet());
		Object[] keys = user.getDescendingNavigableMap().keySet().toArray();
		for (Integer i = 0; i < user.getDescendingNavigableMap().keySet().size(); i++) {
			System.out.println();
			System.out.println("ITERATION: " + i);
			NavigableMap<Integer, ArrayList<String>> kvPair = user.getDescendingNavigableMap().subMap(
					(Integer)keys[i], 
					true,
					(Integer)keys[i],
					true);
			System.out.println("now looking at: " + kvPair);
			for (ArrayList<String> list : kvPair.values()) {
				for (String name : list) {
					for (String thing : variety) {
						System.out.print("Comparing " + name + " and " + thing);
						if (name == thing) {
							System.out.println(" AND THEY MATCH");
							System.out.println("i = " + i);
							System.out.println(user.getDescendingNavigableMap().keySet().toArray().length);
							matchFrequency = matchFrequency
									+ (Integer) user.getDescendingNavigableMap().keySet().toArray()[i];
							System.out.println(user.getDescendingNavigableMap().keySet().toArray()[i]);
						} else {
							System.out.println(" AND THEY DON'T MATCH");
						}
						System.out.println("Match frequency at: " + matchFrequency * 100 / totalFrequency + "%");
						if (matchFrequency >= totalFrequency / 3) {
							System.out.println("We have a match");
							return;
						}
					}
				}
			}
		}
		System.out.println("No match found");
	}

	public static void main(String[] args) {

		System.out.print("Artist Data: ");
		F_Tree tmt = new F_Tree();
		tmt.add(20, "David Bowie");
		tmt.add(50, "Ziggy Stardust");
		tmt.add(2, "Adam Sandler");
		tmt.add(15, "Billie Joe Armstrong");
		tmt.add(10, "Bosley");
		tmt.add(60, "The Doors");
		tmt.printArrayList();

		System.out.print("User Data: ");
		F_Tree user = new F_Tree();
		user.add(2, "Madona");
		user.add(3, "Less than Jake");
		user.add(2, "Adam Sandler");
		user.add(15, "Billie Joe Armstrong");
		user.add(20, "One Direction");
		user.add(20, "The Doors");
		user.add(70, "Paramore");
		user.add(20, "My Chemical Romance");
		user.printArrayList();
		System.out.println("User total Frequency: " + user.getTotalFrequency());

		MatchingAlgorithm ma = new MatchingAlgorithm(user, tmt.getArrayList(), user.getTotalFrequency());
	}
}
