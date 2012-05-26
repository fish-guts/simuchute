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

            Simulation simulation = new Simulation();

    }
    public Simulation(){

        
        SimulationObject simulationobject = new SimulationObject();
        simulationobject.setAltitude(10000);
        simulationobject.setParachuteArea(10);
        simulationobject.setPlaneSpeed(30);
        simulationobject.setWindSpeed(50);
        simulationobject.setSpringerGewicht(70);
        simulationobject.setSpringerFlaeche(1);
        simulationobject.setParachuteTimeToOpen(2);
        simulationobject.setLuftDichte(1.2);
        simulationobject.setTOeffnen(10);
        simulationobject.setLuftDichte(1.2);
        simulationobject.setSchrittweite(0.1);
        simulationobject.setTAnfang(0);
        simulationobject.setTEnde(50);

        // Flugzeug wird erstellt und Flugbahn berechnet. 
        //Flugzeug flugzeug = new Flugzeug();
        //simulationobject = flugzeug.calcFlugbahn(simulationobject);
        Springer springer = new Springer(simulationobject);
        springer.calcSpringer();
        simulationobject = springer.getFlugbahnSpringer();

        // Test Print, FlugzeugDaten?
        //Tools.printArray2D(simulationobject.getFlugbahn());
        
       

    }



}
