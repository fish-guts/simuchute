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
public class ChuteRunnableTwo implements Runnable {

    private SimuchuteView view;
    private SimulationObject sim;

    public ChuteRunnableTwo(SimuchuteView view, SimulationObject sim) {
        this.view = view;
        this.sim = sim;
    }

    public void run() {
        Point jumperLocation = new Point();
        double coordinatePerDot = (double) 700 / (double) 5000;
        double yCoord = (700 - coordinatePerDot * sim.getAltitude());
        // Startkoordinaten von Flugzeug
        int i = 0;
        double result[][] = this.sim.getResult();
        do {
            try {
                Thread.sleep(20);
                jumperLocation.setLocation((result[i][0] / 10), 700 - coordinatePerDot * result[i][1]);
                moveJumper(jumperLocation);
                this.view.currentPositionValueX.setText(new Double(result[i][0]/10).toString());
                this.view.currentPositionValueY.setText(new Double(700 - coordinatePerDot * result[i][1]).toString());
            } catch (Exception e) {
            }
            i++;
        } while (jumperLocation.getY() > 2);
    }
    public void moveJumper(Point location) {
        this.view.jumper.setVisible(true);
        this.view.jumper.setLocation(location);

    }


    public Point getCurrentPlaneLocation() {
        return new Point();
    }
}
