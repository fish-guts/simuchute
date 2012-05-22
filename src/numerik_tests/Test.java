/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package numerik_tests;

/**
 *
 * @author Yzerman
 */
public class Test {

         public static void main(String[] args) {

//            swp2012_ode1 eulerklasse = new swp2012_ode1();
//            System.out.println(eulerklasse.Euler(6, 0, 0.5, 1));
//            System.out.println(" " + eulerklasse.RK4(6, 0, 0.5, 2));

            springer eulerklasse = new springer();
            System.out.println(" " + eulerklasse.RK4(100, 0, 0, 1));
            springer_1 springer = new springer_1();

            //double t0, double t1, double tn, double tAnfang, double[] yAnfang, double h
             /** z[0] = x-Komponente des Positionsvektors        **/
            /** z[1] = y-Komponente des Positionsvektors        **/
            /** z[2] = x-Komponente des Geschwindigkeitsvektors **/
            /** z[3] = y-Komponente des Geschwindigkeitsvektors **/
            springer.fTable(0, 1, 100, 0, {0 1000 5 5}, 1);
    }
}
