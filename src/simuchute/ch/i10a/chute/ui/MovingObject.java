/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package simuchute.ch.i10a.chute.ui;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import simuchute.ch.i10a.chute.logic.Flugzeug;
import simuchute.ch.i10a.chute.logic.Springer;

/**
 *
 * @author Fish-Guts
 */
public class MovingObject {

    static double x_pos;
    static double y_pos;
    int radius = 2;

    public void paint(Graphics g) {

        // Setzten der Zeichenfarbe auf Rot
        g.setColor(Color.red);

        // Zeichen eines gefüllten Kreises
        g.fillOval((int)x_pos - radius, (int)y_pos - radius, 2 * radius, 2 * radius);

    }

     void init() {
        Thread th = new Thread();
        th.currentThread().setPriority(Thread.MIN_PRIORITY);
        run();
    }

    private static void run() {
        Flugzeug flugzeug;
        flugzeug = new Flugzeug();
        double[] startKO = {0, 0};
        flugzeug.setKO(startKO);
        flugzeug.setTime(5);
        flugzeug.setTStart(0);
        flugzeug.calcFlugbahn();
        double[][] flugbahn = flugzeug.getFlugbahn();
        //Tools.printArray(startKO);
        //Tools.printArray2D(flugbahn);

        Springer springer;
        springer = new Springer();
        double[] startWerte = {0, 1000, 0, 0};
        double[][] result;
        result = springer.fTable(0, 1, 100, 0, startWerte, 1);
    }
}
