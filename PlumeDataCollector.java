package airquality.collectors;

/**
 * @author brian_b
 *
 */

import java.net.HttpURLConnection;
import java.io.IOException;
import java.net.ProtocolException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
// other imports for handling JSON data not shown

public class PlumeDataCollector {

	/** The URL of the portal from which the data can be downloaded */
	String portalURL;
	
	/** The security token required by the portal to allow data download */
	private final static String SECURITY_TOKEN = "DF$9&CV£Y657";
	
	/** The skeleton of the SQL command used to insert records into the database */
	String partialSQL = "INSERT INTO sensor_measurements (timestamp, location_x, location_y, sensor_id, pollutant, measurement_value) VALUES (";

	String dbConnectionUrl =
            "jdbc:sqlserver://myserver.database.windows.net:1433;"
                    + "database=AirQuality;"
                    + "user=username@myserver;"
                    + "password=password;"
                    + "encrypt=true;"
                    + "trustServerCertificate=false;"
                    + "loginTimeout=30;";
	/**
	 * @param portalURL
	 * @param securityToken
	 * @param partialSQL
	 */
	public PlumeDataCollector(String portalURL, String partialSQL) {
		super();
		this.portalURL = portalURL;
		this.partialSQL = partialSQL;
	}
	
	/** The function for fetching data from the portal, and writing it to the database 
	 * @return String with information on success, or the nature of the failure
	 */
	public String getData(int sensorID) 
	{
		// populate a URL string, using the base URL and token, and adding the sensor id as a parameter (code not shown)
	    String urlString = portalURL + "?sid=" + sensorID + "&token=" + SECURITY_TOKEN;
	    URL dataURL = null;
	    int responseCode = -99;
	    
	    try {
	    	dataURL = new URL(urlString);
	    } 
	    catch (MalformedURLException e0)
	    {
	    	return "Failed to create a valid URL with string " + urlString + " - MalformedURLException";
	    }
		
	    String downloadedJSONstring = "";
	    
	    HttpURLConnection myConnection = null;
	    
		// send the HTTP request and get the JSON file with data for the specified sensor
		try 
		{
			myConnection = (HttpURLConnection) dataURL.openConnection();
			
			try 
			{
				myConnection.setRequestMethod("GET");
			} 
			catch (ProtocolException e1)
			{
				return "Failed to connect to portal: protocol exception";
			}
			try 
			{
				myConnection.connect();
				responseCode = myConnection.getResponseCode();
			}
			catch (IOException e2)
			{
				return "Failed to connect to portal: I/O exception";
			}
		}
		catch (IOException e3)
		{
			return "Failed to connect to portal: I/O exception";
		}
		
        //Make sure that the connection is available and active
        
        if (responseCode != 200) 
        {
            return "Did not get a valid response from the portal: HttpResponseCode: " + responseCode;
        } 
        else 
        {
        	Scanner scanner = null;
        	try {
        
        		scanner = new Scanner(dataURL.openStream());

        		//Write all the JSON data into a string using a scanner
        		while (scanner.hasNext()) {
        			downloadedJSONstring += scanner.nextLine();
        		}
        	} 
        	catch (IOException e4)
        	{
        		return "Did not manage to open the data stream";
        	}

            //Close the scanner
            scanner.close();
        }
        // Using the classes JSONArray, JSONParser and JSONObject, parse the structured data 
        // (code not shown) ...
        
        //Open a database connection and start a transaction
        // (code not shown) ...
        
        // Loop through the time series of measurements
        // (code not shown) ...
        
        	// for each measurement, construct an SQL INSERT statement using the values and the class variable 'partialSQL'
        	// run the SQL to insert the measurement into the database, checking for errors and throwing exceptions if necessary.
        	// (code not shown)...
        
        // end of measurement storage loop
        
        // Commit the transaction and close the database connection if no exceptions were encountered
        // (code not shown) ...
        
        // if you get to this point, report success
        
        return "Successfully fetched data and wrote it to the database";
	}
        
	
}