package calculateur;


import calculateur.Exception.DivisionException;
import calculateur.Exception.OperationException;

public class Calculette implements InterfaceCalculette {

	
    public float calculer(String op,float a,float b) throws DivisionException, OperationException {
    	
        Operation o = CalculetteConf.getOperation(op);
       
        return o.execute(a, b);
        

    }
}
