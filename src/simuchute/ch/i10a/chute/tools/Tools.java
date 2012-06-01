package simuchute.ch.i10a.chute.tools;

import simuchute.SimuchuteView;

public class Tools {

    public static void printArray(double[] array) {

        int length = array.length;

        System.out.println("xKO     yKO");
        for (int i = 0; i < length; i++) {


            System.out.print(array[i] + "   ");
        }
    }

    public static void printArray2D(double[][] array) {

        int length = array.length;

        for (int i = 0; i < length; i++) {

            System.out.print("yKO: " + array[i][0] + "   ");
            System.out.print("xKO: " + array[i][1] + "   ");
            System.out.print("xGeschwindigkeit:  " + array[i][2] + "   ");
            System.out.print("yGeschwindigkeit:  " + array[i][3] + "   ");
            System.out.println("Laufzeit:  " + array[i][4] + "   ");

        }

    }

    public static void printArrayInTextArea(SimuchuteView view, double[][] array) {
        String title = "Start";
        String tmp = "";
        String tmp2 = "";
        for (int i = 0; i < array.length; i++) {
            tmp = "";
            tmp = tmp + "yKO: " + array[i][0] + "   \n";
            tmp = tmp + "xKO: " + array[i][1] + "   \n";
            tmp = tmp + "xGeschwindigkeit:  " + array[i][2] + "   \n";
            tmp = tmp + "yGeschwindigkeit:  " + array[i][3] + "   \n";
            tmp = tmp + "Laufzeit:  " + array[i][4] + "   \n";
            view.simulatonOutput.setText(tmp2 + tmp + "\n");
            tmp2 = tmp2+ tmp;
        }

    }
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
