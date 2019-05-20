package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import calculateur.Addition;

class AdditionTest {

	// Données pour mes test :
    Addition add = new Addition();
    float a = -1;
    float b = 3;

    @Before
    public void setUp() throws Exception {
        System.out.println("Defining test data");
        a = -1;
        b = 3;
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("Closing test");
        a = 0;
        b = 0;
    }

    @Test
    public void testExecute() {
        System.out.println("Test execute");
        float expResult = 2;
        float result = add.execute(a, b);
        assertEquals(expResult, result);
    }

}
