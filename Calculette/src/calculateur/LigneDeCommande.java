package calculateur;

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
			float result = calculette.calculer(op);
			System.out.print("Résulat :");
			System.out.print(result);
			
		}catch (DivisionException | OperationException e) {

			e.getMessage();
		}
		
		
		
	}
	
	
	
	
	
	


}
