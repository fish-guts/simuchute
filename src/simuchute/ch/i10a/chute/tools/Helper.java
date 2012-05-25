/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package simuchute.ch.i10a.chute.tools;

/**
 *
 * @author chsmrs
 */
public class Helper {

    public static boolean isInteger(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public static boolean isDouble(String input) {
        try {
            Double.parseDouble(input);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
