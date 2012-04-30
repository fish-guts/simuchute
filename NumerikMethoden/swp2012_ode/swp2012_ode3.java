package swp2012_ode;

import simuchute.ch.i10a.chute.logic.linalg4_4;


/***********************************************************************/
/* Anfangswertprobleme (Differentialgleichungen)                       */
/* @author   AH                                                        */
/* aus ode7_7 2 14.04.2011 und odeBeispiele2 2 14.04.2011              */
/* @version  02.04.2012                                                */
/*                                                                     */
/***********************************************************************/

public class swp2012_ode3 extends linalg4_4  

// Zugang zu  Methoden aus der Linearen Algebra
{

/***********************************************************************/
/* Funktionen zur Definition  von Differentialgleichungen z'=w(t,z)    */
/*            f�r Funktion z=f(t)                                      */
/***********************************************************************/

    /**     Beispiel 3: Flug einer Kugel  mit Reibung im Wind   */ 
    /**     (Bewegung in einer Ebene)  */ 
    /**     Anfangswerte f�r Testlauf:  zAnfang={5000, 100, 0, 0} */ 
    static double toeffnen = 0.2;
    static double toffen = 0.22;
    static double r=0;
    public double[] w (double t, double[] z)
    {
        /** Zustandsgr�ssen **/
        /** z[0] = x-Komponente des Positionsvektors        **/
        /** z[1] = y-Komponente des Positionsvektors        **/
        /** z[2] = x-Komponente des Geschwindigkeitsvektors **/
        /** z[3] = y-Komponente des Geschwindigkeitsvektors **/
        
        /** Ableitungen der Zustandsgr�ssen **/
        double[]res = new double[4];//5er array, st�rgr�ssen abspeichern
        
        /** Systemgr�ssen **/   
        double g = 10;        // Gravitations Beschleunigung
        
        r=0.01;
		//r=widerstand(t);
		
        //r=0.2;
            
        /** Einflussgr�ssen **/
        /** Funktion wind **/   
             
        /** Hilfssgr�ssen **/
        /** u = Geschwindigkeit Ball gegen�ber bewegter Luft **/     
        double[]u = new double[2];
        double uBetrag;
        u[0] =  z[2]-wind(t,z)[0];
        u[1] =  z[3]-wind(t,z)[1];
        uBetrag = Math.sqrt(u[0]*u[0] +  u[1]*u[1]);
        
        /** Berechnung derAbleitungen der Zustandsgr�ssen **/
        res[0] =  z[2];
        res[1] =  z[3];
        
        res[2] =      - r * (u[0]*uBetrag);// Einheitsvektor von u
        res[3] =  - g - r * (u[1]*uBetrag);
       
        return res;
    }
    
    public static double widerstand(double t){
		
		if(t>=toeffnen && t<=toffen){
			r = r + 0.0001;
		}
		System.out.println(r);
		return r;
		
	}
        
    public double[] wind (double t, double[] z)
    { 
        double[]res = new double[4];
        if(t>1.8){
        	res[0] =  0;//wind rechts
            res[1] =  0;// wind oben
        	
        }
        else{
        	res[0] =  0;//wind rechts
            res[1] =  0;// wind oben
        }
       
       
        return res;
    }
  


  
    
  

        

        
        
    
    
/***********************************************************************/
/* Numerische Integration von Differentialgleichungen:                 */ 
/* Integrations Methoden                                               */
/***********************************************************************/


    
    // Berechnung der Loesung f(x) eines Anfangswertproblems 
    //      d/dx f(x) = w(x,y) , f(xAnfang) = yAnfang 
    // fuer eine vektorielle Funktion f:R -> R^n                       
     
    /**     Integration mit der Methode nach Euler      */         
    public double[] Euler(double tEnde, double tAnfang, double[] yAnfang, double h)
    {   
        
        double y[];
        double k[];
        double t;
       
        y = yAnfang;
        t = tAnfang;  
        
        int i, n;
        
        // Anpassung der Schrittweite an die L�nge des Integrationsintervalls
        n = (int) (Math.round( (Math.abs (tEnde-tAnfang) / h)));
        h = (tEnde-tAnfang) / n;
        
        for (i=1;  i<=n; i++)
        {   
            k = w(t,y);
            //y = y + h*k;
            y = addVector(y, multScalarVector(h, k));
            t = t + h;
        }
        
        return y;
    }    
    
    
    
    
    
    
   
    
    
    /**     Integration mit der Methode nach Heun (Runge Kutta 2.Ordnung)      */         
           
    public double[] RK2(double tEnde, double tAnfang, double[] yAnfang, double h)
    {
        int m = yAnfang.length;
        
        double[] y, ya, yb;
            
        double[] k, ka, kb;

        double t, ta;
                       
        y = yAnfang;
        t = tAnfang;  
        
        int i, n;
        
        // Anpassung der Schrittweite an die L�nge des Integrationsintervalls
        n = (int) (Math.round( (Math.abs (tEnde-tAnfang) / h)));
        h = (tEnde-tAnfang) / n;           
        
        for (i=1;  i<=n; i++)
        {   
            ka = w(t,y);
            
            //ya = y + h*ka;
            ya = addVector(y, multScalarVector(h, ka));            
            ta = t + h;            
            kb = w(ta,ya);
            
            //k = (1/2)*(ka + kb);
            k = multScalarVector((1.0/2), addVector(ka, kb));
            //y = y + k*h;
            y = addVector(y, multScalarVector(h, k));            
            t = t + h;
          //System.out.println (i+" t="+t+" ka="+ka[0]+" kb="+kb[0]+" k=" +k[0]);
        }
        
        return y;
    }    
    
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
        
        // Anpassung der Schrittweite an die L�nge des Integrationsintervalls
        n = (int) (Math.round( (Math.abs (tEnde-tAnfang) / h)));
        h = (tEnde-tAnfang) / n;             
        
        for (i=1;  i<=n; i++)
        {   
            ka = w(t,y);    
            //ya = y + h/2*ka;
            ya = addVector(y, multScalarVector(h/2, ka));            
            ta = t + h/2;    
            
            kb = w(ta,ya);
            //yb = y + h/2*kb;            
            yb = addVector(y, multScalarVector(h/2, kb));            
            tb = t + h/2; 
            
            kc = w(tb,yb);            
            //yc = y + h*kc;
            yc = addVector(y, multScalarVector(h, kc));
            tc = t + h;
            
            kd = w(tc,yc);
            
            //k = (1/6)*((ka + 2*kb + 2*kc + kd));            
            double v[][] = {ka, kb, kb, kc, kc, kd};
            k = meanVector(v);
            
            //y = y + k*h;
            y = addVector(y, multScalarVector(h, k));  
            t = t + h;
            
        //  System.out.println (i+" t="+t+" ka="+ka[0]+" kb="+kb[0]+" k=" +k[0]);

        }
                
        return y;
    }   
    
    
