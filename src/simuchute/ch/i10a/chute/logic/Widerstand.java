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

                if(simulationObject.getRunTime() < simulationObject.getTOeffnen()){
                    calcWiderstand();
                }
                if(runTime > toeffnen && runTime < toffen){
                    calcDynWiderstand();
                }

	}
	
	public void init(){
		
	}

        public double calcWiderstand(){
             
            return widerstandResult = cw * 0.5 * geschwindigkeit * geschwindigkeit * luftDichte * springerFlaeche;

        }
	public double calcDynWiderstand(){

                double differenzFlaeche = simulationObject.getParachuteArea() - simulationObject.getSpringerFlaeche();

            
                
		
		return widerstandResult;
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
