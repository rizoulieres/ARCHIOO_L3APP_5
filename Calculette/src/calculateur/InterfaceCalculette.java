package calculateur;

import calculateur.Exception.DivisionException;


public interface InterfaceCalculette {
    float calculer(float a, float b, String op) throws DivisionException;
}
