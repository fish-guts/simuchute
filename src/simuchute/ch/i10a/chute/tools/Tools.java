package simuchute.ch.i10a.chute.tools;

public class Tools {
	
	public static void printArray(double[] array){
		
		int length = array.length;
		
		System.out.println("xKO     yKO");
		for(int i = 0;i < length; i++){
			
			
			System.out.print(array[i] + "   ");
		}
	}
	
	public static void printArray2D(double[][] array){
		
		int length = array.length;
		
		System.out.println("xKO     yKO");
		
		for(int i = 0; i < length; i++){
			
			System.out.print("yKO: " + array[i][0] + "   ");
			System.out.print("xKO: " + array[i][1] + "   ");
                        System.out.print("xGeschwindigkeit:  " + array[i][2] + "   ");
                        System.out.println("yGeschwindigkeit:  " + array[i][3] + "   ");
			
		}
		
	}

}
