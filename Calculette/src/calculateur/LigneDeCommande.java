package calculateur;

import java.util.InputMismatchException;
import java.util.Scanner;

import calculateur.Exception.DivisionException;
import calculateur.Exception.OperationException;

public class LigneDeCommande implements IHM  {

	private Scanner sc;

	@Override
	public void lancer() {
		System.out.println("Bienvenue sur la calculette en ligne de commande");
		
		CalculetteConf.init();
		Calculette calculette = new Calculette();

		sc = new Scanner(System.in);
		
		System.out.print("Quelle opération souhaitez vous faire (Indiquez le symbole) :");
		String op = sc.next();
		
		try {
			CalculetteConf.getOperation(op);
		}catch (OperationException e) {
			e.getMessage();
			System.exit(1);
		}
		
		
		try {
			System.out.print("Nombre 1 :");
    		float a = sc.nextFloat();
    		System.out.print("Nombre 2 :");
    		float b = sc.nextFloat();
			float result = calculette.calculer(op,a,b);
			System.out.print("Résulat :");
			System.out.print(result);
			
		}catch (OperationException | InputMismatchException | DivisionException e) {
			if(e.getClass() == InputMismatchException.class) {
				System.out.println("Erreur | Format attendu : float ex : 2,6");
			}
			e.getMessage();
		}
		
		
		
	}
	
	
	
	
	
	


}
