package simuchute.ch.i10a.chute.threads;

import java.awt.Point;
import simuchute.SimuchuteView;
import simuchute.ch.i10a.chute.logic.SimulationObject;

/**
 * Zweite Runnable Klasse für den Springer-Thread
 * @author Fish-Guts
 */
public class ChuteRunnableTwo implements Runnable {

    private SimuchuteView view;
    private SimulationObject sim;

    public ChuteRunnableTwo(SimuchuteView view, SimulationObject sim) {
        this.view = view;
        this.sim = sim;
    }

    /**
     * die Hauptmethode in diesem Thread
     */
    public void run() {
        Point jumperLocation = new Point();
        double coordinatePerDot = (double) 700 / (double) 5000;
        double yCoord = (700 - coordinatePerDot * sim.getAltitude());
        // Startkoordinaten von Flugzeug
        int i = 0;
        double result[][] = this.sim.getResult();
        this.view.currentPositionLabel.setVisible(true);
        this.view.currentPositionLabelX.setVisible(true);
        this.view.currentPositionLabelY.setVisible(true);
        this.view.currentPositionValueX.setVisible(true);
        this.view.currentPositionValueY.setVisible(true);
        do {
            try {
                Thread.sleep(100);
                jumperLocation.setLocation((result[i][0] / 10), 700 - coordinatePerDot * result[i][1]);
                moveJumper(jumperLocation);
                this.view.currentPositionValueX.setText(new Double(result[i][0] / 10).toString());
                this.view.currentPositionValueY.setText(new Double(700 - coordinatePerDot * result[i][1]).toString());
            } catch (Exception e) {
            }
            i++;
        } while (jumperLocation.getY() > 2);
        enableGui();
    }

    /**
     * moveJumper: Bewegt die Springergrafik auf dem GUI
     * @param location: Point Objekt, welches die Koordinaten beinhaltet, an welches
     * die Grafik verschoben werden soll. 
     */
    public void moveJumper(Point location) {
        this.view.jumper.setVisible(true);
        this.view.jumper.setLocation(location);

    }
    private void enableGui() {
        this.view.airDensityValue.setEnabled(true);
        this.view.airSpeedValue.setEnabled(true);
        this.view.altitudeValue.setEnabled(true);
        this.view.flightSpeedValue.setEnabled(true);
        this.view.timeToOpenValue.setEnabled(true);
        this.view.timeWhenToOpenValue.setEnabled(true);
        this.view.jumperAreaValue.setEnabled(true);
        this.view.parachuteAreaValue.setEnabled(true);
        this.view.landingPoint.setEnabled(true);
        this.view.jumperWeightValue.setEnabled(true);
    }
}
