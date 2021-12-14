/**
 * 
 */
package airquality.sensors;

import java.io.BufferedReader;
// other imports for reading bytearrays and streams not shown

import airquality.SensorManager;

/**
 * @author claire_c
 *
 */
public class SCSensor extends GenericSensor {

	// the unique id of this sensor (internal functions require that this is stored as an integer)
	private int scSensorID;

	// the SensorManager instance which is managing this sensor. 
	private SensorManager sensorManager;
	
	// other variables not shown (e.g., format for timestamps etc.)

	/**
	 * 
	 */
	public SCSensor(String sid, String sensorType, SensorManager sm) {
		super(sensorType);
		this.setSensorID(sid);
		this.setSm(sm);
	}

	public BufferedReader getStoredData()
	{
		BufferedReader br=null;
		// This function (code not shown) gets the stored data on the sensor and returns a Buffered Reader
		// which can be used by the calling class to step through the data line by line.
		return br;
	}
	
	public void clearStoredData()
	{
		// This function (code not shown) clears the stored data on the sensor.
		// It should only be called when you are sure that the data has been safely archived elsewhere, or is no longer needed.
	}

	@Override
	public String getSensorID() {
		String strSensorID = String.valueOf(scSensorID);
		return strSensorID;
	}

	@Override
	public void setSensorID(String sensorID) {
		try{
			this.scSensorID = Integer.parseInt(sensorID);
        }
        catch (NumberFormatException ex){
            // handle the exception appropriately (code not shown)
        }
	}
	
	/**
	 * @return the SensorManager instance responsible for this sensor
	 */
	public SensorManager getSm() {
		return this.sensorManager;
	}

	/**
	 * @param sm the SensorManager instance responsible for this sensor
	 */
	public void setSm(SensorManager sm) {
		this.sensorManager = sm;
	}
}
