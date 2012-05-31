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
        boolean go4Jump = false;
        boolean jumpFinished = false;
        Point planeLocation = new Point();
        Point jumperLocation = new Point();
        double coordinatePerDot = (double) 700 / (double) 5000;
        double yCoord = (700 - coordinatePerDot * sim.getAltitude());
        double result[][] = this.sim.getResult();
        // Startkoordinaten von Flugzeug
        int i = 0;
        int j = 0;
        do {
            try {
                Thread.sleep(1);
                planeLocation.setLocation((i * this.sim.getPlaneSpeed() / 1000), yCoord);
                if ((planeLocation.getX() > sim.getResultAbsprungPunkt() / 10) && (go4Jump == false)) {
                    go4Jump = true;
                    initNewThread();
            }
                movePlane(planeLocation);
            } catch (Exception e) {
            }
            i++;
        } while (jumpFinished==false);
    }

    public void movePlane(Point location) {
        this.view.plane.setLocation(location);
    }
    public void moveJumper(Point location) {
        this.view.jumper.setLocation(location);
    }
    public void initNewThread() {
        Thread jumperThread = new Thread(new ChuteRunnableTwo(this.view, this.sim));
        jumperThread.start();
    }

    public Point getCurrentPlaneLocation() {
        return new Point();
    }
}
