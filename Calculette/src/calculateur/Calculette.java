package calculateur;

import java.util.InputMismatchException;
import java.util.Scanner;

import calculateur.Exception.DivisionException;
import calculateur.Exception.OperationException;

public class Calculette implements InterfaceCalculette {

	
    public float calculer(String op) throws DivisionException, OperationException {
    	
    	Scanner sc = new Scanner(System.in);
        Operation o = CalculetteConf.getOperation(op);
        
        try {
        	System.out.print("Nombre 1 :");
    		float a = sc.nextFloat();
    		System.out.print("Nombre 2 :");
    		float b = sc.nextFloat();
    		
    		return o.execute(a, b);
    		
        }catch (InputMismatchException e) {
			System.err.println("Float only ! (Format : 2,6)");
			System.exit(1);
		}
       
        return 0;
        

    }
}
