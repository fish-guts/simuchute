/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simuchute.ch.i10a.chute.logic;
import simuchute.ch.i10a.chute.tools.Tools;
/**
 *
 * @author Yzerman
 */

public class Simulation {

    public static void main(String[] args) {

            new Simulation();

    }
    public Simulation(){

        
        SimulationObject simulationobject = new SimulationObject();
        simulationobject.setAltitude(5000);
        simulationobject.setParachuteArea(10);
        simulationobject.setPlaneSpeed(30);
        simulationobject.setWindSpeed(50);
        simulationobject.setSpringerGewicht(70);
        simulationobject.setSpringerFlaecheStart(0.5);
        simulationobject.setSpringerFlaeche(simulationobject.getSpringerFlaecheStart());
        simulationobject.setParachuteTimeToOpen(2);
        simulationobject.setLuftDichte(1.2);
        simulationobject.setTOeffnen(2);
        simulationobject.setTOffen(20);
        simulationobject.setLuftDichte(1.2);
        simulationobject.setSchrittweite(0.1);
        simulationobject.setTAnfang(0);
        simulationobject.setTEnde(1000);
        simulationobject.setLandePunkt(4000);
        simulationobject.setSchrittweiteResult(0.1);
        simulationobject.setCwStart(0.5);
        

        // Flugzeug wird erstellt und Flugbahn berechnet. 
        //Flugzeug flugzeug = new Flugzeug();
        //simulationobject = flugzeug.calcFlugbahn(simulationobject);
        Springer springer = new Springer(simulationobject);
        springer.calcSpringer();
        simulationobject = springer.getFlugbahnSpringer();

        System.out.println(" Neuer Abspringpunkt : " + simulationobject.getResultAbsprungPunkt());
        System.out.println(" Maximale Geschwindigkeit : " + simulationobject.getMaxSpringerGeschwindigkeit());
        System.out.println(" Springer Gewicht : " + simulationobject.getSpringerGewicht());
        System.out.println(" Springer Fläche Start : " + simulationobject.getSpringerFlaecheStart());
        System.out.println(" Springer Fläche Ende (Berechnet): " + simulationobject.getSpringerFlaeche());
        System.out.println(" Springer Fläche Ende (Gesetzter Wert): " + simulationobject.getParachuteArea());
        System.out.println(" Springer Gewicht : " + simulationobject.getSpringerGewicht());
        System.out.println(" Fallschirm wird geöffnet bei : " + simulationobject.getTOffen());
        System.out.println(" Fallschirm öffnen dauert : " + simulationobject.getTOeffnen());
        System.out.println(" CW Start : " + simulationobject.getCwStart());
        System.out.println(" CW Ende : " + simulationobject.getCwEnde());
        
        // Test Print, FlugzeugDaten?
        //Tools.printArray2D(simulationobject.getFlugbahn());
        
       

    }



}
