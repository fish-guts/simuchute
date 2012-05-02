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
			
			System.out.print(array[i][0] + "   ");
			System.out.println(array[i][1]);
			
		}
		
	}

}
