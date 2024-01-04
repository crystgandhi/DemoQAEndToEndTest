package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {
	
	Properties prop;
	public  ReadConfig() throws IOException {
		File configPropertiesFile=new File("./Configuration/config.properties");
		FileInputStream fis=new FileInputStream(configPropertiesFile);
		prop=new Properties();
		prop.load(fis);
		}
	
	public String getURL() {
		return prop.getProperty("url");
	}

}
