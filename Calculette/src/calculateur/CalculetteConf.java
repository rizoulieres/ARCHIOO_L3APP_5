package calculateur;

import java.util.HashMap;
import java.util.Map;

import calculateur.Exception.OperationException;

public class CalculetteConf {
	
	private static Map<String, Operation> operations;


	public static boolean ajouterOperation(String symbole, Operation op) {
		if((operations.get(symbole) != null)){
			System.err.println("Ce couple Symbole / Opération existe déjà");
			return false;
		}else {
			operations.put(symbole, op);
			return true;
		}
		 
	}
	
	public static Operation getOperation(String symbole) throws OperationException {
		if(operations.get(symbole) == null) {
			throw new OperationException();
		}
		return operations.get(symbole);
		
	}
	
	public static void init() {
		operations = new HashMap<String, Operation>();
		Addition add = new Addition();
		Division div = new Division();
		ajouterOperation("+",add);
		ajouterOperation("/",div);
	}

}
