/**
 * 
 */
package airquality.sensors;

/**
 * @author claire_c
 *
 */

public abstract class GenericSensor {
	
	// Unique ID of this sensor - e.g. 'Z443'
	private String sensorID;
	
	// Type of this sensor - e.g. 'PLUME', 'ZEPHYR' or 'SC'
	private String sensorType;
		
	// The email of the manager who is responsible for this network of sensors.
	private String sensorManagerEmail;
		
	public GenericSensor(String sensorType) {
		
		this.sensorType = sensorType;
	}

	
	/**
	 * @return the email address of the manager who is responsible for this network of sensors
	 */
	public String getEmail() {
		return sensorManagerEmail;
	}

	/**
	 * @param sensorManagerEmail the email address of the manager who is responsible for this network of sensors
	 */
	public void setEmail(String sensorManagerEmail) {
		this.sensorOwnerEmail = sensorManagerEmail;
	}

	/**
	 * @return the sensorID
	 */
	public String getSensorID() {
		return sensorID;
	}

	/**
	 * @param sensorID the sensorID to set
	 */
	public void setSensorID(String sensorID) {
		this.sensorID = sensorID;
	}

	// other getters and setters implemented but not shown here

}
