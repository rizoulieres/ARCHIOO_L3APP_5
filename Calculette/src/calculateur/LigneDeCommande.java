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
		
		System.out.print("Quelle op�ration souhaitez vous faire (Indiquez le symbole) :");
		String op = sc.next();
		System.out.print("Nombre 1 :");
		float a = sc.nextFloat();
		System.out.print("Nombre 2 :");
		float b = sc.nextFloat();
		
		try {
			float result = calculette.calculer(a, b, op);
			System.out.print("R�sulat :");
			System.out.print(result);
			
		}catch (DivisionException | OperationException e) {

			e.getMessage();
		}
		
		
		
	}
	
	
	
	
	
	


}
