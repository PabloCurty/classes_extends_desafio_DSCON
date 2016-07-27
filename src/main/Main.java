package main;

import classe.Pj;

public class Main {
	
	public static void main(String[] args) {
		
		
		Pj pj = new Pj("Pablo Curty", "Av presidente", 4000.00, 11 , 45.00 , 160.00 );
		Pj pjj = new Pj("Rodrigo Nunes", "Av sete", 3800.00, 11 , 45.00 , 120.00 );
		
		pj.imprimeFP();
	}

}