/***********************************************************************/
/* weitere Methoden                                                    */ 
/***********************************************************************/
     

       

/***********************************************************************/
/* Berechnungen von Wertetabellen                                      */ 
/***********************************************************************/
    
    /** erstellen einer gleichabst�ndigen Tabelle t[] = {t0, t1, ... tn} */         
    
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
        L�sung des Anfangswertproblems dy/dt=w(t,y), f(tAnfang)=yAnfang   */  
         
    public double[][] yTable  ( double[] t, double tAnfang,double[] yAnfang, double h) 
    {       
        int n = t.length;
        int m = yAnfang.length;

        int i = 0;
    
        double[][]y = new double[n][m];

        
        y[0] = RK4 (t[0], tAnfang, yAnfang, h);

        for (i=1; i<=n-1; i++)
        {

          y[i] = RK4 (t[i], t[i-1], y[i-1], h);

        }
        
        for (i=0; i<=n-1; i++)
        {
         // System.out.print (i+"\t"+t[i]+"\t");
         // for (int j=0; j<m; j++)
         // System.out.print (+y[i][j]+"\t");
         // System.out.println(); 
        }
        
        return y;
    }
      
        
    /** erstellen einer Wertetabelle t --> y=f(t) 
        mit einer gleichabst�ndigen Tabelle t[] = {t0, t1, ... tn} 
        f�r die L�sung des Anfangswertproblems dy/dt=w(t,y), f(tAnfang)=yAnfang   */  
                
    public double[][] fTable  ( double t0, double t1, double tn, double tAnfang, double[] yAnfang, double h) 
    {   
        // t0: erster  Zeitpunkt der Tabelle tTable
        // t1: zweiter Zeitpunkt der Tabelle tTable
        // tn: letzter Zeitpunkt der Tabelle tTable
        
        double[] t = tTable  (t0, t1, tn);
        int n = t.length;
        int m = yAnfang.length;
    
        double[][]y =  yTable  (t, tAnfang, yAnfang, h); 
        
        for (int i=0; i<=n-1; i++)
        {   System.out.print (i+"\t"+t[i]+"\t");
            for (int j=0; j<m; j++)
                System.out.print (+y[i][j]+"\t");
            System.out.println(); 
        }
        
        return y;
    }
    

/***********************************************************************/
/* Operationen mit Matrizen und Vektoren                               */
/* Methoden fuer die Teilaufgaben:                                     */
/* Laenge eines Vektors, Multiplikation einer Matrix mit einem Vektor  */
/* etc.                                                                */
/*                                                                     */
/* siehe linalg4_3                                                     */
/***********************************************************************/

    
}
