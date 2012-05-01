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
import javax.swing.*;
import java.awt.event.MouseEvent;
import javax.swing.event.MouseInputListener;
import simuchute.ch.i10a.chute.logic.Flugzeug;

public class ShowCoordinates {

    private JLabel label;
    private static JLabel currentPosition;
    private Point point1, point2;
    static double pos[][];

    private void build(Container cont) {
        cont.setLayout(new BoxLayout(cont, BoxLayout.LINE_AXIS));
        CoordinateExample coordinate = new CoordinateExample(this);
        cont.add(coordinate);

        label = new JLabel();
        resetLabel();
        cont.add(label);
        coordinate.setAlignmentX(Component.RIGHT_ALIGNMENT);
        label.setAlignmentX(Component.RIGHT_ALIGNMENT);
    }

    public void update(int x, int y) {
        if (x < 0 || y < 0) {
            point2 = null;
            // updateLabel();
            return;
        }
        if (point2 == null) {
            point2 = new Point();
        }
        point2.x = x;
        point2.y = y;
        updateLabel();
    }

    public void updatePoint1(Point pt) {
        point1 = pt;
        //updateLabel();
    }

    public void resetLabel() {
        point2 = null;
        //updateLabel();
    }

    protected void updateLabel() {
        String msg = "";
        if (point2 != null) {
            msg += "Momentane Position:  (" + point2.x + ", "
                    + point2.y + "). ";
        }
        currentPosition.setText(msg);
    }

    static void create(JFrame f) {
        ShowCoordinates showCoo = new ShowCoordinates();
        showCoo.build(f.getContentPane());
        f.pack();
        showCoo.calcPlane();

    }

    private void calcPlane() {
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
        for(int i = 0;i<flugbahn.length;i++) {
            
        }
    }

    public static class CoordinateExample extends JComponent implements
            MouseInputListener {

        Point point = null;
        ShowCoordinates showCoo;
        Dimension dim = new Dimension(1600, 968);
        Color color;

        public CoordinateExample(ShowCoordinates showCoo) {
            this.showCoo = showCoo;
            addMouseListener(this);
            addMouseMotionListener(this);
            setBackground(Color.WHITE);
            setOpaque(true);
        }

        public Dimension getPreferredSize() {
            return dim;
        }

        protected void paintComponent(Graphics g) {
            g.setColor(getBackground());
            g.fillRect(0, 0, getWidth(), getHeight());
            g.setColor(Color.GRAY);
            drawGrid(g, 9);
            if (point != null) {
                g.setColor(getForeground());
                g.fillRect(point.x - 4, point.y - 4, 8, 8);
            }
        }

        private void drawGrid(Graphics g, int grid) {
            Insets insets = getInsets();
            int X1 = insets.left;
            int Y1 = insets.top;
            int X2 = getWidth() - insets.right;
            int Y2 = getHeight() - insets.bottom;
            int x = X1;
            while (x < X2) {
                g.drawLine(x, Y1, x, Y2);
                x += grid;
            }
            int y = Y1;
            while (y < Y2) {
                g.drawLine(X1, y, X2, y);
                y += grid;
            }
        }

        public void mouseClicked(MouseEvent event) {
            int x = event.getX();
            int y = event.getY();
            if (point == null) {
                point = new Point(x, y);
            } else {
                point.x = x;
                point.y = y;
            }
            showCoo.updatePoint1(point);
            repaint();
        }

        public void mouseMoved(MouseEvent event) {
        }

        public void mouseExited(MouseEvent event) {
            showCoo.resetLabel();
        }

        public void mouseReleased(MouseEvent event) {
        }

        public void mouseEntered(MouseEvent event) {
        }

        public void mousePressed(MouseEvent event) {
        }

        public void mouseDragged(MouseEvent event) {
        }
    }
}
