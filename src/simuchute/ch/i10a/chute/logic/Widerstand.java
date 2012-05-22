package simuchute.ch.i10a.chute.logic;

public class Widerstand {

	double toffen;
	double toeffnen;
	double t;
	double widerstand;
        double runTime;
        double springerFlaeche;
        double fallSchirmFlaeche;
        double geschwindigkeit;
        double widerstandResult;
        double cw=0.0001;
	SimulationObject simulationObject;
        int widerstandSchrittweite;
        int widerstandSchrittweiteCounter;

	public Widerstand(SimulationObject simulationObject){

		init();
                this.simulationObject = simulationObject;
                this.springerFlaeche = simulationObject.getSpringerFlaeche();
                

	}
	
	public void init(){
		
	}

        public double calcWiderstand(){
                 System.out.println(" Runtime " + simulationObject.getRunTime() +
                         "  TOeffnen " + simulationObject.getTOeffnen());

                 System.out.println(" Geschwindigkeit " + simulationObject.getSpringerGeschwindigkeit());
                 System.out.println(" springerFlaeche " + springerFlaeche);
                 System.out.println(" Luftdichte "+ simulationObject.getLuftDichte());
                 System.out.println(" cw: " + cw);
                 if(simulationObject.getRunTime() < simulationObject.getTOeffnen()){

                    System.out.println(" Runtime < Toeffnen ");
                    widerstandResult = cw * 0.5 * simulationObject.getSpringerGeschwindigkeit() *
                    simulationObject.getSpringerGeschwindigkeit() * simulationObject.getLuftDichte() * springerFlaeche;

                    System.out.println("Widerstand Runtime < TOeffnen: " + widerstandResult);
                    
                    return widerstandResult;

                }

                if(simulationObject.getRunTime() >= simulationObject.getTOeffnen()){


                        if(simulationObject.getTOffen() < simulationObject.getRunTime()){

                            System.out.println(" Runtime ist grösser als Toeffnen ");
                             springerFlaeche = springerFlaeche + calcFlaechenSchritt();

                            System.out.println("Widerstand Runtime > TOeffnen: " + widerstandResult);
                            return widerstandResult = cw * 0.5 * simulationObject.getSpringerGeschwindigkeit() *
                            simulationObject.getSpringerGeschwindigkeit() * simulationObject.getLuftDichte() * springerFlaeche;

                         }
                        else{
                            System.out.println("Runtime ist grösser als toffen");

                            System.out.println("Widerstand Runtime > TOffnen: " + widerstandResult);
                            return widerstandResult = cw * 0.5 * geschwindigkeit *
                            geschwindigkeit * simulationObject.getLuftDichte() * springerFlaeche;

                        }
            }
          System.out.print("Fehler bei Widerstand");
          System.out.println(" Widerstand " + widerstandResult);
          return 0;

             
        }

        public int setWiderstandSchrittweiteCounter(){
            return widerstandSchrittweiteCounter;
        }
        public void getWiderstandSchrittweiteCounter(int WiderstandSchrittweiteCounter){
            this.widerstandSchrittweiteCounter = WiderstandSchrittweiteCounter;
        }

        public double calcFlaechenSchritt(){
            return calcDiffFlaeche()/setWiderstandSchrittweite();
        }
        public int setWiderstandSchrittweite(){

                int n = (int) (Math.round( (Math.abs (simulationObject.getTEnde()-simulationObject.getTAnfang()) / simulationObject.getSchrittweiteH())));
                int widerstandSchrittweite = (int)calcDiffFlaeche();
                return widerstandSchrittweite;
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
