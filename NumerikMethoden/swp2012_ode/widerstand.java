package swp2012_ode;

public class widerstand {

	/**
	 * @param args
	 */
	
	static int r=100;
	int t=0;
	final static int toeffnen =10;
	final static int toffen=20;
	int tstart=0;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int r=100;
		int t=0;
		final int toeffnen =10;
		final int toffen=20;
		int tstart=0;
		
		while(t<toffen){
			r=widerstand(t);
			t++;
			
		}

	}
	
	//Widerstandfunktion. R wird in einem gewissen Zeitraum jeden Schritt erhöht.
	public static int widerstand(int t){
		
		if(t>=toeffnen && t<=toffen){
			r = r + 10;
		}
		System.out.println(r);
		return r;
		
	}

}
