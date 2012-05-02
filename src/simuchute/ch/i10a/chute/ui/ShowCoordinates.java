/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package simuchute.ch.i10a.chute.ui;

/**
 *
 * @author Fish-Guts
 */
import java.awt.*;
import java.awt.geom.Line2D;
import javax.swing.*;

public class ShowCoordinates extends JFrame {

    public void paintComponent(Graphics g) {

// fill with the color you want
        int wide = getWidth();
        int tall = getHeight();
        g.setColor(Color.white);
        g.fillRect(0, 0, wide, tall);

// go into Graphics2D for all the fine art, more options
// optional, here I just get variable Stroke sizes
        Graphics2D g2 = (Graphics2D) g;
        int w = wide / 10;
        int h = tall / 10;
        g2.setColor(Color.cyan);

        g2.setStroke(new BasicStroke(1));
// the verticles
        for (int i = 1; i < 10; i++) {
            g2.drawLine(i * w, 0, i * w, tall);
        }
// the horizontals
        for (int i = 1; i < 10; i++) {
            g2.drawLine(0, i * h, wide, i * h);
        }

// that will have a little glitch with the integer math
// the grid will have the bottom row slightly larger
// to overcome that, you must use double

        g2.setColor(Color.red);
        double rowH = getHeight() / 10.0;
        for (int i = 1; i < 10; i++) {
            Line2D line = new Line2D.Double(0.0, (double) i * rowH,
                    (double) getWidth(), (double) i * rowH);
            g2.draw(line);
        }

    }
}
