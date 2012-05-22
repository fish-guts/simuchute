package simuchute.ch.i10a.chute.logic;

import simuchute.ch.i10a.chute.tools.Tools;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
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
		
		
		Tools.printArray2D(result);
		
		
		
	}

}
