/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simuchute.ch.i10a.chute.logic;

/**
 *
 * @author Yzerman
 */

public class Simulation {

    public static void main(String[] args) {

            Simulation simulation = new Simulation();
            
        

    }
    public Simulation(){

        System.out.print("TEST");
        SimulationObject simulationobject = new SimulationObject();
        simulationobject.setAltitude(10000);
        simulationobject.setParachuteArea(10);
        simulationobject.setPlaneSpeed(50);
        simulationobject.setWindSpeed(50);
        simulationobject.setSpringerGewicht(70);
        simulationobject.setParachuteTimeToOpen(2);
        simulationobject.setLuftDichte(1.2);

        Widerstand widerstand = new Widerstand(simulationobject.getRunTime(), simulationobject.getSpringerGeschwindigkeit()
                , simulationobject.getLuftDichte(), simulationobject.getParachuteArea(), simulationobject.getSpringerFlaeche);
        


    }



}
