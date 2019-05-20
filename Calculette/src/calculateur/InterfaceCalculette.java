package calculateur;

import calculateur.Exception.DivisionException;
import calculateur.Exception.OperationException;

public interface InterfaceCalculette {
    float calculer(String op,float a, float b) throws DivisionException, OperationException;

}
