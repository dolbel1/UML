/**
 * 
 */
package airquality.collectors;

import java.util.HashMap;
import java.util.Map;

/**
 * @author claire_c
 *
 */
public class ZephyrDataCollector {

	// String defining the database connection            
    private String databaseConnectionString;
    
    private String tableName;
    private String valueField;
    
	// A HashMap which links the field name in the csv file to the database field where it should be written
    // This allows for the fact that the database field names and the headings in the csv are not quite the same.
    protected Map<String, String> csvToDBfield = new HashMap<>(Map.of("UnixTime","timestamp", "CoordX", "location_x", "CoordY", "location_y", "ID", "sensor_id"));
    
	// A HashMap which links the pollutant name in the csv file to the label which should be written into the 'pollutant' field of the database
    // This allows for the fact that the legal field values in the database and the headings in the csv are not quite the same.
    protected Map<String, String> pollutant_names = new HashMap<>(Map.of("PM10","pm10", "PM5", "pm5", "PM2.5", "pm2_5", "NO2", "no2", "VOCs", "voc"));
    
	/**
	 * @param conn
	 * @param database
	 * @param user
	 * @param password
	 * @param encrypt
	 * @param trustSC
	 * @param lITO
	 * @param tableName
	 * @param valueField
	 */
	public ZephyrDataCollector(String conn, String database, String user, String password, String encrypt,
			String trustSC, String lITO, String tableName, String valueField) 
	{
		// set up the connection string for the database
		this.databaseConnectionString = conn 
				+ "database=" + database + ";"
				+ "user=" + user + ";"
				+ "password=" + password + ";"
				+ "encrypt=" + encrypt + ";"
				+ "trustServerCertificate=" + trustSC + ";"
				+ "loginTimeout=" + lITO + ";";

		this.setTableName(tableName);
		this.setValueField(valueField);
	}
    		
	public String fetchAndPrepareZipDataFileFromEmail (String sensorID, String dataFileLocation) 
	{
		String newFileLocation = null;
		// this function (code and imports not shown) 
		// - checks for a zip file attached to the user's email, and 
		// - moves it to the location named in the variable 'dataFileLocation' for processing. 
		// - unzips the data, 
    	// - checks the csv column headers against the key values in the Map 'csvToDB'
    	// You can assume that any I/O exceptions are handled and thrown, and that the file correctly overwrites any existing file on the same name.
    	// If all goes successfully, this function will return the location of the unzipped file, otherwise 'null'.
		return newFileLocation;
	}
    
    public String removeOutliersFromFile (String dataFileLocation, float minAcceptable, float maxAcceptable) 
  	{
    	String newFileLocation = null;
  		// this function (code and imports not shown) 
    	// - checks all the rows of the file for any values which are outside the range 'minAcceptable' to 'maxAcceptable'
    	// - writes out a new file where any outlier values are replaced with 'null'
    	// If all goes successfully, this function will return the path to the cleaned data file, otherwise null
    	return newFileLocation;
  	}
    
    public boolean writeDataToDB (String fileToStore, String dbTableName) 
	{
    	boolean success = false;
		// this function (code and imports not shown) 
		// - manages, checks, opens and closes the connection to the database, using the variable 'databaseConnectionString'
    	// - writes the data from the array to the database, using 
    	// --- the class variable 'csvToDB' to define column names
    	// --- the class variable 'tableName' to define the database table
    	// --- the class variable 'pollutant_names' to define the field value in the database field 'pollutant'. 
    	// If a null value is found for a pollutant, that row is not written to the database.
    	// You can assume that any SQL or I/O exceptions are handled
    	// If all goes successfully, this function will return 'true' otherwise 'false'
    	return success;
	}

	/**
	 * @return the valueField. Usually this is 'measurement_value'
	 */
	public String getValueField() {
		return valueField;
	}

	/**
	 * @param valueField the valueField to set
	 */
	public void setValueField(String valueField) {
		this.valueField = valueField;
	}

	/**
	 * @return the tableName
	 */
	public String getTableName() {
		return tableName;
	}

	/**
	 * @param tableName the tableName to set. Usually this is 'sensor_measurements'
	 */
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
}
