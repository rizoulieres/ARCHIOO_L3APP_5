package calculateur;

import calculateur.Exception.DivisionException;
import calculateur.Exception.OperationException;

public class Calculette implements InterfaceCalculette {

    public float calculer(float a, float b, String op) throws DivisionException, OperationException {
        Operation o = CalculetteConf.getOperation(op);

        if (o == null) {
            throw new IllegalArgumentException();
        }

        return o.execute(a, b); 

    }
}
