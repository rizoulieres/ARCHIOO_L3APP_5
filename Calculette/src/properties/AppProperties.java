package properties;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class AppProperties {
	
	private static Properties prop = new Properties();
	private static AppProperties appprop =null;
	private InputStream input;
	
	public static AppProperties getInstance(String langue) {
		if(appprop == null)
			appprop = new AppProperties(langue);
		
		return appprop;
	}
	
	public AppProperties(String langue) {
		try {
			String curDir = System.getProperty("user.dir");
			 input = new FileInputStream(curDir+"/src/properties/"+"ligne_de_commande_"+langue+".properties");

			// load a properties file
			prop.load(input);
			

		} catch (final IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (final IOException e) {
					e.printStackTrace();
				}
			}
		}

	}
	
	public String getProperties(String p) {
		return prop.getProperty(p);
	}
}

