package calculateur;


import properties.AppProperties;

public class App {

	public static void main(String[] args) {
		//LigneDeCommande app = new LigneDeCommande(AppProperties.getInstance("fr"));
		LigneDeCommande app = new LigneDeCommande(AppProperties.getInstance("en"));
		app.lancer();
	}
	

}
