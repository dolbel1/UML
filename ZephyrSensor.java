
package airquality.sensors;

/**
 * @author amir_a, adapted by claire_c
 *
 */
public class ZephyrSensor extends GenericSensor {

	// variables not shown (e.g., format for timestamps etc.)
	
	public ZephyrSensor(String sid, String sensorType) {
		super(sensorType);
		this.setSensorID(sid);
	}

	// other methods and variables not shown (e.g., the method for regularly emailing data files)


}