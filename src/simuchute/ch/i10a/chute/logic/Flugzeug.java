package simuchute.ch.i10a.chute.logic;

public class Flugzeug {
	
	
	private double[] KO;
	private double xKO;
	private double yKO;
	private double[][] flugbahn;
	private double tEnde;
        private double counter;


	public Flugzeug(){
		
		init();
		
	}
	
	public void init(){
           
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

	
	public SimulationObject calcFlugbahn(SimulationObject simulationObject){

                
		counter = simulationObject.getTAnfang();
                tEnde = simulationObject.getTEnde();
		flugbahn = new double[(int) tEnde][2];
		while(counter < tEnde){
			xKO = simulationObject.getPlaneSpeed()*counter;
			flugbahn[(int) counter][0] = xKO;
			flugbahn[(int) counter][1] = yKO;
			counter++;
			
		}
                simulationObject.setFlugbahn(flugbahn);
		return simulationObject;
	}

}
