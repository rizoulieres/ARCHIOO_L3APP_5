package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import calculateur.Addition;
import calculateur.CalculetteConf;
import calculateur.Multiplication;
import calculateur.Exception.OperationException;

class CalculetteConfTest {

	@Test
    public void testAjoutOpError() {
        System.out.println("Test ajout OP error");
        CalculetteConf.init();
        String symbole = "+";
        Addition add = new Addition();
        assertFalse(CalculetteConf.ajouterOperation(symbole, add));
        
    }
	
	@Test
    public void testAjoutOpSuccess() {
        System.out.println("Test ajout OP Success");
        CalculetteConf.init();
        String symbole = "*";
        Multiplication mul = new Multiplication();
        assertTrue(CalculetteConf.ajouterOperation(symbole, mul));
        
    }
	
	@Test
    public void TestGetOp() throws OperationException {
        System.out.println("Test getOp");
        CalculetteConf.init();
        
        assertEquals(Addition.class,CalculetteConf.getOperation("+").getClass());
        
    }
	
	

}
