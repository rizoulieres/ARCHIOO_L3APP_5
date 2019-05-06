package calculateur;

import java.util.Scanner;

import calculateur.Exception.DivisionException;

public class LigneDeCommande implements IHM  {

	@Override
	public void lancer() {
		Calculette calculette = new Calculette();
		Addition add = new Addition();
		Division div = new Division();
		calculette.ajouterOperation("+",add);
		calculette.ajouterOperation("/",div);
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Opération (+ ou /) :");
		String op = sc.next();
		System.out.print("Nombre 1 :");
		float a = sc.nextFloat();
		System.out.print("Nombre 2 :");
		float b = sc.nextFloat();
		
		try {
			float result = calculette.calculer(a, b, op);
			System.out.print("Résulat :");
			System.out.print(result);
			
		}catch (DivisionException e) {
			e.getMessage();
		}
		
		
		
	}
	
	
	
	
	
	


}
