package calculateur;

import calculateur.Exception.DivisionException;
import calculateur.Exception.OperationException;

public interface InterfaceCalculette {
    float calculer(float a, float b, String op) throws DivisionException, OperationException;
}
