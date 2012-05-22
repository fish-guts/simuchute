package simuchute.ch.i10a.chute.logic;

public class Widerstand {

	double toffen;
	double toeffnen;
	double t;
	double widerstand;
        double runTime;
        double luftDichte;
        double springerFlaeche;
        double fallSchirmFlaeche;
        double geschwindigkeit;
        double widerstandResult;
        double cw =1;
	SimulationObject simulationObject;

	public Widerstand(SimulationObject simulationObject){

		init();

	}
	
	public void init(){
		
	}

        public double calcWiderstand(){

                 if(simulationObject.getRunTime() < simulationObject.getTOeffnen()){
                    return widerstandResult = cw * 0.5 * geschwindigkeit *
                    geschwindigkeit * luftDichte * springerFlaeche;
                }
                if(simulationObject.getRunTime() > simulationObject.getTOeffnen() 
                         && simulationObject.getRunTime() < simulationObject.getTOffen()){
                    int n = (int) (Math.round( (Math.abs (simulationObject.getTEnde()-simulationObject.getTAnfang()) / simulationObject.getSchrittweiteH())));
                    calcDynWiderstand();
                }
             
            

        }
	public double calcDiffFlaeche(){

                double differenzFlaeche = simulationObject.getParachuteArea() - simulationObject.getSpringerFlaeche();

		return differenzFlaeche;
	}
    
    public void Settoffen(double toffen){
    	this.toffen = toffen;
    }
    
    public double getToffen(){
    	return toffen;
    }
    
    public void Settoeffnen(double toeffnen){
    	this.toeffnen = toeffnen;
    }
    
    public double getToeffnen(){
    	return toeffnen;
    }
    
    public void startWiderstand(double widerstand){
    	this.widerstand = widerstand;
    }
    
    public double startWiderstand(){
    	return widerstand;
    }
}
