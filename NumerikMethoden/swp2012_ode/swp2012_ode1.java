package swp2012_ode;

/***********************************************************************/
/* Anfangswertprobleme (Differentialgleichungen)                       */
/* @author   AH                                                        */
/* aus ode7_7 2 14.04.2011 und odeBeispiele2 2 14.04.2011              */
/* @version  02.04.2012                                                */
/*                                                                     */
/***********************************************************************/

public class swp2012_ode1 extends linalg4_4  

// Zugang zu  Methoden aus der Linearen Algebra
{

/***********************************************************************/
/* Funktionen zur Definition  von Differentialgleichungen y'=w(t,y)    */
/*            fŸr Funktion y=f(t)                                      */
/***********************************************************************/



/**     Beispiel 1: Differentialgleichung 1. Ordnung   */ 
    
    public double w (double t, double z)
    {   
        return z;// t nach z geŠndert.
    }
    
  
    
/***********************************************************************/
/* Numerische Integration von Differentialgleichungen:                 */ 
/* Integrations Methoden                                               */
/***********************************************************************/


    
    // Berechnung der Loesung f(x) eines Anfangswertproblems 
    //      d/dx f(x) = w(x,y) , f(xAnfang) = yAnfang 
    // fuer eine skalare Funktion f:R -> R                       
     
    /**     Integration mit der Methode nach Euler      */         
    public double Euler(double tEnde, double tAnfang, double yAnfang, double h)
    {   
        
        double y;
        double k;
        double t;
       
        y = yAnfang;
        t = tAnfang;  
        
        int i, n;
        
        // Anpassung der Schrittweite an die LŠnge des Integrationsintervalls
        n = (int) (Math.round( (Math.abs (tEnde-tAnfang) / h)));
        h = (tEnde-tAnfang) / n;
        
        for (i=1;  i<=n; i++)
        {   
            k = w(t,y);
            y = y + h*k;//steigung nach oben
          
            t = t + h;// nach rechts
        }
        
        return y;
    }    
    
    
    
    
    
    
   
    
    
    /**     Integration mit der Methode nach Heun (Runge Kutta 2.Ordnung)      */         
           
    public double RK2(double tEnde, double tAnfang, double  yAnfang, double h)
    {
        
        double  y, ya, yb;
            
        double  k, ka, kb;

        double t, ta;
                       
        y = yAnfang;
        t = tAnfang;  
        
        int i, n;
        
        // Anpassung der Schrittweite an die LŠnge des Integrationsintervalls
        n = (int) (Math.round( (Math.abs (tEnde-tAnfang) / h)));
        h = (tEnde-tAnfang) / n;           
        
        for (i=1;  i<=n; i++)
        {   
            ka = w(t,y);//erste Steigung
            
            ya = y + h*ka; //y = erster Punkt, ya = nŠchster Punkt
                 
            ta = t + h;            
            kb = w(ta,ya);//zweite Steigung
            
            k = (1.0/2)*(ka + kb);//gemittelte Steigung
           
            y = y + k*h;
                       
            t = t + h;
          //System.out.println (i+" t="+t+" ka="+ka+" kb="+kb+" k=" +k);
        }
        
        return y;
    }    
    
    /**     Integration mit der Methode Runge Kutta 4.Ordnung)      */         
           
    public double  RK4(double tEnde, double tAnfang, double  yAnfang, double h)
    {
        
        double  y, ya, yb, yc, yd;            
        double  k, ka, kb, kc, kd; 
        double t, ta, tb, tc;
        
        y = yAnfang;
        t = tAnfang;  
        
        int i, n;
        
        // Anpassung der Schrittweite an die LŠnge des Integrationsintervalls
        n = (int) (Math.round( (Math.abs (tEnde-tAnfang) / h)));
        h = (tEnde-tAnfang) / n;             
        
        // vier verschiedene Steilheiten, zuerst halbe schrittweite weiter, dann berechnen
        // vier steigungen werden gemittelt 
        
        for (i=1;  i<=n; i++)
        {   
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
            
            k = (1.0/6)*((ka + 2*kb + 2*kc + kd)); //mittel von weiteren steigungen           
         
            y = y + k*h;
          
            t = t + h;
            
        //  System.out.println (i+" t="+t+" ka="+ka[0]+" kb="+kb[0]+" k=" +k[0]);

        }
                
        return y;
    }   
    
    
/***********************************************************************/
/* weitere Methoden                                                    */ 
/***********************************************************************/
     
}
