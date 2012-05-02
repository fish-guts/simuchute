/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simuchute.ch.i10a.chute.logic;

import javax.swing.JComponent;

/**
 *
 * @author chsmrs
 */
public abstract class MovableObject extends JComponent {

    public abstract void doUpdate();

    public abstract void reset();

}
