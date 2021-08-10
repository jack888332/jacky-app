package demo.collection;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class CollectionHandler {
	public static void main(String[] args) {
		handleSet();
		handleList();
	}
	
	private static void handleSet() {
		Set<String> colors = new HashSet<>();
		colors.add("Red");
		colors.add("Blue");		
		colors.add("Green");
		
		Iterator<String> i6r = colors.iterator();
		while(i6r.hasNext()) {
			String color = i6r.next();
			System.out.println(color);
		}	
	}
	
	private static void handleList() {
		List<String> musics = new LinkedList<>();
		musics.add("FutureBass");
		musics.add("FutureBounce"); 
		musics.add("FutureTrance");
		
		Iterator<String> i6r = musics.iterator();
	    while(i6r.hasNext()) {
	    	String music = i6r.next();
	    	System.out.println(music);
	    }
	}
}
