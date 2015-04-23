package s15cscd580task1;

public class BinomialCoefficient {
	
	int n;
	int nFact;
	int[] biCoAra; 
	
	public BinomialCoefficient(int n) {
		
		this.n = n;
		nFact = factorial(n);
		biCoAra = new int[n];
		fillArray();
	}
	
	private int factorial(int n) {
	    int result = 1;
	    for (int i = 1; i <= n; i++) {
	        result = result * i;
	    }
	    return result;
	}
	
	public int biCo(int i) { //binomial coefficient
		
		return nFact / (factorial(i) * factorial((n - i)));
	}
	
	private void fillArray() {
		
		for(int i = 0; i < biCoAra.length; i++) {
			
			biCoAra[i] = biCo(i);
		}
	}
	
	public int[] getArray() {
		
		return biCoAra;
	}
}
