package demo.collection;

import java.util.*;

public class CollectionHandler {
	public static void main(String[] args) {
		handleSet();
		handleList();
	}
	
	private static void handleSet() {
		HashSet<String> colors = new HashSet<>();
		colors.add("Set-Red");
		colors.add("Set-Blue");		
		colors.add("Set-Green");
		
		Iterator<String> i6r = colors.iterator();
		while(i6r.hasNext()) {
			String color = i6r.next();
			System.out.println(color);
		}	
	}
	
	private static void handleList() {
		LinkedList<String> musics = new LinkedList<>();
		musics.add("FutureBass");
		musics.add("FutureBounce"); 
		musics.add("FutureTrance");
		
		Iterator<String> i6r = musics.iterator();
	    while(i6r.hasNext()) {
	    	String music = i6r.next();
	    	System.out.println(music);
	    }
	}
	
	private static void handleHashMap() {
		LinkedHashMap<String, String> colors = new LinkedHashMap<>();
		colors.put("1", "Map-Red");
		colors.put("2", "Map-Blue");
		colors.put("3", "Map-Green");

		for(Map.Entry<String, String> color: colors.entrySet()) {
			
		}
	}
}
