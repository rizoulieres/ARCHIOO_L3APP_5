
package calculateur.Exception;

import properties.AppProperties;

public class OperationException extends Exception {

	private static AppProperties appS;
	
	public static void setAppProperties(AppProperties app) {
		appS = app;
	}
	
    public OperationException() {
        System.err.println(appS.getProperties("exception_op_message"));
    }
}