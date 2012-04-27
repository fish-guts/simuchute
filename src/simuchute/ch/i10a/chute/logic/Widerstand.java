package simuchute.ch.i10a.chute.logic;

public class Widerstand {

	double toffen;
	double toeffnen;
	double t;
	double widerstand;
	
	public Widerstand(){
		
		init();
	}
	
	public void init(){
		
	}
	
	public double calcWiderstand(double t){
		
		
		if(t>=toeffnen && t<=toffen){
			widerstand = widerstand + 0.0001;
		}
		System.out.println(widerstand);
		return widerstand;
		
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
