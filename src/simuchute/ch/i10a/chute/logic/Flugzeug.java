package simuchute.ch.i10a.chute.logic;

public class Flugzeug {
	
	private double geschwindigkeit;
	private double[] KO;
	private double tstart;
	private double t;
	private double xKO;
	private double yKO;
	private double[][] flugbahn;
	
	public Flugzeug(){
		
		init();
		
	}
	
	public void init(){
		geschwindigkeit = 40;
		tstart = 0;
		t = 0;
	}
	
	public void setKO(double[] ko){
		KO = new double[2];
		KO[0] = ko[0];
		KO[1] = ko[1];
		xKO = KO[0];
		yKO = KO[1];
		
	}
	
	public double[] getKO(){
		
		KO[0] = xKO;
		KO[1] = yKO;
		return KO;
	}

	
	public void setTime(double t){
		
		this.t = t;
	}
	
	public void setTStart(double tStart){
		tstart = tStart;
		
	}
	
	public void calcFlugbahn(){
		
		double counter = tstart;
		double yKO = 0;
		flugbahn = new double[(int) t][2];
		
		
		while(counter < t){
			xKO = geschwindigkeit*counter;
			flugbahn[(int) counter][0] = xKO;
			flugbahn[(int) counter][1] = yKO;
			counter++;
			
		}
		
	}
	
	public double[][] getFlugbahn(){
		
		return flugbahn;
	}
	
}
