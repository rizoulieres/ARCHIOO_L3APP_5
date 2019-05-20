package calculateur;

import java.util.InputMismatchException;
import java.util.Scanner;

import calculateur.Exception.DivisionException;
import calculateur.Exception.OperationException;
import properties.AppProperties;

public class LigneDeCommande implements IHM  {

	private Scanner sc;
	private AppProperties texte;
	
	public LigneDeCommande() {
		texte = new AppProperties("fr");
		DivisionException.setAppProperties(texte);
		OperationException.setAppProperties(texte);
		CalculetteConf.setAppProperties(texte);
		
	}
	
	public LigneDeCommande(AppProperties app) {
		texte = app;
		DivisionException.setAppProperties(texte);
		OperationException.setAppProperties(texte);
		CalculetteConf.setAppProperties(texte);
	}
	
	@Override
	public void lancer() {
		System.out.println(texte.getProperties("welcome_message"));
		
		CalculetteConf.init();
		Calculette calculette = new Calculette();

		sc = new Scanner(System.in);
		
		System.out.print(texte.getProperties("operation_message"));
		String op = sc.next();
		
		try {
			CalculetteConf.getOperation(op);
		}catch (OperationException e) {
			e.getMessage();
			System.exit(1);
		}
		
		
		try {
			System.out.print(texte.getProperties("first_digit"));
    		float a = sc.nextFloat();
    		System.out.print(texte.getProperties("second_digit"));
    		float b = sc.nextFloat();
			float result = calculette.calculer(op,a,b);
			System.out.print(texte.getProperties("result_message"));
			System.out.print(result);
			
		}catch (OperationException | InputMismatchException | DivisionException e) {
			if(e.getClass() == InputMismatchException.class) {
				System.err.println(texte.getProperties("exception_number_message"));
			}
			e.getMessage();
		}
		
		
		
	}
	
	
	
	
	
	


}
