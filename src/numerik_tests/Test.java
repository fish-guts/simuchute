/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package numerik_tests;
import simuchute.ch.i10a.chute.tools.Tools;
/**
 *
 * @author Yzerman
 */
public class Test {

         public static void main(String[] args) {

            //swp2012_ode1 eulerklasse = new swp2012_ode1();
            //Euler(double tEnde, double tAnfang, double yAnfang, double h)
            //System.out.println(eulerklasse.Euler(1000, 0, 0, 1));
//            System.out.println(" " + eulerklasse.RK4(6, 0, 0.5, 2));

             springer eulerklasse = new springer();
             System.out.println(" " + eulerklasse.RK4(1000, 0, 0, 0.1));
             springer_1 springer = new springer_1();

            //double t0, double t1, double tn, double tAnfang, double[] yAnfang, double h
             /** z[0] = x-Komponente des Positionsvektors        **/
            /** z[1] = y-Komponente des Positionsvektors        **/
            /** z[2] = x-Komponente des Geschwindigkeitsvektors **/
            /** z[3] = y-Komponente des Geschwindigkeitsvektors **/
             // t0: erster  Zeitpunkt der Tabelle tTable
        // t1: zweiter Zeitpunkt der Tabelle tTable
        // tn: letzter Zeitpunkt der Tabelle tTable
             double[] yAnfang = {100, 1000, 5,-5};
            Tools.printArray2D(springer.fTable(0, 1, 1000, 0, yAnfang, 1));
            double[][] result = springer.fTable(0, 1, 1000, 0, yAnfang, 1);
            double KoNull =0;
            int n = result.length;

            int aBereich = 90;
            int bBereich = 110;
            for(int i = 0; i< n;i++){

                if(result[i][1] <= 0){

                    System.out.println("End Resultat: " + result[i][0] + " " + result[i][1]);
                    KoNull = result[i][0];
                    i = n;

                }
            }

            if(KoNull != 110){

                yAnfang[0] = yAnfang[0] -(KoNull-110);
                System.out.println(yAnfang[0]);
                result = springer.fTable(0, 1, 1000, 0, yAnfang, 1);

                 for(int i = 0; i< n;i++){

                    if(result[i][1] <= 0){

                    System.out.println("End Resultat: " + result[i][0] + " " + result[i][1]);
                    System.out.println(yAnfang[0]);
                    KoNull = result[i][0];
                    i = n;

                    }
                }
             }







            //double[][] result = springer.fTable(0, 1, 1000, 0, yAnfang, 1);
//
//
//            int n = result.length;
//            double KoNull =0;
//            int j =1;
//
//            System.out.println(result[j][0]);
//
//            while(result[j][0] > 0){
//
//                j = j + 1;
//
//            }
//
//            System.out.println("End Resultat: " + result[j][0]);
//            KoNull = result[j][0];

//            for(int i = 0; i< n;i++){
//
//                if(result[i][1] <= 0){
//
//                    System.out.println("End Resultat: " + result[i][0]);
//                    KoNull = result[i][0];
//                    return;
//
//                }
//            }


//            while(KoNull > 110 || KoNull < 100){
//
//                System.out.println("Wiederholen");
//                yAnfang[0] = yAnfang[0] + 50;
//                springer.fTable(0, 1, 1000, 0, yAnfang, 1);
//
//                n = result.length;
//                j = 1;
//                while(result[j][0] >=0){
//                     j++;
//                 }
//
//                 System.out.println("End Resultat: " + result[j][0]);
//                 KoNull = result[j][0];

//                    if(result[i][1] <= 0){
//
//                        System.out.println("End Resultat: " + result[i][0]);
//                        KoNull = result[i][0];
//                        return;
//
//                    }
                }

            }

            //System.out.print(result[][1]);


