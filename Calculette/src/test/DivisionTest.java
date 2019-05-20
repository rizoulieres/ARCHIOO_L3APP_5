package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import calculateur.Division;
import calculateur.Operation;
import calculateur.Exception.DivisionException;
import calculateur.Exception.OperationException;

class DivisionTest {

	Operation div = new Division();
    float a = 8;
    float b = 2;

    @Before
    public void setUp() throws Exception {
        System.out.println("Defining test data");
        a = 8;
        b = 2;
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("Closing test");
        a = 0;
        b = 0;
    }

    @Test
    public void testExecute() throws OperationException, DivisionException {
        System.out.println("Test execute success");
        float expResult = 4;
        float result = div.execute(a,b);

        assertEquals(expResult, result);
    }
    
    //@Test(expected=DivisionException.class) //Pour Junit 4
    //Junit 5 utilisé
    @Test
    public void testDivisionPar0() throws OperationException, DivisionException {
        System.out.println("Test execute Division Par 0");
        b=0;
       
        Assertions.assertThrows(DivisionException.class, () -> {
            div.execute(a, b);
          });
    }

}
