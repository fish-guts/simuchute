
package simuchute.ch.i10a.chute.logic;
import simuchute.ch.i10a.chute.tools.Tools;

/***********************************************************************/
/* Anfangswertprobleme (Differentialgleichungen)                       */
/* @author   Albert Heuberger                                          */
/* @modifiziert und erweitert von Patrice Keusch                       */
/* @version  26.05.2012                                                */
/*                                                                     */
/***********************************************************************/
// Zugang zu  Methoden aus der Linearen Algebra

public class Springer extends linalg4_4{

// Variablen deklarieren
private double r;
private double g;
private double cw;
private double springerFlaeche;
private double differenzFlaeche;
private double anzahlSchritteBeimOeffnen;
private double flaecheAddierenBeimOeffnen;
private double cwAddierenBeimOeffnen;
private double cwDifferenz;

private SimulationObject simulationObject;

    public Springer(SimulationObject simulationObject){
        
        this.simulationObject = simulationObject;
        init();
    }
    
    public void init(){

         g = 9.81;
         cw = simulationObject.getCwStart();
         springerFlaeche = simulationObject.getSpringerFlaeche();
         calcSchritte();
        
    }

    public void calcSchritte(){

        // Schrittweite Berechnen für Flächen und cw Funktion
        anzahlSchritteBeimOeffnen = simulationObject.getTOeffnen()/simulationObject.getSchrittweiteH();

        // Schrittflächen berechnen für Flächenfunktion
        differenzFlaeche = simulationObject.getParachuteArea()-simulationObject.getSpringerFlaecheStart();
        flaecheAddierenBeimOeffnen = differenzFlaeche/anzahlSchritteBeimOeffnen;

        // Schrittflächen berechnen für cw Funktion
        cwDifferenz = simulationObject.getCwEnde()-simulationObject.getCwStart();
        cwAddierenBeimOeffnen = cwDifferenz/anzahlSchritteBeimOeffnen;
        
    }

    public SimulationObject getFlugbahnSpringer(){
        return simulationObject;
    }

    public void calcSpringer(){

        // {xStart-Koordinate, yStart-Koordinate (Flüghöhe), Flugzeuggeschwindigkeit = Springer Startgeschwindigkeit,
        //yStart Geschwindigkeit Springer, Laufzeit}
        double[] yAnfang = {0, simulationObject.getAltitude(), simulationObject.getPlaneSpeed(),0,0};

        // Berechnungen starten, erste drei Werte für TabellenAusgabe: tStart, tSchrittweite, tEnde,
        // Danach tStart, yAnfang Werte (siehe oben), Genauigkeit der Berechnungen.
        double[][] result = fTable(0, simulationObject.getSchrittweiteResult(), simulationObject.getTEnde(),
                0, yAnfang, simulationObject.getSchrittweiteH());
        // Variable für Lösungssuche des Landepunktes
        double KoNull =0;


        // Schlaufe: Suchen des letzten Punktes, welcher über xKoordinate 0 ist = Landepunkte.
        // Danach Schleife verlassen und Wert in KoNull abspeichern
        int n = result.length;

        for(int i = 0; i< n;i++){

            // Abbruch Bedingung
            if(result[i][1] <= 0){

                KoNull = result[i][0];
                i = n;

            }
        }

        // Berchneter Landepunkt vergleichen mit gewünschtem Landepunkt
        // Differenz abziehen und Simulation nochmals laufen lassen
        if (KoNull != simulationObject.getLandePunkt()) {

            // InitialWerte werden nochmals gesetzt. Widerstand, Fläche etc..
            init();

            // Neuer SpringerAbsprungpunkt wird festgelegt
            yAnfang[0] = yAnfang[0] - (KoNull - (simulationObject.getLandePunkt() + 1));

            // Neue Berechnung
            result = fTable(0, simulationObject.getSchrittweiteResult(), simulationObject.getTEnde(), 0, yAnfang, simulationObject.getSchrittweiteH());

            for (int i = 0; i < n; i++) {

                // Maximale Geschwindigkeit auslesen
                if (simulationObject.getMaxSpringerGeschwindigkeit() > result[i][3]) {
                    simulationObject.setMaxSpringerGeschwindigkeit(result[i][3]);
                }

                // Abbruch Bedingung
                if (result[i][1] <= 0) {

                    i = n;
                    
                }
            }
        }

        result = formatResult(result);
        
        // Unnötige Werte abschneiden und Resultat abspeichern
        simulationObject.setResult(result);

        // Springer End Geschwindigkeit ermitteln
        getSpringerEndGeschwindigkeit(result);

        // Springer Flugzeit auslesen
        getSpringerFlugzeit(result);
        // Resultat des Absprungs abspeichern
        simulationObject.setResultAbsprungPunkt(yAnfang[0]);

        // Berechnete Springer Fläche abspeichern
        simulationObject.setSpringerFlaeche(springerFlaeche);

        // Berechneter cw Wert abspeichern
        simulationObject.setCwEnde(cw);
    }

