package calculateur;

import calculateur.Exception.DivisionException;

import java.util.HashMap;
import java.util.Map;

public class Calculette implements InterfaceCalculette {

    private Map<String, Operation> operations;

    public Calculette() {
        this.operations = new HashMap<String, Operation>();
    }

    public void ajouterOperation(String symbole, Operation op) {
            this.operations.put(symbole, op); 
    }


    public float calculer(float a, float b, String op) throws DivisionException {
        Operation o = this.operations.get(op);

        if (o == null) {
            throw new IllegalArgumentException();
        }

        return o.execute(a, b); 

    }
}
