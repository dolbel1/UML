/**
 *
 */
package airquality.collectors;

import java.util.ArrayList;

import airquality.sensors.SCSensor;
/**
 * @author amir_a
 *
 */
public class SCDataCollector {

	public SCDataCollector() 
	{
	
	}
    		
	public String getDataFromSensor (SCSensor scs) 
	{
		String dataFilePath = null;
		// this function (code and imports not shown) 
		// - connects to the supplied sensor
		// - uses its 'getStoredData' to retrieve a csv-formatted set of data 
    	// - writes that data file to local storage
    	// You can assume that any I/O exceptions are handled and thrown, and that the file correctly overwrites any existing file of the same name.
    	// If all goes successfully, this function will return the location of the data file, otherwise 'null'.
		return dataFilePath;
	}
    
    public boolean insertDataToDB (String dataFilePath, String dbConnectionString, String destinationTableName, ArrayList<String> originFieldNames, ArrayList<String> destinationFieldNames) 
	{
    	boolean success = false;
		// this function (code and imports not shown) 
		// - manages, checks, opens and closes the connection to the database, using the variable 'dbConnectionString'
    	// - writes the data from the csv file to the database
    	// Mappings between field names in the csv file are obtained from the two arrays passed in
    	// You can assume that any SQL or I/O exceptions are handled
    	// If all goes successfully, this function will return 'true' otherwise 'false'
    	return success;
	}
    
    public boolean cleanUpSensor (SCSensor scs) 
	{
    	boolean success = false;
    	try
    	{
    		scs.clearStoredData();
    		success = true;
    	}
    	catch (Exception e)
    	{
    		// log the exception (logging framework not shown here)
    	}
    	return success;
	}

}