    // Springer End Geschwindigkeit ermitteln
    public void getSpringerEndGeschwindigkeit(double[][] result){

        int n = result.length;
        simulationObject.setSpringerEndGeschwindigkeit(result[n-1][3]);
        
    }

    public void getSpringerFlugzeit(double[][] result){
        int n = result.length;
        simulationObject.setSpringerFlugzeit(result[n-1][4]);
        
    }

    // Unnötige Werte abschneiden
    public double[][] formatResult(double[][] result) {

        int n = result.length;

        int o = 0;
        for (int i = 0; i < n; i++) {


            if (result[i][1] <= 0) {
            } else {
                o++;
            }
        }
        double[][] resultnew = new double[o][5];
        for (int i = 0; i < n; i++) {


            if (result[i][1] <= 0) {
                o++;

            } else {

                resultnew[i][0] = result[i][0];
                resultnew[i][1] = result[i][1];
                resultnew[i][2] = result[i][2];
                resultnew[i][3] = result[i][3];
                resultnew[i][4] = result[i][4];

            }
        }

        // Letzter xWert wird gerundet
        n = resultnew.length;
        resultnew[n-1][1]= Math.round(resultnew[n-1][1]);
        
        return resultnew;

    }
/***********************************************************************/
/* Funktionen zur Definition  von Differentialgleichungen z'=w(t,z)    */
/*            für Funktion z=f(t)                                      */
/***********************************************************************/

    //Flug eines Fallschirmspringers mit Reibung im Wind. Öffnen des Fallschirmes

    //Berechnungen der Ableitungen

    public double[] w (double t, double[] z)
    {
        /** Zustandsgr�ssen **/
        /** z[0] = x-Komponente des Positionsvektors        **/
        /** z[1] = y-Komponente des Positionsvektors        **/
        /** z[2] = x-Komponente des Geschwindigkeitsvektors **/
        /** z[3] = y-Komponente des Geschwindigkeitsvektors **/

        /** Ableitungen der Zustandsgrössen **/
        double[]res = new double[5];

        /** u = Geschwindigkeit Springer gegenüber bewegter Luft **/
        double[]u = new double[2];
        double uBetrag;
        u[0] =  z[2]-wind(t,z)[0];
        u[1] =  z[3]-wind(t,z)[1];
        

        /** Berechnung derAbleitungen der Zustandsgr�ssen **/
        res[0] =  z[2];
        res[1] =  z[3];
        
        uBetrag = Math.sqrt(u[0]*u[0] +  u[1]*u[1]);
        res[2] =      - r * (u[0]*uBetrag); // Ableitung der Geschwindigkeit ergibt Beschleunigung
        res[3] =  - g - (r * (u[1]*uBetrag))/simulationObject.getSpringerGewicht(); 
        
        return res;
    }

    // Windfunktion wind(t,z)
    public double[] wind (double t, double[] z)
    {
        double[]res = new double[4];
    
        res[0] =  simulationObject.getWindSpeed();
        res[1] =  0;

        // Höhe z[1] wird jeweils ausgelesen und verglichen. Je nach Höhe wird ein anderer Wind gesetzt.
        if(z[1] < 4000){
            res[0] = 10;
            res[1] = 0;
        }

        if(z[1] < 3000){
            res[0] = 20;
            res[1] = 20;
        }

        if(z[1] < 2000){
            res[0] = 25;
            res[1] = 0;
        }

        if(z[1] < 1000){
            res[0] = -30;
            res[1] = 0;
        }

        return res;
    }

    // Widerstandsfunktion, r(t) = calcCW(t) * 0.5 * p * calcFlaeche(t)
    public void calcWiderstand(double t){

        r = calcCW(t) * 0.5 * 1.2 * calcFlaeche(t); // r(t) = cw(t) * 0.5 * p * A(t)
        //System.out.println("Widerstand: " + r + "Fläche: " + springerFlaeche + " " + " CW: " + cw + " ");

    }

    // CW Funktion, Abhängig von der Fläche des Fallschirmes und der Zeit
    public double calcCW(double t){

        if(t >= simulationObject.getTOffen() && t < (simulationObject.getTOffen()+simulationObject.getTOeffnen()) ){
            cw = cw + cwAddierenBeimOeffnen;
 
        }
        return cw;

    }

