package swp2012_ode;
import swp2012_ode.linalg4_4;


public class maintest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double dobue[]= {2,2};
		System.out.println(new linalg4_4().abs(dobue));
		// e berechnen, 1,0,1,0.00001
		// e ist seine ableitung + integration, e^0 = 1 -->
		double  zahl1 = 1;
		double zahl2 = 0;
		double zahl3 = 1;
		double zahl4 = 1;
		double zahl5[] = {0, 1000, 5, 0};
		
		//sinus, double[] = {0,1}, 
		
//		System.out.println(new swp2012_ode1().Euler(zahl1, zahl2, zahl3, zahl4));
//		//System.out.println(new swp2012_ode1().RK2(zahl1, zahl2, zahl3, zahl4));
//		
//		double res[] = new swp2012_ode2().Euler(zahl1, zahl2, zahl5,zahl4);
//		
//		for(int i =0; i<= 1;i++){
//			System.out.println(res[i]);
//		}
//		
//		double res1[] = new swp2012_ode2().RK4(zahl1, zahl2, zahl5,zahl4);
//		
//		for(int i =0; i<= 1;i++){
//			System.out.println(res1[i]);
//		}
//		
//		//new swp2012_ode2().fTable(0, 0.5, 6, 0, new {0,1}, 0.00001);
//		new swp2012_ode2().fTable(0, 1, 6, 1, zahl5, zahl4); //sinus berechnet, 
		//t0, t2, tende, tanfang,{10=xKO, 0=yKO, 5=x-geschw, 12=y-geschw},schrittgrösse
		new swp2012_ode3().fTable(0, 1, 100, 0, zahl5, zahl4);
		
		
	}

}
