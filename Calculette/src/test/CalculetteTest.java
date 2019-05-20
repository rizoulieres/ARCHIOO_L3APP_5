package test;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import calculateur.Addition;
import calculateur.Calculette;
import calculateur.CalculetteConf;
import calculateur.Operation;
import calculateur.Exception.DivisionException;
import calculateur.Exception.OperationException;

class CalculetteTest {

	Calculette calculette = new Calculette();

    // Données
    float a;
    float b;
    String op;
    Operation add;


    @Before
    public void setUp() throws Exception { // setup des données avant chaque test
        System.out.println("Defining test data");
        a = -1;
        b = 3;
        op = "+";
        add = new Addition();
    }

    @After
    public void tearDown() throws Exception { // Cleanup apres chaque
        System.out.println("Closing test");
        a = 0;
        b = 0;
        add = new Addition();
    }


    @Test
    public void testCalculer() throws OperationException, DivisionException {
        System.out.println("Test calc execute");
        a = -1;
        b = 3;
        CalculetteConf.init();
        float expResult = 2;
        float result = calculette.calculer("+",a,b);
        assertEquals(expResult, result);
        
    }
    
    //@Test(expected = OperationException.class)
    @Test
    public void testOperationExcep() throws OperationException, DivisionException {
        System.out.println("Test opération inconnue");
        CalculetteConf.init();
       
        Assertions.assertThrows(OperationException.class, () -> {
            calculette.calculer("-", a, b);
          });
        
    }

}
