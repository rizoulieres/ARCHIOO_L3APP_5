
package calculateur.Exception;

import properties.AppProperties;

public class DivisionException extends Exception {
	
	private static AppProperties appS;
	
	public static void setAppProperties(AppProperties app) {
		appS = app;
	}

    public DivisionException() {
        System.err.println(appS.getProperties("exception_div_message"));
    }
}
