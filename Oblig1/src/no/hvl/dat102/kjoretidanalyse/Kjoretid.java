package no.hvl.dat102.kjoretidanalyse;

public class Kjoretid {

	public static void tid(long n) {
		
		long starttid = System.currentTimeMillis();
		
		long k = 0;
		for (long i = 1; i <= n; i++) {
			k = k + 5;
		}
		
		long sluttid = System.currentTimeMillis();
		
		System.out.println("Tid brukt: " + (sluttid - starttid) + " ms");		
		

	}
	
	public static void main(String[] args) {
		
		for (int i = 1; i <= 100; i++) {
			tid((long) Math.pow(10, 7));
		}
		
	
		
	}

}
