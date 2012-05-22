package numerik_tests;

/***********************************************************************/
/* Rechenoperationen zur Linearen Algebra                              */
/* L�sung von linearen Gleichungssystemen mit dem Verfahren nach Gauss */ 
/*                                                                     */
/* @author   AH                                                        */
/* @version  04.04.2011                                                */
/* aus: linalg4_3.java 04.04.2010                                      */
/***********************************************************************/

   
public class linalg4_4     
{
 
   

 

 
/***********************************************************************/
/* Operationen mit Vektoren und Matrizen                               */                          
/*                                                                     */
/***********************************************************************/

    /** Kopie eines Vektors      */    
    public double[] copyVector(double[] x)
    {   
        int n = x.length;        
        double[] z  = new double[n];         

        for (int k=0; k<n; k++)        
            z[k]=x[k];
        return z;
    }

   /** Kopie einer Matrix      */         
    public double[][] copyMatrix  ( double[][] x) 
    {              
        int n = x.length;
        int m = x[0].length;
        double[][] xcopy = new double [n][m];
        for (int i=0; i<n; i++)
            for (int j=0; j<m; j++)
                xcopy[i][j] = x[i][j];
        return xcopy;           
    }
        
    
    /** augmentieren von zwei Marizen      */     
    public double[][] augment(double[][] A,double[][] C ) 
    {
        int n = A.length;
        int mA = A[0].length;
        int mC = C[0].length;
        double[][] D = new double[n][mA+mC];
      
        /** augmentierte Matrix erstellen */        
        for (int i = 0; i < n; i++) 
        {
            for (int j = 0; j < mA; j++) 
                D[i][j]=A[i][j];
            for (int j = 0; j < mC; j++) 
                D[i][j+mA]=C[i][j];
        }
        // printMatrix (D);
        return D;  
    }
    
    /** stapeln von zwei Marizen      */          
    public double[][] stack(double[][] A,double[][] C ) 
    {
        int nA = A.length;
        int m  = A[0].length;
        int nC = C.length;
        double[][] D = new double[nA+nC][m];
      
        /** gestapelte Matrix erstellen */        
        for (int j = 0; j < m; j++) 
        {
            for (int i = 0; i < nA; i++) 
                D[i][j]=A[i][j];
            for (int i = 0; i < nC; i++) 
                D[i+nA][j]=C[i][j];
        }
        // printMatrix (D);
        return D;  
    }
    
    /** stapeln von zwei Vektoren      */          
    public double[] stackVector(double[] A,double[] C ) 
    {
        int nA = A.length;
      
        int nC = C.length;
        double[] D = new double[nA+nC];
      
        /** gestapelten Vektor erstellen */        
        
            for (int i = 0; i < nA; i++) 
                D[i]=A[i];
            for (int i = 0; i < nC; i++) 
                D[i+nA]=C[i];
        
        // printVector (D);
        return D;  
    }

    /** Skalarprodukt von 2 Vektoren */  
    public double sProd(double X[],double Y[])
    {       
        double sq = 0;
        
        int n = X.length;
        
        for (int i=0; i<n; i++)           
            sq = sq+X[i]*Y[i];
        
        return sq;
    }
    
    /** Betrag eines Vektors */
    public double abs(double X[])
    {                       
        double sq = sProd(X, X);        
        return Math.sqrt(sq);
    }

        
    /** Einheitsvektor eines Vektors */
    public double[] unitVector(double X[])
    {                             
        return multScalarVector(1/abs(X), X);
    }

    
    /** Summe von 2 Vektoren */ 
    public double[] addVector(double A[],double B[])
    {       
        int n = A.length;
        double[] C  = new double[n];
            
        for (int i=0; i<n; i++)
            C[i] = A[i]+B[i];
         
        return C;
    }    
    
    
    
    
    /** Differenz von 2 Vektoren */
    public double[] subtrVector(double A[],double B[])
    {       
        int n = A.length;
        double[] C  = new double[n];
        
        for (int i=0; i<n; i++)
        {  
                C[i] = A[i]-B[i];
        }
        
        return C;
    }

