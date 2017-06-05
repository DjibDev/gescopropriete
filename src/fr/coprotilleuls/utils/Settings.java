/**
 * 
 */
package fr.coprotilleuls.utils;

/**
 * @author jblot2016
 *
 */
import java.util.Properties;


/**
 * @author Administrateur
 * 
 */
public class Settings {
	private static Properties properties;
	static {
		try {
			properties = new Properties();
			properties.loadFromXML(Settings.class.getResourceAsStream("settings.xml"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static String getProperty(String key){
		String parametre = properties.getProperty(key,null);
		return parametre;
	}

}
