package s15cscd580task2;

import java.util.Random;

public class RandomGen {

	private Random value;
	
	private static RandomGen instance = null;
	
	private RandomGen(){
		
		value  = new Random();
	}
	
	public static RandomGen getInstance() {
		
		if(instance == null)
			instance = new RandomGen();
		
		return instance;
	}
	
	public Random getRandom() {
		
		return value;
	}	
}
