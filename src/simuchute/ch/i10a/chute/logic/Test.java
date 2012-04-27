package simuchute.ch.i10a.chute.logic;

import simuchute.ch.i10a.chute.tools.Tools;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Flugzeug flugzeug;
		flugzeug = new Flugzeug();
		double[] startKO = {0,0};
		flugzeug.setKO(startKO);
		flugzeug.setTime(5);
		flugzeug.setTStart(0);
		flugzeug.calcFlugbahn();
		double[][] flugbahn = flugzeug.getFlugbahn();
		//Tools.printArray(startKO);
		//Tools.printArray2D(flugbahn);
		
		Springer springer;
		springer = new Springer();
		double[] startWerte = {0,1000,0,0};
		double[][] result;
		result = springer.fTable(0, 1, 100, 0, startWerte, 1);
		
		Tools.printArray2D(result);
		
		
		
	}

}
