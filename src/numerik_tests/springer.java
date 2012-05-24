package numerik_tests;


/***********************************************************************/
/* Anfangswertprobleme (Differentialgleichungen)                       */
/* @author   AH                                                        */
/* aus ode7_7 2 14.04.2011 und odeBeispiele2 2 14.04.2011              */
/* @version  02.04.2012                                                */
/*                                                                     */
/***********************************************************************/

public class springer extends linalg4_4

// Zugang zu  Methoden aus der Linearen Algebra
{

/***********************************************************************/
/* Funktionen zur Definition  von Differentialgleichungen y'=w(t,y)    */
/*            f�r Funktion y=f(t)                                      */
/***********************************************************************/
double r;
double g = 9.81;
double m = 80;
double flaeche = 0.5;
double cw = 0.5;


/**     Beispiel 1: Differentialgleichung 1. Ordnung   */

    public double w (double t, double z)
    {

        return g * (1-(r*z*z)/(m*g));
    }

/***********************************************************************/
/* Numerische Integration von Differentialgleichungen:                 */
/* Integrations Methoden                                               */
/***********************************************************************/


    // Berechnung der Loesung f(x) eines Anfangswertproblems
    //      d/dx f(x) = w(x,y) , f(xAnfang) = yAnfang
    // fuer eine skalare Funktion f:R -> R
    /**     Integration mit der Methode Runge Kutta 4.Ordnung)      */

    public double  RK4(double tEnde, double tAnfang, double  yAnfang, double h)
    {

        double  y, ya, yb, yc, yd;
        double  k, ka, kb, kc, kd;
        double t, ta, tb, tc;

        y = yAnfang;
        t = tAnfang;

        int i, n;

        // Anpassung der Schrittweite an die L�nge des Integrationsintervalls
        n = (int) (Math.round( (Math.abs (tEnde-tAnfang) / h)));
        h = (tEnde-tAnfang) / n;

        for (i=1;  i<=n; i++)
        {
            if(t >= 20 && t <= 22){

                cw = cw + 0.1;
                r = cw * 0.5 * 1.2 * flaeche;
                flaeche = flaeche + 1;

                System.out.print("Widerstand: " + r + "Fläche: " + flaeche + " " + " CW: " + cw + " ");
                //r = r + 0.0005;
              // System.out.print("Widerstand: " + r + " ");

            }
             else{
                 r = cw * 0.5 * 1.2 * flaeche;
                 System.out.print("Widerstand: " + r + "Fläche: " + flaeche + " " + " CW: " + cw + " ");
             }

            ka = w(t,y);
            ya = y + h/2*ka;

            ta = t + h/2;

            kb = w(ta,ya);
            yb = y + h/2*kb;

            tb = t + h/2;

            kc = w(tb,yb);
            yc = y + h*kc;

            tc = t + h;

            kd = w(tc,yc);

            k = (1.0/6)*((ka + 2*kb + 2*kc + kd));

            y = y + k*h;
            System.out.println("Geschwindigkeit: " + y + "  Zeit: " + t);
            t = t + h;


        //  System.out.println (i+" t="+t+" ka="+ka[0]+" kb="+kb[0]+" k=" +k[0]);

        }

        return y;
    }


/***********************************************************************/
/* weitere Methoden                                                    */
/***********************************************************************/

}
