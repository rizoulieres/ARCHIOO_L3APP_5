package calculateur;

import java.util.HashMap;
import java.util.Map;

import calculateur.Exception.OperationException;
import properties.AppProperties;

public class CalculetteConf {
	
	private static Map<String, Operation> operations;
	private static AppProperties appS;
	
	public static void setAppProperties(AppProperties app) {
		appS = app;
	}


	public static boolean ajouterOperation(String symbole, Operation op) {
		if((operations.get(symbole) != null)){
			System.err.println(appS.getProperties("exception_couple_message"));
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
