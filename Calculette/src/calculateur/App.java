package calculateur;


import java.io.IOException;

import calculateur.Exception.DivisionException;
import calculateur.Exception.OperationException;
import properties.AppProperties;

public class App {

	public static void main(String[] args) {


		new Thread(new Runnable() {
			public void run() {
				try {
					Serveur.launch();
				} catch (UnsupportedOperationException | ClassNotFoundException | IOException | DivisionException | OperationException e) {
					System.err.println(e.getMessage());
				}
			}
		}).start();
		//en francais
		LigneDeCommande app = new LigneDeCommande(AppProperties.getInstance("fr"));
		
		//en anglais
		//LigneDeCommande app = new LigneDeCommande(AppProperties.getInstance("en"));
		app.lancer();
	}




}