    // Flächen Funktion, Abhängig von der Zeit
    public double calcFlaeche(double t){

        if(t >= simulationObject.getTOffen() && t < (simulationObject.getTOffen()+simulationObject.getTOeffnen())){
            
            springerFlaeche = springerFlaeche + flaecheAddierenBeimOeffnen;
        }
        return springerFlaeche;

    }

/***********************************************************************/
/* Numerische Integration von Differentialgleichungen:                 */
/* Integrations Methoden                                               */
/***********************************************************************/


    // Berechnung der Loesung f(x) eines Anfangswertproblems
    //      d/dx f(x) = w(x,y) , f(xAnfang) = yAnfang
    // fuer eine vektorielle Funktion f:R -> R^n

    /**     Integration mit der Methode Runge Kutta 4.Ordnung)      */

    public double[] RK4(double tEnde, double tAnfang, double[] yAnfang, double h)
    {
        int m = yAnfang.length;

        double[] y, ya, yb, yc, yd;
        double[] k, ka, kb, kc, kd;
        double t, ta, tb, tc;

        y = yAnfang;
        t = tAnfang;

        int i, n;

        // Anpassung der Schrittweite an die Länge des Integrationsintervalls
        n = (int) (Math.round( (Math.abs (tEnde-tAnfang) / h)));
        h = (tEnde-tAnfang) / n;

        for (i=1;  i<=n; i++)
        {

            // Widerstand berechnen und abspeichern in r
            calcWiderstand(t);

            //K1 - RK4-Verfahren
            ka = w(t,y);
            ya = addVector(y, multScalarVector(h/2, ka));
            ta = t + h/2;

            //K2 - RK4-Verfahren
            kb = w(ta,ya);
            yb = addVector(y, multScalarVector(h/2, kb));
            tb = t + h/2;

            kc = w(tb,yb);
            //yc = y + h*kc;
            yc = addVector(y, multScalarVector(h, kc));
            tc = t + h;

            kd = w(tc,yc);

            double v[][] = {ka, kb, kb, kc, kc, kd};
            k = meanVector(v);

            y = addVector(y, multScalarVector(h, k));
            t = t + h;

        }

        return y;
    }


/***********************************************************************/
/* Berechnungen von Wertetabellen                                      */
/***********************************************************************/

    /** erstellen einer gleichabständigen Tabelle t[] = {t0, t1, ... tn} */

    public double[] tTable  ( double t0, double t1, double tn)
    {
        double step = t1-t0;
        int n = (int) ((tn - t0)/step);
        double[]t = new double[n+1];
        int i;

        for (i=0; i<=n; i++)
        {    t[i] = t0 + i*step; }

        return t;
    }

    /** erstellen einer Wertetabelle  y=f(t) f�r die
        Lösung des Anfangswertproblems dy/dt=w(t,y), f(tAnfang)=yAnfang   */

    public double[][] yTable  ( double[] t, double tAnfang,double[] yAnfang, double h)
    {
        int n = t.length;
        int m = yAnfang.length+1;

        int i = 0;

        double[][]y = new double[n][m];


        y[0] = RK4 (t[0], tAnfang, yAnfang, h);

        for (i=1; i<=n-1; i++)
        {

         y[i] = RK4 (t[i], t[i-1], y[i-1], h);

        }

        return y;
    }


    /** erstellen einer Wertetabelle t --> y=f(t)
        mit einer gleichabst�ndigen Tabelle t[] = {t0, t1, ... tn}
        für die Lösung des Anfangswertproblems dy/dt=w(t,y), f(tAnfang)=yAnfang   */

    public double[][] fTable  ( double t0, double t1, double tn, double tAnfang, double[] yAnfang, double h)
    {
        // t0: erster  Zeitpunkt der Tabelle tTable
        // t1: zweiter Zeitpunkt der Tabelle tTable
        // tn: letzter Zeitpunkt der Tabelle tTable

        double[] t = tTable  (t0, t1, tn);
        int n = t.length;
        int m = yAnfang.length;

        double[][]y =  yTable  (t, tAnfang, yAnfang, h);

        // Laufzeit den Werten zu ordnen
        for (int i=0; i<=n-1; i++)
        {

            y[i][4] = t[i];
       
        }
      for (int i=0; i<=n-1; i++)
        {   System.out.print (i+"\t"+t[i]+"\t");
            for (int j=0; j<m; j++)
                System.out.print (+y[i][j]+"\t");
            System.out.println();
        }
        return y;
    }

}