   /** Produkt von Skalar mit Vektor */  
    public double[] multScalarVector(double a,double B[])
    {       
        int n = B.length;
        double[] C  = new double[n];
        
        for (int i=0; i<n; i++)
        {  
                C[i] = a*B[i];
        }
        
        return C;
    }    
    
    
   /** Produkt aus Matrix und Vektor */ 
    public double[] multMatrixVector(double A[][],double B[])
    {       
        int n = A.length;
        int m = A[0].length;
        double[] C  = new double[n];
        
        /** Berechnungen einf�gen */ 
        
        return C;
    }

    
    /** Produkt von 2 Matrizen */     
    public double[][] multMatrix(double A[][],double B[][])
    {       
        
        int o = A[0].length;
        int m = B[0].length;
        int n = A.length;
        double[][] C  = new double[n][m];
            
       /** Berechnungen einf�gen */ 
               
        return C;
    }
   

    /** Summe von 2 Matrizen */     
    public double[][] addMatrix(double A[][],double B[][])
    {       
        int m = A[0].length;
        int n = A.length;
        double[][] C  = new double[n][m];
            
        for (int i=0; i<n; i++)
            for (int j=0; j<m; j++)
                C[i][j] = A[i][j]+B[i][j];
         
        return C;
    }

    /** Differenz von 2 Matrizen */     
    public double[][] subtrMatrix(double A[][],double B[][])
    {       
        int m = A[0].length;
        int n = A.length;
        double[][] C  = new double[n][m];
            
        for (int i=0; i<n; i++)
            for (int j=0; j<m; j++)
                C[i][j] = A[i][j]-B[i][j];
         
        return C;
    }

    /** Submatrix einer Matrix */     
    public double[][] submatrix(double A[][], int rowFrom, int rowTo, int colFrom, int colTo)
    {               
        int n = rowTo-rowFrom+1;
        int m = colTo-colFrom+1;
        double[][] C  = new double[n][m];
            
        for (int i=0; i<n; i++)
            for (int j=0; j<m; j++)
                C[i][j] = A[rowFrom+i][colFrom+j];
        // printMatrix (C);
        
        return C;
    }
    
    /** Inversion von 2*2-Matrizen    */
    public double[][] inv_2(double A[][])
    {   
        double[][] invA  = new double[2][2]; 
        
         /** Berechnungen einf�gen */ 
        
        return invA;
    }
   

    /** Mittel von m Vektoren der L�nge n      */         
    public double[] meanVector( double[][] x)
    {       
        int m = x.length;
        int n = x[0].length;
        double q = 1.0/m;
        double[] y = new double[n];
 
        for (int j=0;  j<m; j++)           
            y = addVector(y, x[j]);
        
        y = multScalarVector(q, y);
       
        return y;
    }    
    

           
/***********************************************************************/
/* Ausdrucken von Vektoren und Matrizen, Strings und Zahlen            */
/***********************************************************************/


    public void printVector (double[] A) 
    {
        int n = A.length;
       
        System.out.println();
        for (int i = 0; i < n; i++)
        {
            System.out.print(A[i] + " , ");                                     
        }       
    }
    
        
    public void print (String s) 
    {       
        System.out.println();
        System.out.print(s);                                                     
    }
    
    public void nprint (String s, double x) 
    {       
        System.out.println();
        System.out.print(s + x);                                                     
    }
    
    public void printMatrix (double[][] A) 
    {
        int n = A.length;
        int m = A[0].length;
       
        System.out.println();
        for (int i = 0; i < n; i++)
        {
            System.out.println();
            for (int j = 0; j < m; j++)
                System.out.print(A[i][j] + " , ");                
        }
        System.out.println();
        
    }
    
        
/***********************************************************************/
/* Gauss Algorithmus aus lina6 vom 23.01.2004, modifiziert 18.10.2007  */
/***********************************************************************/


    /** L�sung der linearen Gleichung A*X=C, A Matrix, C Vektor */ 
    public double[] solveLinEqu(double A[][], double C[])
    {       
        // Version mit Gauss Jordan Algorithmus 
        int        n = A.length;        
        double[][] Y = new double[n][1]; 
        double[][] Z = new double[n][1]; 
        double[]   X = new double[n]; 
        
        /** Berechnungen einf�gen */ 
       
        return X;        
    }
    

    

    /** Gauss Jordan Algorithmus zur L�sung der linearen Gleichung A*X=C, A Matrix, C Matrix */ 
    public double[][] gaussMatrix(double[][] A,double[][] C ) 
    {
        int n = A.length;
        int mA = A[0].length;
        int mC = C[0].length;
        int m = mA+mC;
        double[][] D = new double[n][m];
        
        double[][] X = new double[n][mC];
                
       /** Berechnungen einf�gen */ 
        
        return X;              
    }   
    



    
 }   
