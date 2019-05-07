
package calculateur;

import calculateur.Exception.DivisionException;

public interface Operation {
    float execute(float a, float b) throws DivisionException;
}
