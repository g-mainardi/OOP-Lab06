package it.unibo.oop.lab.collections1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Example class using {@link java.util.List} and {@link java.util.Map}.
 * 
 */
public final class UseCollection {


	private static final int START_NUMBER = 1_000;
    private static final int FINISH_NUMBER = 2_000;
	
	private static final int ELEMENTS = 100_000;
	private static final int TO_MS = 1_000_000;

	private static final int READINGS = 1_000;
	
	private UseCollection() {
    }

    /**
     * @param s
     *            unused
     */
    public static void main(final String... s) {
        /*
         * 1) Create a new ArrayList<Integer>, and populate it with the numbers
         * from 1000 (included) to 2000 (excluded).
         */

    	List<Integer> numberList1 = new ArrayList<>();
    	for (int i = START_NUMBER; i < FINISH_NUMBER; i++) {
    		numberList1.add(i);
    	}
    	
        /*
         * 2) Create a new LinkedList<Integer> and, in a single line of code
         * without using any looping construct (for, while), populate it with
         * the same contents of the list of point 1.
         */
    	
    	List<Integer> numberList2 = new LinkedList<>(numberList1);
        /*
         * 
         * 3) Using "set" and "get" and "size" methods, swap the first and last
         * element of the first list. You can not use any "magic number".
         * (Suggestion: use a temporary variable)
         */
    	
    	int temp = numberList1.get(0);
    	numberList1.set(0, numberList1.get(numberList1.size() - 1));
    	numberList1.set(numberList1.size() - 1, temp);
    	
        /*
         * 4) Using a single for-each, print the contents of the arraylist.
         */
    	
    	for (final int number : numberList1) {
    		System.out.println(number);
    	}
    	
        /*
         * 5) Measure the performance of inserting new elements in the head of
         * the collection: measure the time required to add 100.000 elements as
         * first element of the collection for both ArrayList and LinkedList,
         * using the previous lists. In order to measure times, use as example
         * TestPerformance.java.
         */
    	

    	long timeArrayList = System.nanoTime();
    	
    	for (int i = 0; i < ELEMENTS; i++) {
			numberList1.add(0, i);
		}   
    	
    	timeArrayList = System.nanoTime() - timeArrayList;
    	
    	long timeLinkedList = System.nanoTime();
    	
    	for (int i = 0; i < ELEMENTS; i++) {
			numberList2.add(0, i);
		}   
    	
    	timeLinkedList = System.nanoTime() - timeLinkedList;
    	
    	System.out.println("Inserting " + ELEMENTS + " in an ArrayList took " + timeArrayList
    			+ "ns (" + timeArrayList / TO_MS + "ms)");
    	
    	System.out.println("Inserting " + ELEMENTS + " in an LinkedList took " + timeArrayList
    			+ "ns (" + timeArrayList / TO_MS + "ms)");
    	
        /*
         * 6) Measure the performance of reading 1000 times an element whose
         * position is in the middle of the collection for both ArrayList and
         * LinkedList, using the collections of point 5. In order to measure
         * times, use as example TestPerformance.java.
         */
    	
    	timeArrayList = System.nanoTime();
    	
    	for (int i = 0; i < READINGS; i++) {
			numberList1.get(numberList1.size() / 2);
		}   
    	
    	timeArrayList = System.nanoTime() - timeArrayList;
    	
    	timeLinkedList = System.nanoTime();
    	
    	for (int i = 0; i < READINGS; i++) {
			numberList2.get(numberList2.size() / 2);
		}   
    	
    	timeLinkedList = System.nanoTime() - timeLinkedList;
    	
    	System.out.println("Reading " + READINGS + " times in an ArrayList took " + timeArrayList
    			+ "ns (" + timeArrayList / TO_MS + "ms)");
    	
    	System.out.println("Reading " + READINGS + " times in an LinkedList took " + timeArrayList
    			+ "ns (" + timeArrayList / TO_MS + "ms)");
    	
    	
        /*
         * 7) Build a new Map that associates to each continent's name its
         * population:
         * 
         * Africa -> 1,110,635,000
         * 
         * Americas -> 972,005,000
         * 
         * Antarctica -> 0
         * 
         * Asia -> 4,298,723,000
         * 
         * Europe -> 742,452,000
         * 
         * Oceania -> 38,304,000
         */
    	
    	Map<String, Long> globalPopulation = new HashMap<>();
    	
        globalPopulation.put("Africa", 1_110_635_000L);
        globalPopulation.put("Americas", 1_110_635_000L);
        globalPopulation.put("Antarctica", 0L);
        globalPopulation.put("Asia", 4_298_723_000L);
        globalPopulation.put("Europe", 742_452_000L);
        globalPopulation.put("Oceania", 38_304_000L);
    	
    	/*
         * 8) Compute the population of the world
         */

        long nGlobalPopulation = 0L;
        for (final Long continent : globalPopulation.values()) {
        	nGlobalPopulation += continent.longValue();
        }
        
        System.out.println("Population of the world = " + nGlobalPopulation);
        
        
    }
}
