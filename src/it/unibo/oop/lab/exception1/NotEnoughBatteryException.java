package it.unibo.oop.lab.exception1;

/**
 * Represents an exception occurring when a robot overcomes the capacity of
 * its battery.
 * 
 */
public class NotEnoughBatteryException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final double batteryLevel;
	private final double batteryRequired;
	

    public NotEnoughBatteryException(double batteryLevel, double batteryRequired) {
    	super();
		this.batteryLevel = batteryLevel;
		this.batteryRequired = batteryRequired;
	}

	/**
     * 
     * @return the string representation of instances of this class
     */
    @Override
    public String toString() {
        return "Can not move, the battery level is" + this.batteryLevel +
        		"and the battery required is" + this.batteryRequired;
    }

    @Override
    public String getMessage() {
        return this.toString();
    }
}
