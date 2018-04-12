
package com.project.methods;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.Properties;
import javax.naming.ConfigurationException;


public class PropFile {
    
    public Properties Load() throws ConfigurationException {



            String[] arr = new String[2];
            Properties properties = new Properties();
            try {
			File file = new File("client-config.properties");
			FileInputStream fileInput = new FileInputStream(file);
			
			properties.load(fileInput);
			fileInput.close();

			Enumeration enuKeys = properties.keys();
                        int i = 0;
			while (enuKeys.hasMoreElements()) {
                            
				String key = (String) enuKeys.nextElement();
				String value = properties.getProperty(key);
                                arr[i++]=value;
				
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
            
            
            
            
		return properties;
	}

	
	public void Write(String data, String port) {
		Properties prop = new Properties();
		OutputStream output = null;

		try {

			output = new FileOutputStream(
					"client-config.properties");

			// set the properties value
			prop.setProperty("url", data);
                        prop.setProperty("port", port);


			// save properties to project root folder
			prop.store(output, null);

		} catch (IOException io) {
			io.printStackTrace();
		} finally {
			if (output != null) {
				try {
					output.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}

		

	}

    
    public void Create() {
        
        		Properties prop = new Properties();
		OutputStream output = null;

		try {

			output = new FileOutputStream(
					"client-config.properties");

			// set the properties value
			prop.setProperty("url", "0");
                        prop.setProperty("port", "0");


			// save properties to project root folder
			prop.store(output, null);

		} catch (IOException io) {
			io.printStackTrace();
		} finally {
			if (output != null) {
				try {
					output.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}
    
    
}
}

