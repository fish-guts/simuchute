/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package simuchute.ch.i10a.chute.threads;

import java.awt.Point;
import simuchute.SimuchuteView;
import simuchute.ch.i10a.chute.logic.SimulationObject;

/**
 *
 * @author Fish-Guts
 */
public class ChuteRunnable implements Runnable {

    private SimuchuteView view;
    private SimulationObject sim;

    public ChuteRunnable(SimuchuteView view, SimulationObject sim) {
        this.view = view;
        this.sim = sim;
    }

    public void run() {
        Point planeLocation = new Point();
        double coordinatePerDot = (double) 700 / (double) 5000;
        double yCoord = (700 - coordinatePerDot * sim.getAltitude());
        // Startkoordinaten von Flugzeug
        int i = 0;
        do {
            try {
                Thread.sleep(1);
                planeLocation.setLocation((i * this.sim.getPlaneSpeed()/1000),yCoord );
                movePlane(planeLocation);
            } catch (Exception e) {
            }
            i++;
        } while(planeLocation.getX()<1010);
    }

    public void movePlane(Point location) {
        this.view.plane.setLocation(location);
    }

    public void moveJumper() {
    }

    public Point getCurrentPlaneLocation() {
        return new Point();
    }
}
