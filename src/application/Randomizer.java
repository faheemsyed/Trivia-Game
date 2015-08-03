package application;

import java.util.*;

/**
 * Useful utility class around Random Number Generation ... uses the Math.random() 
 * common library Class/method. 
 */
public class Randomizer {
	
	/**
     * Return a random integer between low & high 
     */
    public int generateInt(int low, int high) {
        return ( (int) ( (Math.random() * 1000000000 )  % (high - low) )  + low );
    }
    public int generateInt(double low, double high) {
        return generateInt((int) low, (int) high);
    }
	
    /*
     * return some random decimal number
     */
    public double generateDecimal() {
        return Math.random() * 1000000000; 
    }
    
    public int generateInt() {
        return ( (int) generateDecimal() );
    }
	

	public Randomizer() {
		init(); 
	}
	
	private void init() {
		// stubbed out for future use - to initialize the state of a Randomizer Instance 
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		// new instance of Randomizer 
		Randomizer randomizer = new Randomizer(); 
		
		// Test some of the key methods provided 
		System.out.println(randomizer.generateDecimal());
		System.out.println(randomizer.generateInt());
		
		
		int from = 11;
		int to = 20; 
		Integer number = randomizer.generateInt(from, to); 
		System.out.printf("Number between %d and %d:  %d\n", from, to, number); 
		
		int intCount = 10; 

		int [] integers = new int[intCount]; 
		
		for(int i = 0 ; i < intCount ; ++i) {
			integers[i] = randomizer.generateInt(1, 1000);
		}
		
		Arrays.sort(integers);
		
		for(int i = 0 ; i < intCount ; ++i) {
			System.out.printf("[%d] = %d\n",  i,  integers[i] );
		}

	}

}

