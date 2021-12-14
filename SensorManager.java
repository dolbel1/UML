/**
 * 
 */
package airquality;

import java.util.Enumeration;
import java.util.Vector;

import airquality.sensors.GenericSensor;

/**
 * @author danila_d
 * A class which manages all the sensors, and schedules the collection of data from each one.
 * It uses the three DataCollector classes to get data for the three different sensor types.
 * It also makes sure that every sensor in the network knows the email address to which data or fault reports must be sent.
 *
 */
public class SensorManager {

	public SensorManager() {
		// constructor code not shown
	}

	private Vector<GenericSensor> sensorList;
	
	// code for adding and removing sensors from this list not shown
	// NB - when an SCSensor is added, it will store a reference to this SensorManager instance.
	// This is because in the past, the SCSensor used to call some SensorManager functions, but that code has now been removed.
	
	/**
	 * A function for updating the owner email on a sensor. All sensors need to know this email address.
	 * The Zephyr sensors use it to send regular data dumps, while the other sensors use it only for fault reporting.
	 *
	 */
	public void updateManagerEmail(String e, GenericSensor s)
	{
		s.setEmail(e);
	}
	
	// other code for scheduling and retrieving sensor data not shown
}
