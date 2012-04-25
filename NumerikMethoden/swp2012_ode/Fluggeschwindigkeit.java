package swp2012_ode;

public class Fluggeschwindigkeit {

	/**
	 * @param args
	 */
	
	static double geschwindigkeit=40;
	static double[] Koordinaten = {0,0};
	static double tstart =0;
	static double t=0;
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double xKO = Koordinaten[0];
		double yKO = Koordinaten[1];
		
		while(t<20){
			xKO=RBewegung(xKO, t);
			t++;
			print(xKO, yKO);
		}
		

	}
	
	public static void print(double xKO, double yKO){

		System.out.println("Die Geschwindigkeit auf der Koordinate " + xKO + ", " + yKO + " beträgt " +geschwindigkeit);
	}
	
	public static double RBewegung(double xKO, double t){
		
		return xKO = geschwindigkeit*t;
		
	}

}
