/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simuchute.ch.i10a.chute.logic;

/**
 *
 * @author chsmrs
 */
public class MovablePlane extends MovableObject {

    private Flugzeug plane;
    private double[][] position;
    private int index = 0;
    public MovablePlane(Flugzeug pl) {
        plane = pl;
        position = pl.getFlugbahn();
    }

    @Override
    public void doUpdate() {
        if(index >= position.length) {
            return;
        }
        double[] coord = position[index++];
        double x = coord[0], y = coord[1];


    }
    public void reset() {
        index = 0;
    }
}
