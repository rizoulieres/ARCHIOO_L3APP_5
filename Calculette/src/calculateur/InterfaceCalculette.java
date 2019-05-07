package calculateur;

import calculateur.Exception.DivisionException;
import calculateur.Exception.OperationException;

public interface InterfaceCalculette {
    float calculer(String op) throws DivisionException, OperationException;

}
